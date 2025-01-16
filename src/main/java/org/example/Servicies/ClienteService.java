package org.example.Servicies;

import org.example.Entidades.Cliente;
import org.example.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();

    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente inserir(Cliente cliente) {
        return clienteRepository.save(cliente);

    }

    public void deleteId(Long id) {
        clienteRepository.deleteById(id);
    }
}
