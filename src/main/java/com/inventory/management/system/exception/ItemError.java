package com.inventory.management.system.exception;


public enum ItemError {

    OK(200, "Success"),
    NOT_FOUND(404, "Resource not found"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    PRODUCT_NOT_FOUND(410,"Product not found"),
    PRODUCT_OUT_OF_STOCK(415,"Product out of stock "),
    ;

    private final int code;
    private final String message;

    ItemError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
