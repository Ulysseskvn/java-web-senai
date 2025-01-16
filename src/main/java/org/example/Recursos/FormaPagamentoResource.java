package org.example.Recursos;

import org.example.Entidades.FormaPagamento;
import org.example.Servicies.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/formaPagamento")
public class FormaPagamentoResource {
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamento> findAll() {
        return formaPagamentoService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> buscarPorId(@PathVariable long id) {
        return formaPagamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FormaPagamento create(@RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.inserir(formaPagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> update(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoService.buscarPorId(id)
                .map(existingFormaPagamentos -> {formaPagamento.setIdFormaPagamento(existingFormaPagamentos.getIdFormaPagamento());
                    return ResponseEntity.ok(formaPagamentoService.inserir(formaPagamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return formaPagamentoService.buscarPorId(id)
                .map(existingFormaPagamento -> {
                    formaPagamentoService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
