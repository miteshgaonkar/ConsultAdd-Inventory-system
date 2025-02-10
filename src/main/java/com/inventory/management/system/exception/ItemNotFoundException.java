package com.inventory.management.system.exception;

public class ItemNotFoundException extends RuntimeException{

    private final ItemError error;

    public ItemNotFoundException(String message, ItemError error){
        super(message);
        this.error = error;
    }

    public ItemNotFoundException(ItemError error) {
        super(error.getMessage());
        this.error = error;
    }

    public ItemError getError() { return this.error; }

}
