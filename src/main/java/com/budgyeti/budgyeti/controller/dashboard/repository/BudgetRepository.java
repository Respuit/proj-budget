package com.budgyeti.budgyeti.controller.dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.budgyeti.budgyeti.controller.dashboard.model.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
