package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemRepository;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroup;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
class ItemControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ItemsGroupRepository groupRepository;

    @Test
    void httpGet_readItemById() throws Exception {
        ItemsGroup group = groupRepository.findById(1).orElse(null);
        System.out.println(group);


        int id = repository.save(new Item("foo", 5.5f, "boo", group)).getId();

        mockMvc.perform(get("/items/" + id))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().string(containsString("foo")));
    }
}