package com.damzik.jiu_jitsu.dtos.request;

import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.enums.Faixa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AlunoRequest(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @Positive(message = "A idade deve ser maior que zero")
        int idade,

        @Positive(message = "O peso deve ser positivo")
        Double peso,

        @NotNull(message = "A faixa é obrigatória")
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
