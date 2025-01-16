package org.example.Recursos;

import org.example.Entidades.Contato;
import org.example.Servicies.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Contatos")
public class ContatoResource {
    @Autowired
    private ContatoService contatoService;
    @GetMapping
    public List<Contato> findAll() {
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable long id) {
        return contatoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.inserir(contato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody Contato contato) {
        return contatoService.buscarPorId(id)
                .map(existingContatos -> {
                    contato.setIdContato(existingContatos.getIdContato());
                    return ResponseEntity.ok(contatoService.inserir(contato));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return contatoService.buscarPorId(id)
                .map(existingContato -> {
                    contatoService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
