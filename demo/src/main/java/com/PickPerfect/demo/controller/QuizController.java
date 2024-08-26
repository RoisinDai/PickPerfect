package com.PickPerfect.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PickPerfect.demo.model.QuestionWrapper;
import com.PickPerfect.demo.model.QuizSubmission;
import com.PickPerfect.demo.dao.QuestionDao;
import com.PickPerfect.demo.model.Question;
import com.PickPerfect.demo.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionDao questionDao;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,
            @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    // @PostMapping("submit/{quizId}")
    // public ResponseEntity<Integer> submitQuiz(@PathVariable("quizId") Integer id,
    // @RequestBody List<Response> responses) {
    // return quizService.calculateResult(id, responses);
    // }

    @PostMapping("submit")
    public ResponseEntity<Integer> submitQuiz(@RequestBody QuizSubmission quizSubmission) {
        List<Question> questions = questionDao.findAllById(quizSubmission.getQuestionIds());
        int score = quizService.calculateResult(questions, quizSubmission.getUserResponses());
        return ResponseEntity.ok(score);
    }

    @GetMapping("get-questions")
    public ResponseEntity<List<QuestionWrapper>> getRandomQuestions(@RequestParam String category,
            @RequestParam String difficulty) {
        List<QuestionWrapper> questions = quizService.getRandomQuestions(category, difficulty, 5);
        return ResponseEntity.ok(questions);
    }

}
