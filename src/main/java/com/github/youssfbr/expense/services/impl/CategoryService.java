package com.github.youssfbr.expense.services.impl;

import com.github.youssfbr.expense.dtos.CategoryResponseDTO;
import com.github.youssfbr.expense.repositories.ICategoryRepository;
import com.github.youssfbr.expense.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryResponseDTO::new)
                .toList();
    }
}
