package org.example.Servicies;

import org.example.Entidades.Usuario;
import org.example.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();

    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario inserir(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    public void deleteId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
