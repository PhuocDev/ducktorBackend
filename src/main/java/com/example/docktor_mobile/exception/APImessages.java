package com.example.docktor_mobile.exception;

import lombok.Data;

@Data
public class APImessages {
    private String message;

    public APImessages(String message) {
        this.message = message;
    }

    public APImessages() {
    }

}
