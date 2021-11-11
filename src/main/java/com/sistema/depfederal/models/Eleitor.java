package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="{validation.nome.eleitor}")
    private String nome;

    private String celular;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message="{validation.dataNascimento.eleitor}")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotBlank(message="{validation.sexo.eleitor}")
    private Sexo sexo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @CPF(message = "{validation.CPF}")
    private String CPF;

    private String ocupacao;

    private int numeroIntegrantesFamilia;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "eleitor")
    @ToString.Exclude
    private List<Historico> historico;

    public List<Historico> getHistorico() {
        return historico;
    }
    public void setHistorico(List<Historico> historico) {
        this.historico = historico;
    }

    @OneToMany(mappedBy = "eleitor")
    @ToString.Exclude
    private List<Parentesco> parentesco;

    public List<Parentesco> getParentesco() {
        return parentesco;
    }

    public void setParentesco(List<Parentesco> parentesco) {
        this.parentesco = parentesco;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Eleitor eleitor = (Eleitor) o;
        return id != null && Objects.equals(id, eleitor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}
