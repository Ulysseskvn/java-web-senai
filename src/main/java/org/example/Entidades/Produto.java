package org.example.Entidades;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name = "ID_FORNECEDOR", nullable = false)
    private Fornecedor fornecedor;


    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    @Column(name = "PRECO")
    private Double preco;
    @Column(name = "QUANTIDADE")
    private Long quantidade;

    public Produto() {
    }

    public Produto(Long idProduto, Fornecedor fornecedor, String tipo, String nomeProduto, Double preco, Long quantidade) {
        this.idProduto = idProduto;
        this.fornecedor = fornecedor;
        this.tipo = tipo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
    }


    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
