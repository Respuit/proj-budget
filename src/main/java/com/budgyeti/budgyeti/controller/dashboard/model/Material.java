package com.budgyeti.budgyeti.controller.dashboard.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String unit;

    @OneToMany(mappedBy = "material")
    private List<BudgetMaterial> budgetMaterials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<BudgetMaterial> getBudgetMaterials() {
        return budgetMaterials;
    }

    public void setBudgetMaterials(List<BudgetMaterial> budgetMaterials) {
        this.budgetMaterials = budgetMaterials;
    }
}
