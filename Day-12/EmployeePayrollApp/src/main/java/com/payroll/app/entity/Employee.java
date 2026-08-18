package com.payroll.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

import java.math.BigDecimal;


@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "department")
    @NotBlank(message = "Department is required")
    private String department;

    @Column(name = "salary", nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "salary must be positive")
    private BigDecimal salary;
}
