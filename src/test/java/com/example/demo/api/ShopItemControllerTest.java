package com.example.demo.api;

import com.example.demo.domain.ShopItemDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopItemControllerTest {
    private final String GET_ONE_ITEM = "/item";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldAddOneShopItem() throws Exception {
        ShopItemDomain shopItemDomain = new ShopItemDomain("cola", 20, "瓶", "url");
        String jsonStr = objectMapper.writeValueAsString(shopItemDomain);
        mockMvc.perform(post(GET_ONE_ITEM)
                .content(jsonStr)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }
}