package com.example.QuizWiz.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Quiz")
@Data
public class Quiz {

    @Id
    private ObjectId id;

    private String title;

    private List<Question> questions;

}
