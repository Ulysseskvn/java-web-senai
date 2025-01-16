package org.example.Entidades;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CPF_USUARIO")
    private Double cpfUsuario;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nomeUsuario, String email, Double cpfUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.cpfUsuario = cpfUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(Double cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }


}
