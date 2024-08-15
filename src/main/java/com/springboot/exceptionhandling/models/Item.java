package com.springboot.exceptionhandling.models;

import jakarta.persistence.Entity;


public class Item {
    private int id;
    private String category;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getname(){
        return name;
    }

    public Item(int id, String name, String category){}
    
}
