package com.github.youssfbr.expense.dtos;

import com.github.youssfbr.expense.entities.Category;

public record CategoryResponseDTO(Long id , String name) {

    public CategoryResponseDTO(Category entity) {
        this(
                entity.getId() ,
                entity.getName()
        );
    }
}
