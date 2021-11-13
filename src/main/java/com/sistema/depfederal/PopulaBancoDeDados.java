package com.sistema.depfederal;

import com.sistema.depfederal.models.Bairro;
import com.sistema.depfederal.models.Cidade;
import com.sistema.depfederal.repositories.BairroRepository;
import com.sistema.depfederal.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PopulaBancoDeDados implements CommandLineRunner {

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {
        Cidade c1 = new Cidade();
        c1.setNome("Cidade teste 1");
        cidadeRepository.save(c1);

        Bairro b1 = new Bairro();
        b1.setCidade(c1);
        b1.setNome("Bairro 1");
        bairroRepository.save(b1);
    }
}
