package com.example.service;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  public Optional<Client> findById(Long id) {
    return clientRepository.findById(id);
  }

  public void save(Client client) {
    clientRepository.save(client);
  }

  public void deleteById(Long id) {
    clientRepository.deleteById(id);
  }
}