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
    private Integer Id;

    @Column(name = "CATEGORY_NAME")
    @NonNull
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private User user;

}
