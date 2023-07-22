package com.example.QuizWiz.model;


import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class QuestionResponse {

    private ObjectId id;
    private String response;

}
