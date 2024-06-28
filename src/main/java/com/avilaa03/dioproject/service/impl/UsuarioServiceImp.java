package com.avilaa03.dioproject.service.impl;

import com.avilaa03.dioproject.model.Usuario;
import com.avilaa03.dioproject.model.UsuarioRepository;
import com.avilaa03.dioproject.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Iterable<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findById(username);
        return usuario.orElse(null);
    }

    @Override
    public void inserir(Usuario usuario) {
        addNewUsername(usuario);
    }

    @Override
    public void atualizar(String username, Usuario usuario) {
        Optional<Usuario> usuarioBd = usuarioRepository.findById(username);
        if (usuarioBd.isPresent()) {
            addNewUsername(usuarioBd.get());
        }
    }

    @Override
    public void deletar(String username) {
        usuarioRepository.deleteById(username);
    }

    private void addNewUsername(Usuario usuario) {
        String username = usuario.getUsername();
        usuario.setUsername(username);
        usuarioRepository.save(usuario);
    }
}
