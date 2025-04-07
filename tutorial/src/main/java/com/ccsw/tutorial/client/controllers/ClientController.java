package com.ccsw.tutorial.client.controllers;

import com.ccsw.tutorial.client.model.ClientDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Client", description = "API of clients")
@RequestMapping(value = "/clients")
@RestController
@CrossOrigin(origins = "*")
public class ClientController {
    private long SEQUENCE = 1;
    private Map<Long, ClientDto> clients = new HashMap<>();


    @Operation(summary = "Find", description = "Method that returns a List of Clients")
    @RequestMapping(path="", method=RequestMethod.GET)
    public List<ClientDto> findAll(){
        return new ArrayList<ClientDto>(this.clients.values());
    }

    @Operation(summary = "Save or Update", description = "Method that saves or updates clients")
    @RequestMapping(path={"", "/{id}"}, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientDto dto){
        ClientDto client;

        if(id == null){
            client = new ClientDto();
            client.setId(this.SEQUENCE++);
            this.clients.put(client.getId(), client);
        }else {
            client = this.clients.get(id);
        }
        client.setName(dto.getName());
    }


    @Operation(summary = "Delete", description = "Method that allows to delete a Client")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        this.clients.remove(id);
    }

}
