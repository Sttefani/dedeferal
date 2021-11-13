package com.sistema.depfederal.repositories;

import com.sistema.depfederal.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

        Optional<Cidade> findByNomeIgnoreCase(String nome);

}
