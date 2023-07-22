package com.example.QuizWiz.controller;

import com.example.QuizWiz.model.QuestionResponse;
import com.example.QuizWiz.model.QuestionWrapper;
import com.example.QuizWiz.service.IQuizService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private IQuizService quizService;

    @PostMapping("createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        try {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.OK);
        }
    }

    @GetMapping("getQuizQuestions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        try {
            return new ResponseEntity<List<QuestionWrapper>>(quizService.getQuizQuestions(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("submitResponses")
    public ResponseEntity<Integer> submitResponses(@PathVariable ObjectId id, @RequestBody List<QuestionResponse> responses) {
        try {
            return new ResponseEntity<>(quizService.computeResult(id, responses), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
