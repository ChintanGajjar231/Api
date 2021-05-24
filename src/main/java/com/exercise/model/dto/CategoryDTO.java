package com.exercise.model.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
    private String category;
    @Builder.Default
    private List<ResultDTO> results= new ArrayList<>();

    public void addResults(ResultDTO result) {
        this.results.add(result);
    }
}
