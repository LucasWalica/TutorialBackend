package com.ccsw.tutorial.Loan.repository;

import com.ccsw.tutorial.Loan.model.Loan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long>, JpaSpecificationExecutor<Loan> {

    @Override
    @EntityGraph(attributePaths = {"client_id", "game_id", "start_date", "end_date"})
    List<Loan> findAll(Specification<Loan> spec);
}
