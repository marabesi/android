package com.example.pizza.api;

public class Payment {

    private long id;
    private String description;

    public Payment(long id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString()
    {
        return description;
    }
}
