package com.fehead.anonymous.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.error.EmBusinessError;
import com.fehead.anonymous.model.UserMeModel;
import com.fehead.anonymous.model.UserModel;
import com.fehead.anonymous.model.YbReturnModel;
import com.fehead.anonymous.response.CommonReturnType;
import com.fehead.anonymous.service.CloudService;
import com.fehead.anonymous.util.PostUtil;
import com.fehead.anonymous.util.UnicodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/10/14 20:12
 */
@RestController
@RequestMapping("/api/v1.0/login")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private static final String backurl = "http://192.168.0.110:8081/blank";

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PostUtil postUtil;
    @Autowired
    private UnicodeUtil unicodeUtil;
    @Autowired
    private CloudService cloudService;

    /**
     * 获取 access_token 并跳转至信息补充界面
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping("/oauth")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CommonReturnType oauth(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.info("开始获取access_token...");
        String getTokenUrl = "http://nightnessss.cn:8018/page/oauth?callback=" + backurl;
//        response.sendRedirect(getTokenUrl);
        Map<String,String> data = new HashMap<>();
        data.put("url",getTokenUrl);
        return CommonReturnType.creat(data);
    }

    @GetMapping("/login")
    public CommonReturnType login(HttpServletRequest request, HttpServletResponse response) throws IOException, BusinessException {

        HttpSession session = request.getSession();
        String accessToken = request.getParameter("access_token");
        logger.info("access_token:" + accessToken);
        if (accessToken == null || accessToken.isEmpty()) {
            logger.info("access_token为空");
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "access_token为空");
        }
        String getUserInfo = "https://openapi.yiban.cn/user/me?" +
                "access_token=" + accessToken;

        session.setAttribute("access_token", accessToken);
        String userInfo = postUtil.sendGet(getUserInfo);
        YbReturnModel ybReturnModel = new YbReturnModel();
        try {
            ybReturnModel = objectMapper.readValue(userInfo, YbReturnModel.class);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATA_SELECT_ERROR);
        }
        UserMeModel userMeModel = ybReturnModel.getInfo();
        String thirdPartyId = userMeModel.getYb_userid();
        UserModel userModel = cloudService.alreadyLogin(thirdPartyId);
        if (userModel != null) {
//            session.setAttribute("userId", userModel.getId());
            return CommonReturnType.creat(userModel);
        }
        String displayName = unicodeUtil.unicode2String(userMeModel.getYb_usernick());
        String avatar = unicodeUtil.unicode2String(userMeModel.getYb_userhead());
        userModel = new UserModel(displayName, avatar, thirdPartyId);

        int id = cloudService.addUser(userModel);
        userModel.setUserId(id);

        return CommonReturnType.creat(userModel);
    }


}
