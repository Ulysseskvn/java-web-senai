package org.example.Recursos;

import org.example.Entidades.Fornecedor;
import org.example.Servicies.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResource {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable long id) {
        return fornecedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.inserir(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.buscarPorId(id)
                .map(existingFornecedores -> {
                    fornecedor.setIdFornecedor(existingFornecedores.getIdFornecedor());
                    return ResponseEntity.ok(fornecedorService.inserir(fornecedor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id)
                .map(existingFornecedor -> {
                    fornecedorService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
