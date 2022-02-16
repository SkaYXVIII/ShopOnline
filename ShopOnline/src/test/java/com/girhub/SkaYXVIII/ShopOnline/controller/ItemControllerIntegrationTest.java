package com.girhub.SkaYXVIII.ShopOnline.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.girhub.SkaYXVIII.ShopOnline.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

        int id = repository.save(new Item("foo", 5.5f, "boo", group)).getId();

        mockMvc.perform(get("/items/" + id))
                .andExpect(status().is2xxSuccessful())
                .andDo(print())
                .andExpect(content().string(containsString("foo")));
    }

    @Test
    void httpPost_createItem() throws Exception {
        ItemForm itemForm = new ItemForm();
        itemForm.setName("foo");
        itemForm.setDescription("bar");
        itemForm.setPrice(5.5f);
        itemForm.setGroup(1);

        mockMvc.perform(post("/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(itemForm)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("foo")));
    }

    private String toJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}