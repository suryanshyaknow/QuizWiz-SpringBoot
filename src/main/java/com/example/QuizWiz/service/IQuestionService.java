package com.example.QuizWiz.service;

import com.example.QuizWiz.model.Question;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Set;

public interface IQuestionService {

    public List<Question> getAllQuestions();

    public Set<String> getAllCategories();

    public List<Question> getQuestionsByCategory(String category);

    public Question addQuestion(Question question);

    public void deleteQuestion(ObjectId id);

}
