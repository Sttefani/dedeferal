package com.sistema.depfederal.repositories;

import com.sistema.depfederal.models.Eleitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
}
