package com.inventory.management.system.service;

import com.inventory.management.system.exception.ItemError;
import com.inventory.management.system.exception.ItemNotFoundException;
import com.inventory.management.system.model.Item;
import com.inventory.management.system.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return Optional.ofNullable(itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(ItemError.PRODUCT_NOT_FOUND)));
    }

    @Override
    public Item createItem(Item item) {
        try {
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new ItemNotFoundException(ItemError.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setQuantity(updatedItem.getQuantity());
            item.setPrice(updatedItem.getPrice());
            item.setDescription(updatedItem.getDescription());
            return itemRepository.save(item);
        }).orElseThrow(() -> new ItemNotFoundException(ItemError.PRODUCT_NOT_FOUND));
    }

    @Override
    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ItemNotFoundException(ItemError.PRODUCT_OUT_OF_STOCK);
        }
        itemRepository.deleteById(id);
    }
}
