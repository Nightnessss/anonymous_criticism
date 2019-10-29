package com.fehead.anonymous;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @program: anonymous_criticism
 * @author: PangChenBo
 * @create: 2019-08-19 11:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {
    @Autowired
    WebApplicationContext applicationContext;

    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    /**
     * 测试插入评论
     * @throws Exception
     */
    @Test
    public void whenInsertSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1.0/model/comment/1")
                        .param("commentContent","5")
                        .param("userId","0")
                        .param("isAnonymous","true"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
    /**
     *  测试通过Id查询评论
     */

    @Test
    public void whenGetCommentByIdSuccess() throws Exception {
        String result = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1.0/model/comment/1"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
}
