package com.sistema.depfederal.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AgendaCompromissos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataDoAgendamento = LocalDateTime.now();

    private LocalDateTime dataHoraCompromisso;

    @Embedded
    private Endereco endereco;

    @NotBlank(message = "{validation.nomePessoaGrupo}")
    private String nomePessoaGrupo;

    private String celular;

    @NotBlank(message = "{validation.pauta}")
    private String pauta;

    @Lob
    private String resumoDareuniao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AgendaCompromissos that = (AgendaCompromissos) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
