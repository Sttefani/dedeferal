package com.sistema.depfederal.repositories;

import com.sistema.depfederal.models.Bairro;
import com.sistema.depfederal.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {

    @Query("SELECT b FROM Bairro b WHERE b.nome = :nome AND b.cidade = :cidade")
    Bairro findBairroByNomeAndCidade(@Param("nome") String nome, @Param("cidade") Cidade cidade);
}
