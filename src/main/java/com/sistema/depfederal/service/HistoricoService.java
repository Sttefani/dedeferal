package com.sistema.depfederal.service;

import com.sistema.depfederal.models.Historico;
import com.sistema.depfederal.repositories.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class HistoricoService {
    private final HistoricoRepository historicoRepository;

    @Autowired
    public HistoricoService(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }

    public List<Historico> buscarTodos() {
        return historicoRepository.findAll();
    }

    public Historico buscarPorId(Long id) {
        return historicoRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Historico historico) {
        historicoRepository.save(historico);
    }

    @Transactional
    public void editar(Historico historico) {
        historicoRepository.save(historico);
    }

    @Transactional
    public void excluir(Long id) {
       Historico historico = buscarPorId(id);
        historicoRepository.delete(historico);
    }
}
