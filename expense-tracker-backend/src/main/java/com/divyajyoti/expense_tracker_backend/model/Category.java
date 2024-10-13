package com.divyajyoti.expense_tracker_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Table(name = "CATEGORY")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CATEGORY_NAME")
    @NonNull
    private String name;

}
