package com.example.micro1.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Alert implements Serializable {
    private final int alertId;
    private String stageId;
    private final String alertLevel;
    private final String alertMessage;

    public Alert(int alertId,
                 String stageId,
                 String alertLevel,
                 String alertMessage) {
        this.alertId = alertId;
        this.stageId = stageId;
        this.alertLevel = alertLevel;
        this.alertMessage = alertMessage;
    }
}
