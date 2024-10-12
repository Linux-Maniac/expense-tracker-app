package com.divyajyoti.expense_tracker_backend.rest.controller;

import com.divyajyoti.expense_tracker_backend.dao.CategoryRepository;
import com.divyajyoti.expense_tracker_backend.model.Category;
import com.divyajyoti.expense_tracker_backend.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/category/{id}")
    ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        Optional<Category> optionalCategory = categoryService.getCategory(id);
        return optionalCategory.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Validated @RequestBody Category request) throws URISyntaxException {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    @PutMapping("category/{id}")
    ResponseEntity<Category> updateCategory(@Validated @RequestBody Category request, @PathVariable Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent())
            return ResponseEntity.ok(categoryService.updateCategory(request, id));
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
