package com.sistema.depfederal.repositories;

import com.sistema.depfederal.models.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BairroRepository extends JpaRepository<Bairro, Long> {
}
