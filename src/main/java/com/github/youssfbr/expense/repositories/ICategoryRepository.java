package com.github.youssfbr.expense.repositories;

import com.github.youssfbr.expense.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
