package com.sistema.depfederal.service;

import com.sistema.depfederal.models.Bairro;
import com.sistema.depfederal.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BairroService {

    private final BairroRepository bairroRepository;

    @Autowired
    public BairroService(BairroRepository bairroRepository) {
        this.bairroRepository = bairroRepository;
    }

    public List<Bairro> buscarTodos() {
        return bairroRepository.findAll();
    }

    public Bairro buscarPorId(Long id) {
        return bairroRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Bairro bairro) {
        bairroRepository.save(bairro);
    }

    @Transactional
    public void editar(Bairro bairro) {
        bairroRepository.save(bairro);
    }

    @Transactional
    public void excluir(Long id) {
        Bairro bairro = buscarPorId(id);
        bairroRepository.delete(bairro);
    }
}
