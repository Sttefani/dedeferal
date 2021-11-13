package com.sistema.depfederal.service;

import com.sistema.depfederal.models.Parente;
import com.sistema.depfederal.repositories.ParenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParenteService {
    private final ParenteRepository parenteRepository;

    @Autowired
    public ParenteService(ParenteRepository parenteRepository) {
        this.parenteRepository = parenteRepository;
    }

    public List<Parente> buscarTodos() {
        return parenteRepository.findAll();
    }

    public Parente buscarPorId(Long id) {
        return parenteRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Parente parente) {
        parenteRepository.save(parente);
    }

    @Transactional
    public void editar(Parente parente) {
        parenteRepository.save(parente);
    }

    @Transactional
    public void excluir(Long id) {
        Parente parente = buscarPorId(id);
        parenteRepository.delete(parente);
    }
}
