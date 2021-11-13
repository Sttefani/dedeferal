package com.sistema.depfederal.service;
import com.sistema.depfederal.models.Eleitor;
import com.sistema.depfederal.repositories.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EleitorService {

    private final EleitorRepository eleitorRepository;

    @Autowired
    public EleitorService(EleitorRepository eleitorRepository) {
        this.eleitorRepository = eleitorRepository;
    }
    public List<Eleitor> buscarTodos() {
        return eleitorRepository.findAll();
    }

    public Eleitor buscarPorId(Long id) {
        return eleitorRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Eleitor eleitor) {
        eleitorRepository.save(eleitor);
    }

    @Transactional
    public void editar(Eleitor eleitor) {
        eleitorRepository.save(eleitor);
    }

    @Transactional
    public void excluir(Long id) {
        Eleitor eleitor = buscarPorId(id);
        eleitorRepository.delete(eleitor);
    }
}