package org.example.Entidades;

import javax.persistence.*;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTATO")
    private Long idContato;

    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "EMAIL_CONTATO")
    private String emailContato;

    public Contato() {
    }

    public Contato(Long idContato, String telefone, String emailContato) {
        this.idContato = idContato;
        this.telefone = telefone;
        this.emailContato = emailContato;
    }


    public Long getIdContato() {
        return idContato;
    }

    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
