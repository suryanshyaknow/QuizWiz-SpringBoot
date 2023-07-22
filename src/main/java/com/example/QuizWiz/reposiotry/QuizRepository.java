package com.example.QuizWiz.reposiotry;

import com.example.QuizWiz.model.Quiz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuizRepository extends MongoRepository<Quiz, ObjectId> {

    Optional<Quiz> findById(Integer id);
}
