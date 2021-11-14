package com.sistema.depfederal.service;

import com.sistema.depfederal.exception.NomeBairroJaCadastradoException;
import com.sistema.depfederal.models.Bairro;
import com.sistema.depfederal.repositories.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public List<Bairro> buscarTodos() {
        return bairroRepository.findAll();
    }

    public Bairro buscarPorId(Long id) {
        return bairroRepository.findById(id).get();
    }

    @Transactional
    public void salvar(Bairro bairro) {
        if (bairroRepository.findBairroByNomeAndCidade(bairro.getNome(), bairro.getCidade()) != null) {
            throw new NomeBairroJaCadastradoException("Bairro já cadastrado!");
        }
        bairroRepository.save(bairro);
    }

    @Transactional
    public void editar(Bairro bairroNew) {
        Bairro bairroOld = buscarPorId(bairroNew.getId());
        bairroNew.setDataCadastro(bairroOld.getDataCadastro());
        bairroRepository.save(bairroNew);
    }

    @Transactional
    public void excluir(Long id) {
        Bairro bairro = buscarPorId(id);
        bairroRepository.delete(bairro);
    }
}
