package com.ccsw.tutorial.Loan.controller;


import com.ccsw.tutorial.Game.model.Game;
import com.ccsw.tutorial.Loan.model.Loan;
import com.ccsw.tutorial.Loan.model.LoanDto;
import com.ccsw.tutorial.Loan.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name="Loan", description = "API of loans")
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    ModelMapper mapper;

    /**
     * Método para recuperar una lista de {@link Loan}
     *
     * @param game_id
     * @param client_id
     * @param start_date
     * @param end_date
     * @return {@link  List } de {@link LoanDto}
     * */
    @Operation(summary = "Find", description = "Method that returns filtered list of loans")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<LoanDto> find(@RequestParam(value="game_id", required = false) Long game_id,
                              @RequestParam(value="client_id", required = false) Long client_id,
                              @RequestParam(value="start_date", required = false) Date start_date,
                              @RequestParam(value="end_date", required = false) Date end_date){

        List<Loan> loans = loanService.find(client_id, game_id, start_date, end_date);

        return loans.stream().map(e -> mapper.map(e, LoanDto.class)).collect(Collectors.toList());
    }
    /**
     * Método para crear o actualizar un {@link Loan}
     *
     * @param id PK de la entidad
     * @param dto datos de la entidad
     */
    @Operation(summary = "Save or Update", description = "Method that saves or update data from Loan")
    @RequestMapping(path = {"", "/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Loan> save(@PathVariable(name="id", required = false)Long id, @RequestBody LoanDto dto){
        Loan savedLoan = loanService.save(id, dto);
        return ResponseEntity.ok(savedLoan);
    }

    @Operation(summary = "Delete", description = "Method that deletes a Loan")
    @RequestMapping(path={"/{id}"}, method=RequestMethod.DELETE)
    public void delete(@PathVariable(name="id", required = true) Long id){
        this.loanService.delete(id);
    }
}
