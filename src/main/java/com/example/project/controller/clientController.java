package com.example.project.controller;

import com.example.project.dto.clientDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project.service.clientService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client")
public class clientController {
    private final clientService clientService;

    @PostMapping
    public ResponseEntity<clientDto> save(@RequestBody clientDto clientDto) {
        clientDto savedClient = clientService.save(clientDto);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<clientDto>> findAllClients() {
        List<clientDto> clients = clientService.findAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<clientDto> findClientById(@PathVariable("id") int client_id) {
        clientDto clientDto = clientService.findClientById(client_id);
        return clientDto != null ? ResponseEntity.ok(clientDto) : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<clientDto> update(@PathVariable("id") int clientId, @RequestBody clientDto clientDto) {
        clientDto updatedClient = clientService.update(clientId, clientDto);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int clientId) {
        clientService.delete(clientId);
        return ResponseEntity.ok("Client deleted successfully");
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Client controller is working";
    }
}
