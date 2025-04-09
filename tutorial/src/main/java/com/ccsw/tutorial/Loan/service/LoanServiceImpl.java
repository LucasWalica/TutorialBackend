package com.ccsw.tutorial.Loan.service;

import com.ccsw.tutorial.Game.service.GameService;
import com.ccsw.tutorial.Loan.model.Loan;
import com.ccsw.tutorial.Loan.model.LoanDto;
import com.ccsw.tutorial.Loan.model.LoanSearchDto;
import com.ccsw.tutorial.Loan.repository.LoanRepository;
import com.ccsw.tutorial.Loan.specification.LoanSpecification;
import com.ccsw.tutorial.client.services.ClientService;
import com.ccsw.tutorial.common.criteria.SearchCriteria;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    GameService gameService;


    @Override
    public List<Loan> find(Long client_id, Long game_id, Date start_date, Date end_date) {

        LoanSpecification clientSpec = new LoanSpecification(new SearchCriteria("client.id", ":", client_id));
        LoanSpecification gameSpec = new LoanSpecification(new SearchCriteria("game.id", ":", game_id));
        LoanSpecification startDateSpec = new LoanSpecification(new SearchCriteria("start_date", "<=", start_date));
        LoanSpecification endDateSpec = new LoanSpecification(new SearchCriteria("end_date", ">=", end_date));

        Specification<Loan> spec = Specification.where(clientSpec)
                .and(gameSpec)
                .and(startDateSpec)
                .and(endDateSpec);

        return this.loanRepository.findAll(spec);
    }

    @Override
    public Loan save(Long id, LoanDto dto) {

        Loan loan;

        if(id==null){
            loan = new Loan();
        }else {
            loan = this.loanRepository.findById(id).orElse(null);
        }

        BeanUtils.copyProperties(dto, loan, "id", "game_id", "client_id", "start_date", "end_date");
        loan.setGame(gameService.getByDto(dto.getGame()));
        loan.setClient(clientService.getByDto(dto.getClient()));
        loan.setStartDate(dto.getStartDate());
        loan.setEndData(dto.getEndDate());
        this.loanRepository.save(loan);
        return loan;
    }

    @Override
    public void delete(Long id) {
        this.loanRepository.delete(loanRepository.findById(id).orElse(null));
    }

    @Override
    public Page<Loan> findPage(LoanSearchDto dto) {
        return this.loanRepository.findAll(dto.getPageable().getPageable());
    }
}
