package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty(message = "{bairro.validation.nome}")
    private String nome;   //fazer metodo para verificação se aquele bairro já não está cadstrado nessa cidade

    @NotNull(message = "{bairro.validation.cidade}")
    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

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
