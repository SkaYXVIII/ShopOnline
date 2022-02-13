package com.girhub.SkaYXVIII.ShopOnline.logic;

import com.girhub.SkaYXVIII.ShopOnline.model.Item;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemForm;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroup;
import com.girhub.SkaYXVIII.ShopOnline.model.ItemsGroupRepository;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemServiceTest {

    @Test
    void registerItem() {
        InMemoryGroupRepository inMemoryGroupRepository = new InMemoryGroupRepository();
        ItemsGroup group = new ItemsGroup();

        var mockGroupRepository = mock(ItemsGroupRepository.class);
        when(mockGroupRepository.save(group))
                .thenReturn(inMemoryGroupRepository.save(group));
        when(mockGroupRepository.findById(group.getId()))
                .thenReturn(inMemoryGroupRepository.findById(group.getId()));

        mockGroupRepository.save(group);

        ItemService testingService = new ItemService(null, mockGroupRepository);

        ItemForm form = new ItemForm();
        form.setGroup(1);

        Item result = testingService.registerItem(form);

        assertEquals(result.getGroup().getId(), 1);

    }

    private static class InMemoryGroupRepository {
        private int index = 0;
        private Map<Integer, ItemsGroup> map = new HashMap<>();

        private List<ItemsGroup> findAll() {
            return new ArrayList<>(map.values());
        }

        private Optional<ItemsGroup> findById(Integer id) {
            return Optional.ofNullable(map.get(id));
        }

        private ItemsGroup save(ItemsGroup entity) {
            if (entity.getId() == 0) {
                try {
                    var field = ItemsGroup.class.getDeclaredField("id");
                    field.setAccessible(true);
                    field.set(entity, ++index);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            map.put(entity.getId(), entity);
            return entity;
        }
    }

}