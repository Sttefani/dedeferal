package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O nome da cidade precisa ser preenchido!")
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

    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;
}

