package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do bairro precisa ser preenchido!")
    private String nome;

    @NotNull(message = "A cidade precisa ser selecionada!")
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

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
        Bairro bairro = (Bairro) o;
        return id != null && Objects.equals(id, bairro.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
