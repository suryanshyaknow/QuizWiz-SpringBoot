package com.example.QuizWiz.repository;

import com.example.QuizWiz.model.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, ObjectId> {

    List<Question> findByCategory(String category);

    List<Question> findTopByCategoryOrderByRandom(String category, int limit);
}
