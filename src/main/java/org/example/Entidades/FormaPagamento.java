package org.example.Entidades;

import javax.persistence.*;

@Entity
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FORMAPAGAMENTO")
    private Long idFormaPagamento;

    @Column(name = "METODO_FORMAPAGAMENTO")
    private String nomeFormaPagamento;


    public FormaPagamento() {
    }

    public FormaPagamento(Long idFormaPagamento, String nomeFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
        this.nomeFormaPagamento = nomeFormaPagamento;

    }

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getNomeFormaPagamento() {
        return nomeFormaPagamento;
    }

    public void setNomeFormaPagamento(String nomeFormaPagamento) {
        this.nomeFormaPagamento = nomeFormaPagamento;
    }

}
