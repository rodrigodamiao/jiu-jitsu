package com.damzik.jiu_jitsu.dtos.request;

import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.enums.Faixa;

public record AlunoRequest(
        String nome,
        int idade,
        Double peso,
        Faixa faixa

) {
    public Aluno toEntity(){
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.setIdade(this.idade);
        aluno.setPeso(this.peso);
        aluno.setFaixa(this.faixa);
        aluno.setMatricula(true);
        return aluno;
    }
}
