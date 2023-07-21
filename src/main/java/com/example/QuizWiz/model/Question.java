package com.example.QuizWiz.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "questions")
public class Question {

    @Id
    private ObjectId id;

    @Field("question_title")
    private String questionTitle;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    @Field("right_answer")
    private String rightAnswer;

    @Field("difficulty_level")
    private String difficultyLevel;

    private String category;

}
