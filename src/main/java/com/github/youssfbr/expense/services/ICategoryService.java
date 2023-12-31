package com.github.youssfbr.expense.services;

import com.github.youssfbr.expense.dtos.CategoryCreateRequestDTO;
import com.github.youssfbr.expense.dtos.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO> findAll();
    CategoryResponseDTO createCategory(CategoryCreateRequestDTO categoryCreateRequestDTO);
}
