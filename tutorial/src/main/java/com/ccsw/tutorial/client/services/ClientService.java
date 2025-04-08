package com.ccsw.tutorial.client.services;

import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;

import java.util.List;

public interface ClientService {


    Client getByDto(ClientDto dto);

    Client get(Long id);

    Iterable<Client> findAll();

    void save(Long id, ClientDto dto);

    void delete(Long id) throws Exception;


}
