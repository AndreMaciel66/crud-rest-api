package br.com.unipac.crudalunosapi.model.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "tb_aluno")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "curriculo_de_aluno", nullable = true)
    private String curriculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) &&
                Objects.equals(nome, aluno.nome) &&
                Objects.equals(curriculo, aluno.curriculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, curriculo);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
