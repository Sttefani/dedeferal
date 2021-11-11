package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="{validation.nome.cidade}")
    @Column(unique = true,  length = 50)
    private String nome;

    @OneToMany(mappedBy = "cidade")
    @ToString.Exclude
    private List<Bairro> bairro;

    public List<Bairro> getBairro() {
        return bairro;
    }
    public void setBairro(List<Bairro> bairro) {
        this.bairro = bairro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cidade cidade = (Cidade) o;
        return id != null && Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }




}
