package com.sistema.depfederal.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(nullable = false)
    private LocalDateTime dataDoAgendamento = LocalDateTime.now();

    @NotBlank(message = "A data e hora do agendamento é obrigatória!")
    private LocalDateTime dataHoraCompromisso;

    @Embedded
    @NotBlank(message = "O endereço da reunião precisa ser definido!")
    private Endereco endereco;

    @NotBlank(message = "O nome da pessoa ou grupo precisa ser definido!")
    private String nomePessoaGrupo;

    private String celular;

    @NotBlank(message = "A pauta da agenda é obrigatória!")
    private String pauta;

    @Lob
    private String resumoDareuniao;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

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
