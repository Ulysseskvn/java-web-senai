package org.example.Servicies;

import org.example.Entidades.Contato;
import org.example.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    public ContatoRepository contatoRepository;

    public List<Contato> findAll() {
        return contatoRepository.findAll();

    }
    public Optional<Contato> buscarPorId(Long id) {
        return contatoRepository.findById(id);
    }

    public Contato inserir(Contato contato) {
        return contatoRepository.save(contato);

    }
    public void deleteId(Long id) {
        contatoRepository.deleteById(id);
    }
}
