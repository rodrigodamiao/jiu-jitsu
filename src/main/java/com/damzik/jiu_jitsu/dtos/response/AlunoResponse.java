package com.damzik.jiu_jitsu.dtos.response;

import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.enums.CategoriaPeso;
import com.damzik.jiu_jitsu.enums.Faixa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        int idade,
        Double peso,
        CategoriaPeso categoriaPeso,
        Faixa faixa,
        boolean matricula,
        int totalPresencas,
        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm:ss")
        LocalDateTime dataUltimoTreino
) {
    public AlunoResponse(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getIdade(),
                aluno.getPeso(),
                aluno.getCategoriaPeso(),
                aluno.getFaixa(),
                aluno.isMatricula(),
                aluno.getTotalPresencas(),
                aluno.getDataUltimoTreino()
        );
    }
}
