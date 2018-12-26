package com.projects.core.utils;

public enum SuccessCodes implements com.projects.core.datatypes.enumInterfaces.SuccessCodes {
    CREATED("CREATED", "Created"),
    SUCCESSFULLY_UPDATED("SUCCESSFULLY_UPDATED", "Updated"),
    OK("OK", "Ok");

    private String code;
    private String description;

    private SuccessCodes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
