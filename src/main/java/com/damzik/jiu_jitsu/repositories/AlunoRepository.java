package com.damzik.jiu_jitsu.repositories;

import com.damzik.jiu_jitsu.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
