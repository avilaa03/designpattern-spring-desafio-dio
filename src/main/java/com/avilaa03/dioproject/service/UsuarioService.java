package com.avilaa03.dioproject.service;

import com.avilaa03.dioproject.model.Usuario;
import java.util.List;

public interface UsuarioService {

    Iterable<Usuario> buscarTodos();

    Usuario buscarPorUsername(String username);

    void inserir(Usuario usuario);

    void atualizar(String username, Usuario usuario);

    void deletar(String username);

}
