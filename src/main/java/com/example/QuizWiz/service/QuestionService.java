package com.example.QuizWiz.service;

import com.example.QuizWiz.model.Question;
import com.example.QuizWiz.repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service // Just a different terminology for `@Component`
public class QuestionService implements IQuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Set<String> getAllCategories() {
        List<Question> allQuestions = getAllQuestions();

        // Stream over the list of Question objects and extract the category of each question
        // The map function transforms the stream of Question objects into a stream of category strings
        Stream<String> categoryStream = allQuestions.stream().map(Question::getCategory);

        return categoryStream.collect(Collectors.toSet());
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(ObjectId id) {
        questionRepository.deleteById(id);
    }

}

