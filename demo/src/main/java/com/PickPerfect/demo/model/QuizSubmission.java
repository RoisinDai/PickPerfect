package com.PickPerfect.demo.model;

import java.util.List;

public class QuizSubmission {
    private List<Integer> questionIds;
    private List<String> userResponses;

    public List<Integer> getQuestionIds() {
        return questionIds;
    }

    public List<String> getUserResponses() {
        return userResponses;
    }

}