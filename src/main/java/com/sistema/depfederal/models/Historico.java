package com.sistema.depfederal.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHistorico = LocalDateTime.now();

    @Lob
    private String descricaoAtendimento;

    @ManyToOne
    @JoinColumn(name = "eleitor_id")
    private Eleitor eleitor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Historico historico = (Historico) o;
        return id != null && Objects.equals(id, historico.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
