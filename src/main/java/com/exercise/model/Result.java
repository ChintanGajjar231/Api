package com.exercise.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private List<String> incorrect_answers;
    private String correct_answer;
}
