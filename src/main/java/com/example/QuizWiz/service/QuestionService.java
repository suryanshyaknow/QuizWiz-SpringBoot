package com.example.QuizWiz.service;

import com.example.QuizWiz.model.Question;
import com.example.QuizWiz.repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Just a different terminology for `@Component`
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory() {
        return questionRepository.findByCategory();
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(ObjectId id) {
        questionRepository.deleteById(id);
    }
}
