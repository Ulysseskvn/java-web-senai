package org.example.Recursos;

import org.example.Entidades.Produto;
import org.example.Servicies.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findByid(@PathVariable long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.inserir(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.buscarPorId(id)
                .map(existingProdutos -> {
                    produto.setIdProduto(existingProdutos.getIdProduto());
                    return ResponseEntity.ok(produtoService.inserir(produto));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(existingProduto -> {
                    produtoService.deleteId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
