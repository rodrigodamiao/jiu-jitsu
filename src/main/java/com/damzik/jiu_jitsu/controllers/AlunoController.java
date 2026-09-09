package com.damzik.jiu_jitsu.controllers;

import com.damzik.jiu_jitsu.dtos.request.AlunoRequest;
import com.damzik.jiu_jitsu.dtos.request.AlunoUpdateRequest;
import com.damzik.jiu_jitsu.dtos.response.AlunoResponse;
import com.damzik.jiu_jitsu.enums.Faixa;
import com.damzik.jiu_jitsu.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Listar alunos
    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarAlunos(@RequestParam(required = false)Faixa faixa,
                                                            @RequestParam(required = false) String nome,
                                                            @RequestParam(required = false) Boolean matricula){

        if(faixa != null) return ResponseEntity.ok().body(alunoService.findAlunoByFaixa(faixa));
        if(nome != null) return ResponseEntity.ok().body(alunoService.findAlunoByNome(nome));
        if(matricula != null) return ResponseEntity.ok().body(alunoService.findAlunosMatriculados(matricula));
        return ResponseEntity.ok().body(alunoService.listarAlunos());
    }

    // Buscar Aluno por id
    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> findAlunoById(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.findAlunoById(id));
    }

    // Matricular Aluno
    @PostMapping
    public ResponseEntity<AlunoResponse> matricularAluno(@RequestBody AlunoRequest alunoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.matricularAluno(alunoRequest));
    }

    // Atualizar Aluno
    @PatchMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno(@PathVariable Long id, @RequestBody AlunoUpdateRequest alunoUpdateRequest){
        return ResponseEntity.ok(alunoService.atualizarAluno(id, alunoUpdateRequest));
    }

    // Cancelar Matricula
    @PatchMapping("/{id}/cancelar-matricula")
    public ResponseEntity<AlunoResponse> cancelarMatricula(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.cancelarMatricula(id));
    }

    // Reativar Matricula
    @PatchMapping("/{id}/reativar-matricula")
    public ResponseEntity<AlunoResponse> reativarMatricula(@PathVariable Long id){
        return ResponseEntity.ok().body(alunoService.reativarMatricula(id));
    }

    // Deletar Aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}
