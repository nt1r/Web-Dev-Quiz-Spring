package com.example.demo.api;

import com.example.demo.domain.ShopItemDomain;
import com.example.demo.entity.ShopItemEntity;
import com.example.demo.repository.ShopItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopItemControllerTest {
    private final String POST_ONE_ITEM = "/item";
    private final String GET_ITEM_LIST = "/item/list";

    private final String COLA_URL = "https://d2wvksc3i53c0p.cloudfront.net/media/catalog/product/cache/2/image/85e4522595efc69f496374d01ef2bf13/1/1/11777.jpg";

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ShopItemRepository shopItemRepository;

    @BeforeEach
    void setUp() {
        shopItemRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldAddOneShopItem() throws Exception {
        ShopItemDomain shopItemDomain = new ShopItemDomain("cola", 20, "瓶", COLA_URL);
        String jsonStr = objectMapper.writeValueAsString(shopItemDomain);
        mockMvc.perform(post(POST_ONE_ITEM)
                .content(jsonStr)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllShopItemList() throws Exception {
        ShopItemEntity shopItemEntity1 = ShopItemEntity.builder()
                .name("cola1")
                .price(20)
                .unit("瓶")
                .url(COLA_URL)
                .build();
        ShopItemEntity shopItemEntity2 = ShopItemEntity.builder()
                .name("cola2")
                .price(30)
                .unit("瓶")
                .url(COLA_URL)
                .build();
        shopItemRepository.save(shopItemEntity1);
        shopItemRepository.save(shopItemEntity2);

        mockMvc.perform(get(GET_ITEM_LIST)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].name", is("cola1")))
                .andExpect(jsonPath("$.[0].price", is(20)))
                .andExpect(jsonPath("$.[1].name", is("cola2")))
                .andExpect(jsonPath("$.[1].price", is(30)));
    }
}