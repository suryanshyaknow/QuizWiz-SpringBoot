package com.example.QuizWiz.service;

import com.example.QuizWiz.model.Question;
import com.example.QuizWiz.model.QuestionResponse;
import com.example.QuizWiz.model.QuestionWrapper;
import com.example.QuizWiz.model.Quiz;
import com.example.QuizWiz.reposiotry.QuizRepository;
import com.example.QuizWiz.repository.QuestionRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService implements IQuizService {

    private final QuestionRepository questionRepository;

    private final QuizRepository quizRepository;

    public QuizService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @Override
    public String createQuiz(String category, int numQ, String title) {

        try {
            // Fetch random questions
            List<Question> questions = questionRepository.findTopByCategoryOrderByRandom(category, numQ);

            // Create a new Quiz
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizRepository.save(quiz);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed to create thew new quiz, god knows!";
        }
    }

    @Override
    public List<QuestionWrapper> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question question : questionsFromDB) {
            QuestionWrapper questionForUser = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            questionsForUser.add(questionForUser);
        }
        return questionsForUser;
    }

    @Override
    public Integer computeResult(ObjectId id, List<QuestionResponse> responses) {

        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int score = 0;

        int questionIdx = 0;
        for (QuestionResponse response : responses) {
            if (response.getResponse().equals(questions.get(questionIdx).getRightAnswer()))
                score += 1;
            questionIdx++;
        }
        return score;
    }
}
