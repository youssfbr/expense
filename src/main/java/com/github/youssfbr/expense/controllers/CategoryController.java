package com.github.youssfbr.expense.controllers;

import com.github.youssfbr.expense.dtos.CategoryCreateRequestDTO;
import com.github.youssfbr.expense.dtos.CategoryResponseDTO;
import com.github.youssfbr.expense.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryCreateRequestDTO categoryCreateRequestDTO) {

        CategoryResponseDTO categoryCreated = categoryService.createCategory(categoryCreateRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoryCreated.id())
                .toUri();

        return ResponseEntity.created(location).body(categoryCreated);
    }

}
