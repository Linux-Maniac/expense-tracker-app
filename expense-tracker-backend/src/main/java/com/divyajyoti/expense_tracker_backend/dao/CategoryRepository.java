package com.divyajyoti.expense_tracker_backend.dao;

import com.divyajyoti.expense_tracker_backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
