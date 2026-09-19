package com.damzik.jiu_jitsu.dtos.request;

import com.damzik.jiu_jitsu.enums.Faixa;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AlunoUpdateRequest(
        @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
        String nome,

        @Positive(message = "A idade deve ser maior que zero")
        Integer idade,

        @Positive(message = "O peso deve ser maior que zero")
        Double peso,

        Faixa faixa
) {}
