package com.avilaa03.dioproject.service.impl;

import com.avilaa03.dioproject.model.Jogo;
import com.avilaa03.dioproject.model.JogoRepository;
import com.avilaa03.dioproject.model.Usuario;
import com.avilaa03.dioproject.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogoServiceImp implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Override
    public Iterable<Jogo> buscarTodos() {
        return jogoRepository.findAll();
    }

    @Override
    public Jogo buscarPorId(Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
        return jogo.get();
    }

    @Override
    public void inserir(Jogo jogo) {
        addNewGame(jogo);
    }

    @Override
    public void atualizar(Long id, Jogo jogo) {
        Optional<Jogo> jogoBd = jogoRepository.findById(id);
        if (jogoBd.isPresent()) {
            addNewGame(jogo);
        }
    }

    @Override
    public void deletar(Long id) {
        jogoRepository.deleteById(id);
    }

    private void addNewGame(Jogo jogo) {
        jogoRepository.save(jogo);
    }
}
