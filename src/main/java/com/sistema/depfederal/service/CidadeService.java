package com.sistema.depfederal.service;

import com.sistema.depfederal.exception.NomeCidadeJaCadastradoException;
import com.sistema.depfederal.models.Cidade;
import com.sistema.depfederal.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Cidade cidade) {
        Optional<Cidade> cidadeOptional = cidadeRepository.findByNomeIgnoreCase(cidade.getNome());
        if(cidadeOptional.isPresent())
            throw new NomeCidadeJaCadastradoException("Cidade já cadastrada no banco de dados!");
        cidadeRepository.save(cidade);
    }

    @Transactional
    public void editar(Cidade cidade) {
        Optional<Cidade> cidadeOptional = cidadeRepository.findByNomeIgnoreCase(cidade.getNome());
        if(cidadeOptional.isPresent())
            throw new NomeCidadeJaCadastradoException("Cidade já cadastrada no banco de dados!");
        cidadeRepository.save(cidade);
    }

    @Transactional
    public void excluir(Long id) {
        Cidade cidade = buscarPorId(id);
        cidadeRepository.delete(cidade);
    }
}
