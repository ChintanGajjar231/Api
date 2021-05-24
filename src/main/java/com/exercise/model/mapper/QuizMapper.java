package com.exercise.model.mapper;

import com.exercise.model.Category;
import com.exercise.model.Result;
import com.exercise.model.dto.CategoryDTO;
import com.exercise.model.dto.ResultDTO;

import java.util.List;

public class QuizMapper {
    public static CategoryDTO map(Category category) {
        List<Result> result = category.getResults();
        CategoryDTO categoryDto = CategoryDTO.builder().category(result.get(0).getCategory()).build();
        result.stream().map(QuizMapper::convertResult).forEach(categoryDto::addResults);
        return categoryDto;
    }

    private static ResultDTO convertResult(Result result) {
        List<String> allAnswer = result.getIncorrect_answers();
        allAnswer.add(result.getCorrect_answer());

        return ResultDTO.builder()
                .difficulty(result.getDifficulty())
                .question(result.getQuestion())
                .type(result.getType())
                .all_answers(allAnswer)
                .correct_answer(result.getCorrect_answer())
                .build();
    }


}
