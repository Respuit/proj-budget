package com.budgyeti.budgyeti.controller.dashboard.model;

import java.io.Serializable;
import java.util.Objects;

public class BudgetMaterialId implements Serializable {

    private Long budget;
    private Long material;

    // Constructor vacío
    public BudgetMaterialId() {}

    // Constructor con los campos
    public BudgetMaterialId(Long budget, Long material) {
        this.budget = budget;
        this.material = material;
    }

    // Getters y setters
    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Long getMaterial() {
        return material;
    }

    public void setMaterial(Long material) {
        this.material = material;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BudgetMaterialId that = (BudgetMaterialId) o;
        return Objects.equals(budget, that.budget) && Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget, material);
    }
}
