package com.damzik.jiu_jitsu.services;

import com.damzik.jiu_jitsu.dtos.request.AlunoRequest;
import com.damzik.jiu_jitsu.dtos.request.AlunoUpdateRequest;
import com.damzik.jiu_jitsu.dtos.response.AlunoResponse;
import com.damzik.jiu_jitsu.entities.Aluno;
import com.damzik.jiu_jitsu.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // Listar alunos
    public List<AlunoResponse> listarAlunos(){
        return alunoRepository.findAll().stream().map(AlunoResponse::new).toList();
    }

    // Buscar aluno por id
    public AlunoResponse findAlunoById(Long id){
        return alunoRepository.findById(id)
                .map(AlunoResponse::new)
                .orElseThrow(() -> new RuntimeException("Aluno de id %d não encontrado".formatted(id)));
    }

    // Matricular aluno
    public AlunoResponse matricularAluno(AlunoRequest alunoRequest){
        return new AlunoResponse(alunoRepository.save(alunoRequest.toEntity()));
    }

    // Atualizar aluno
    public AlunoResponse atualizarAluno(Long id, AlunoUpdateRequest alunoUpdateRequest){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno de id %d não encontrado".formatted(id)));

        if(alunoUpdateRequest.nome() != null && !alunoUpdateRequest.nome().isBlank()) aluno.setNome(alunoUpdateRequest.nome());
        if(alunoUpdateRequest.idade() != null) aluno.setIdade(alunoUpdateRequest.idade());
        if(alunoUpdateRequest.faixa() != null) aluno.setFaixa(alunoUpdateRequest.faixa());

        return new AlunoResponse(alunoRepository.save(aluno));
    }

    // Cancelar matricula
    public AlunoResponse cancelarMatricula(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno de id %d não encontrado".formatted(id)));

        if (!aluno.isMatricula()) {
            throw new IllegalStateException("A matrícula do aluno de id %d já está cancelada".formatted(id));
        }

        aluno.setMatricula(false);

        return new AlunoResponse(alunoRepository.save(aluno));
    }

    // Reativar matricula
    public AlunoResponse reativarMatricula(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno de id %d não encontrado".formatted(id)));

        if(aluno.isMatricula()){
            throw new IllegalStateException("A matrícula do aluno de id %d já esta ativa.".formatted(id));
        }

        aluno.setMatricula(true);

        return new AlunoResponse(alunoRepository.save(aluno));
    }

    // Deletar aluno
    public void deletarAluno(Long id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno de id %d não encontrado".formatted(id)));

        alunoRepository.delete(aluno);
    }
}
