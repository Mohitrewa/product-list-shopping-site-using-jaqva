package com.springboot.exceptionhandling.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.exceptionhandling.exceptions.ItemNotFoundException;
import com.springboot.exceptionhandling.models.Item;

@Repository
public class ItemRepository {
    @Autowired
    JdbcTemplate template;

    public List<Item> getAllItems() {
        List<Item> items = template.query("SELECT id, name, category FROM item", (result, rowNum) -> new Item(result.getInt("id"), result.getString("category"), result.getString("name")));
        return items;
    }

    public Item getItem(int itemId){
        Item item = null;
        String query = "select * form item where id = ?";
        try{
            item = template.queryForObject(query, new Object[]{itemId}, new BeanPropertyRowMapper<>(Item.class));
            
        }catch(Exception e){
            throw new ItemNotFoundException("Item Not Found" + itemId);
        }
        
        return item;
    }

    public void addItem(Item item){
        String query = "INSERT INTO item VALUES (? , ? , ?)";
        template.update(query, new Object[]{
            Integer.valueOf(item.getId()), item.getname(), item.getCategory()});
    }

    public int deleteItem(int id){
        Item item = null;
        String query = "DELETE FROM item where id =?";
        int size = template.update(query, id);
        if(size == 0){
            throw new ItemNotFoundException("No item found to delete" + id);
        }
        return size;
    }

    public void updateItem(Item item){
        String query = "UPDATE item SET name = ?, category = ? WHERE id = ?";
        template.update(query, new Object[]{Integer.valueOf(item.getId())});
    }

}
