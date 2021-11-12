package com.sistema.depfederal.repositories;

import com.sistema.depfederal.models.AgendaCompromissos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaCompromissosRepository extends JpaRepository<AgendaCompromissos, Long> {
}
