package br.com.alura.forum.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaDevolver400CasoDadosDeAutenticacaoEstejamIncorretos() throws URISyntaxException {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"banana@gmail.com\", \"senha\":\"banana123\" }";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri))
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .andExpect(MockMvcResultMatchers
                                .status()
                                .is(400));
    }
}
