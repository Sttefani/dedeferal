package com.sistema.depfederal.models;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@Data
@ToString
@RequiredArgsConstructor
public class Eleitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="O campo nome não pode estar em branco!")
    private String nome;

    private String celular;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message="A data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @NotBlank(message="O sexo do eleitor precisa ser definido no campo!")
    private Sexo sexo;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @CPF(message = "{CPF inválido!}")
    private String CPF;

    private String ocupacao;

    @Embedded
    private Endereco endereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_cidade_id")
    @ToString.Exclude
    private Cidade cidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_bairro_id")
    @ToString.Exclude
    private Bairro bairro;

    @NotBlank(message="O número de integrantes da família precisa ser definido!!")
    private int numeroIntegrantesFamilia;

    private String localdeVotacao;

    private String tituloDeEleitor;

    private String zona;

    private String secao;


    @CreationTimestamp
    @Column(columnDefinition = "datetime")
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDateTime dataAtualizacao;

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
    private List<Parente> parente;

    public List<Parente> getParente() {
        return parente;
    }

    public void setParente(List<Parente> parente) {
        this.parente = parente;
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
