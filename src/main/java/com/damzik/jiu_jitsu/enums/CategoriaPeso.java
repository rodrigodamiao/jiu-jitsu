package com.damzik.jiu_jitsu.enums;

public enum CategoriaPeso {
    GALO(0.0, 57.5),
    PLUMA(57.51, 64.0),
    PENA(64.01, 70.0),
    LEVE(70.01, 76.0),
    MEDIO(76.01, 82.3),
    MEIO_PESADO(82.31, 88.3),
    PESADO(88.31, 94.3),
    SUPER_PESADO(94.31, 100.5),
    PESADISSIMO(100.51, 999.0);

    private final double pesoMin;
    private final double pesoMax;

    CategoriaPeso(double pesoMin, double pesoMax) {
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
    }

    public double getPesoMin() {
        return pesoMin;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public static CategoriaPeso dePeso(Double peso){
        if(peso == null) return null;

        for(CategoriaPeso cat : values()){
            if(peso > cat.pesoMin && peso < cat.pesoMax) return cat;
        }
        return PESADISSIMO;
    }

}
