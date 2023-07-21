package com.example.QuizWiz.controller;

import com.example.QuizWiz.model.Question;
import com.example.QuizWiz.service.QuestionService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("questionsByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory() {
        try {
            return new ResponseEntity<>(questionService.getQuestionsByCategory(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed to add question", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("deleteQuestion")
    public ResponseEntity<String> deleteQuestion(@RequestParam ObjectId id) {
        try {
            questionService.deleteQuestion(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed to add question", HttpStatus.BAD_REQUEST);
    }


}
