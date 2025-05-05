package com.budgyeti.budgyeti.controller.dashboard.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@IdClass(BudgetMaterialId.class) 
public class BudgetMaterial {

    @Id
    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @Id
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;

    private BigDecimal quantity;

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
