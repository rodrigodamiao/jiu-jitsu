package com.damzik.jiu_jitsu.repositories;

import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.enums.Faixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByFaixa(Faixa faixa);

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

    List<Aluno> findByMatricula(Boolean matricula);

    List<Aluno> findByPesoBetweenAndMatriculaTrue(Double pesoMin, Double pesoMax);
}
