package com.damzik.jiu_jitsu.entities;

import com.damzik.jiu_jitsu.enums.Faixa;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    private int totalPresencas = 0;

    private LocalDateTime dataUltimoTreino;

    public Aluno() {
    }

    public Aluno(Long id, String nome, int idade, Faixa faixa, boolean matricula, int totalPresencas, LocalDateTime dataUltimoTreino) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.faixa = faixa;
        this.matricula = matricula;
        this.totalPresencas = totalPresencas;
        this.dataUltimoTreino = dataUltimoTreino;
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

    public int getTotalPresencas() { return totalPresencas; }

    public void setTotalPresencas(int totalPresencas) { this.totalPresencas = totalPresencas; }

    public LocalDateTime getDataUltimoTreino() { return dataUltimoTreino;}

    public void setDataUltimoTreino(LocalDateTime dataUltimoTreino) { this.dataUltimoTreino = dataUltimoTreino; }
}
