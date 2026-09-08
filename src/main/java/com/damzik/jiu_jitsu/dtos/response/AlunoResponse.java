package com.damzik.jiu_jitsu.dtos.response;

import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.enums.Faixa;

public record AlunoResponse(
        Long id,
        String nome,
        int idade,
        Faixa faixa,
        boolean matricula
) {
    public AlunoResponse(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getIdade(),
                aluno.getFaixa(),
                aluno.isMatricula()
        );
    }
}
