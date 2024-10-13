package com.divyajyoti.expense_tracker_backend.service;

import com.divyajyoti.expense_tracker_backend.dao.CategoryRepository;
import com.divyajyoti.expense_tracker_backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    @Cacheable(value = "category", key = "#id")
    public Optional<Category> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @CachePut(value = "category", key = "#request.id")
    public Category createCategory(Category request) {
        return categoryRepository.save(request);
    }

    @CacheEvict(value = "category", key = "#id")
    public Category updateCategory(Category request, Integer id) {
        return categoryRepository.save(request);

    }

}
