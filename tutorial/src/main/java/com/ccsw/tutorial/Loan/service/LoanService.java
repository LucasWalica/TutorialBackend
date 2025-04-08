package com.ccsw.tutorial.Loan.service;

import com.ccsw.tutorial.Loan.model.Loan;
import com.ccsw.tutorial.Loan.model.LoanDto;

import java.util.Date;
import java.util.List;

public interface LoanService {

    List<Loan> find(Long client_id, Long game_id, Date start_date, Date end_date);

    void save(Long id, LoanDto dto);

}
