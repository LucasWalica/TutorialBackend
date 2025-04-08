package com.ccsw.tutorial.client.services;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.ccsw.tutorial.client.model.Client;
import com.ccsw.tutorial.client.model.ClientDto;
import com.ccsw.tutorial.client.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@Transactional
public class ClientServiceImp implements ClientService{

    @Autowired
    ClientRepository clientRepository;


    @Override
    public Client getByDto(ClientDto dto) {
        return this.clientRepository.findById(dto.getId()).orElse(null);
    }

    @Override
    public Client get(Long id){
        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) this.clientRepository.findAll();
    }


    @Override
    public void save(Long id, ClientDto dto){
        Client client;


        // si existe el nombre no se deja añadir
        List<Client> clients = this.findAll();
        for(Client c : clients) {
            if (c.getName().equals(dto.getName())) {
                return;
            }
        }
        if(id == null){
            client = new Client();
        }else{
            client = this.get(id);
        }

        client.setName(dto.getName());
        this.clientRepository.save(client);
    }


    @Override
    public void delete(Long id) throws Exception {
        if (this.get(id) == null){
            throw  new Exception("not exists");
        }
        this.clientRepository.deleteById(id);
    }

}