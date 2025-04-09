package com.ccsw.tutorial.Loan.service;

import com.ccsw.tutorial.Author.model.Author;
import com.ccsw.tutorial.Author.model.AuthorSearchDto;
import com.ccsw.tutorial.Loan.model.Loan;
import com.ccsw.tutorial.Loan.model.LoanDto;
import com.ccsw.tutorial.Loan.model.LoanSearchDto;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface LoanService {

    List<Loan> find(Long client_id, Long game_id, Date start_date, Date end_date);

    Loan save(Long id, LoanDto dto);

    void delete(Long id);

    Page<Loan> findPage(LoanSearchDto dto);
}
