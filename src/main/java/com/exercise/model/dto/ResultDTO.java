package com.exercise.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResultDTO {
    private String type;
    private String difficulty;
    private String question;
    @Builder.Default
    private List<String> all_answers=new ArrayList<>();
    private String correct_answer;
}
