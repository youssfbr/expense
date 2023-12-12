package com.github.youssfbr.expense.entities;

import com.github.youssfbr.expense.dtos.CategoryCreateRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "tb_category")
@EqualsAndHashCode(of = "id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 50, nullable = false)
    private String name;

    public Category(CategoryCreateRequestDTO categoryCreateRequestDTO) {
        name = categoryCreateRequestDTO.name();
    }

    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    @PrePersist
    private void prePersist() {
        active = Boolean.TRUE;
        createdAt = Instant.now();
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = Instant.now();
    }
}
