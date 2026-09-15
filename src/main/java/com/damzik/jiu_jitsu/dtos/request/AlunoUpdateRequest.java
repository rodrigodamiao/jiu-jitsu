package com.damzik.jiu_jitsu.dtos.request;

import com.damzik.jiu_jitsu.enums.Faixa;

public record AlunoUpdateRequest(
        String nome,
        Integer idade,
        Double peso,
        Faixa faixa,
        Boolean matricula
) {}
