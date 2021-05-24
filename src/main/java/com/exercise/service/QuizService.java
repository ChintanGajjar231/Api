package com.exercise.service;

import com.exercise.model.Category;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuizService {
    private final RestTemplate restTemplate;


    public QuizService() {
        this.restTemplate = new RestTemplate();
    }

    public Category getQuizAsPlainJSON(int i) {
        String url = "https://opentdb.com/api.php?amount=5&category={i}";
        return this.restTemplate.getForObject(url, Category.class, i);
    }
}
