package com.damzik.jiu_jitsu.entities;

import com.damzik.jiu_jitsu.enums.Faixa;
import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int idade;

    @Enumerated(EnumType.STRING)
    private Faixa faixa;

    private boolean matricula;

    public Aluno() {
    }

    public Aluno(Long id, String nome, int idade, Faixa faixa, boolean matricula) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.faixa = faixa;
        this.matricula = matricula;
    }

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Faixa getFaixa() {
        return faixa;
    }

    public void setFaixa(Faixa faixa) {
        this.faixa = faixa;
    }

    public boolean isMatricula() {
        return matricula;
    }

    public void setMatricula(boolean matricula) {
        this.matricula = matricula;
    }
}
