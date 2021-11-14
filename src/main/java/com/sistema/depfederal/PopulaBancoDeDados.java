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
        /**
         * Cidades
         */
        Cidade c1 = Cidade.builder().nome("Alto Alegre").build();
        Cidade c2 = Cidade.builder().nome("Amajari").build();
        Cidade c3 = Cidade.builder().nome("Boa Vista").build();
        Cidade c4 = Cidade.builder().nome("Bonfim").build();
        Cidade c5 = Cidade.builder().nome("Cantá").build();
        Cidade c6 = Cidade.builder().nome("Caracaraí").build();
        Cidade c7 = Cidade.builder().nome("Caroebe").build();
        Cidade c8 = Cidade.builder().nome("Iracema").build();
        Cidade c9 = Cidade.builder().nome("Mucajaí").build();
        Cidade c10 = Cidade.builder().nome("Normandia").build();
        Cidade c11 = Cidade.builder().nome("Pacaraima").build();
        Cidade c12 = Cidade.builder().nome("Rorainópolis").build();
        Cidade c13 = Cidade.builder().nome("São João da Baliza").build();
        Cidade c14 = Cidade.builder().nome("São Luiz").build();
        Cidade c15 = Cidade.builder().nome("Uiramutã").build();
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));

        /**
         * Bairros
         */
        Bairro b1 = Bairro.builder().nome("Bairro 1").cidade(c1).build();
        Bairro b2 = Bairro.builder().nome("Bairro 2").cidade(c3).build();
        Bairro b3 = Bairro.builder().nome("Bairro 3").cidade(c3).build();
        bairroRepository.saveAll(Arrays.asList(b1, b2, b3));
    }
}
