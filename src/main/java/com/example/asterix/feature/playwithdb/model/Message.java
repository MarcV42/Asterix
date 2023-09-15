package com.example.asterix.feature.playwithdb.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class Message
{
    @MongoId
    private String id;

    private String message;
}
