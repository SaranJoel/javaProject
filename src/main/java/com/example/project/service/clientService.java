package com.example.project.service;

import com.example.project.dto.clientDto;
import com.example.project.model.client;

import java.util.List;

public interface clientService {

    clientDto save(clientDto clientD);
    List<clientDto> findAllClients();
    clientDto findClientById(int id);
    clientDto update(int client_id, clientDto clientD);
    void delete(int client_id);

}
