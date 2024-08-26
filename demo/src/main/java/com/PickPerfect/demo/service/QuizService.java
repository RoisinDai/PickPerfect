package com.PickPerfect.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.PickPerfect.demo.dao.QuestionDao;
import com.PickPerfect.demo.dao.QuizDao;
import com.PickPerfect.demo.model.Question;
import com.PickPerfect.demo.model.QuestionWrapper;
import com.PickPerfect.demo.model.Quiz;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();

        // convert question into questionWrapper
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
                    q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }
        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    // public ResponseEntity<Integer> calculateResult(Integer id, List<Response>
    // responses) {
    // Quiz quiz = quizDao.findById(id).get();
    // List<Question> questions = quiz.getQuestions();
    // int right = 0; // right answer number
    // int i = 0; // loop counter
    // for (Response response : responses) {
    // if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
    // right++;
    // }
    // i++;
    // }
    // return new ResponseEntity<>(right, HttpStatus.OK);
    // }

    // public int calculateResult(List<Question> questions, List<String>
    // userResponses) {
    // int correctAnswers = 0;

    // for (int i = 0; i < userResponses.size(); i++) {
    // String correctAnswer = questions.get(i).getRightAnswer();
    // if (correctAnswer == null) {
    // System.out.println("Question ID: " + questions.get(i).getId() + " has a null
    // rightAnswer");
    // } else if (correctAnswer.equals(userResponses.get(i))) {
    // correctAnswers++;
    // }
    // // if (questions.get(i).getRightAnswer().equals(userResponses.get(i))) {
    // // correctAnswers++;
    // // }
    // }

    // return correctAnswers;
    // }

    public int calculateResult(List<Question> questions, List<String> userResponses) {
        int correctAnswers = 0;

        for (int i = 0; i < userResponses.size(); i++) {
            if (questions.get(i).getRightAnswer().equals(userResponses.get(i))) {
                correctAnswers++;
            }
        }

        return correctAnswers;
    }

    public List<QuestionWrapper> getRandomQuestions(String category, String difficulty, int numQuestions) {
        List<Question> randomQuestions = questionDao.findRandomQuestionsByCategoryAndDifficulty(category, difficulty,
                numQuestions);
        List<QuestionWrapper> questionWrappers = new ArrayList<>();

        for (Question q : randomQuestions) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
                    q.getOption3(), q.getOption4());
            questionWrappers.add(qw);
        }

        return questionWrappers;
    }

}
