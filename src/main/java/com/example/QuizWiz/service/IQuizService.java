package com.example.QuizWiz.service;

import com.example.QuizWiz.model.QuestionResponse;
import com.example.QuizWiz.model.QuestionWrapper;
import org.bson.types.ObjectId;

import java.util.List;

public interface IQuizService {

    public String createQuiz(String category, int numQ, String title);

    public List<QuestionWrapper> getQuizQuestions(Integer id);

    public Integer computeResult(ObjectId id, List<QuestionResponse> responses);
}
