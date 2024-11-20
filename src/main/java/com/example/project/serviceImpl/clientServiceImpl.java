package com.example.project.serviceImpl;

import com.example.project.mapper.clientMapper;
import com.example.project.dto.clientDto;
import com.example.project.model.client;
import com.example.project.repo.clientRepo;
import com.example.project.service.clientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class clientServiceImpl implements clientService {
    private final clientRepo ClientRepo;

    public clientServiceImpl(clientRepo ClientRepo) {
        this.ClientRepo = ClientRepo;
    }

    @Override
    public clientDto save(clientDto clientD) {
        client clientEntity = clientMapper.mapToclient(clientD);
        client savedClient = ClientRepo.save(clientEntity);
        return clientMapper.mapToclientDto(savedClient);
    }

    @Override
    public List<clientDto> findAllClients() {
        return ClientRepo.findAll().stream()
                .map(clientMapper::mapToclientDto)
                .collect(Collectors.toList());
    }

    @Override
    public clientDto findClientById(int id) {
        client clientEntity = ClientRepo.findById(id).orElse(null);
        return clientEntity != null ? clientMapper.mapToclientDto(clientEntity) : null;
    }

    @Override
    public clientDto update(int client_id, clientDto clientD) {
        client existingClient = ClientRepo.findById(client_id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        existingClient.setClient_name(clientD.getClient_name()); // Update fields based on your clientDto structure
        existingClient.setCompany_name(clientD.getCompany_name());
        existingClient.setClient_name(clientD.getClient_email());
        existingClient.setAddress(clientD.getAddress());
        existingClient.setPhone(clientD.getPhone());
        existingClient.setIndustry(clientD.getIndustry());


        client updatedClient = ClientRepo.save(existingClient);
        return clientMapper.mapToclientDto(updatedClient);
    }

    @Override
    public void delete(int client_id) {
        ClientRepo.deleteById(client_id);
    }
}
