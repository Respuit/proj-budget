package com.budgyeti.budgyeti.controller.dashboard.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "budget")
    private List<BudgetMaterial> budgetMaterials;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<BudgetMaterial> getBudgetMaterials() {
        return budgetMaterials;
    }

    public void setBudgetMaterials(List<BudgetMaterial> budgetMaterials) {
        this.budgetMaterials = budgetMaterials;
    }
}
