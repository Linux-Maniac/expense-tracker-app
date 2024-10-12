package com.divyajyoti.expense_tracker_backend.service;

import com.divyajyoti.expense_tracker_backend.dao.CategoryRepository;
import com.divyajyoti.expense_tracker_backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category request) {
        return categoryRepository.save(request);
    }

    public Category updateCategory(Category request, Integer id) {
        return categoryRepository.save(request);

    }

}
