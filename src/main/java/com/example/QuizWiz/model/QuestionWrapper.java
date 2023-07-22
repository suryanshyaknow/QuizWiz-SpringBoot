package com.example.QuizWiz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
public class QuestionWrapper {

    private ObjectId id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
