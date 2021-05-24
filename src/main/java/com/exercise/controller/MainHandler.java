package com.exercise.controller;

import com.exercise.model.Category;
import com.exercise.model.dto.CategoryDTO;
import com.exercise.model.dto.QuizDTO;
import com.exercise.model.mapper.QuizMapper;
import com.exercise.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
public class MainHandler {

    @Autowired
    QuizService quizService;

    @GetMapping("/coding/exercise/quiz")
    public QuizDTO getQuiz() {
        List<Integer> categories = Arrays.asList(11, 12);
        List<CompletableFuture<Category>> futures = new ArrayList<>();

        for (int i : categories) {
            futures.add(CompletableFuture.supplyAsync(() -> quizService.getQuizAsPlainJSON(i)));
        }
        List<CategoryDTO> categoryList = futures.stream().map(CompletableFuture::join)
                .map(QuizMapper::map)
                .collect(Collectors.toList());

        return new QuizDTO(categoryList);
    }
}
