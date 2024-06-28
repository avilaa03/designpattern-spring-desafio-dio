package com.avilaa03.dioproject.service;

import com.avilaa03.dioproject.model.Jogo;

public interface JogoService {

    Iterable<Jogo> buscarTodos();

    Jogo buscarPorId(Long id);

    void inserir(Jogo jogo);

    void atualizar(Long id, Jogo jogo);

    void deletar(Long id);
}
