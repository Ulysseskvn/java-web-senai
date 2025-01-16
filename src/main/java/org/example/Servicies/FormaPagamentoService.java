package org.example.Servicies;

import org.example.Entidades.FormaPagamento;
import org.example.Repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {
    @Autowired
    public FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamento> findAll() {
        return formaPagamentoRepository.findAll();

    }

    public Optional<FormaPagamento> buscarPorId(Long id) {
        return formaPagamentoRepository.findById(id);
    }

    public FormaPagamento inserir(FormaPagamento fornecedor) {
        return formaPagamentoRepository.save(fornecedor);

    }

    public void deleteId(Long id) {
        formaPagamentoRepository.deleteById(id);
    }
}
