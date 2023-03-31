package com.linuxtips.javaweekapi.service;

import com.linuxtips.javaweekapi.model.Curso;
import com.linuxtips.javaweekapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public ResponseEntity<List<Curso>> listarCursos() {
        var lista = cursoRepository.findAll();
        if(!lista.isEmpty()) {
            return ResponseEntity.ok().body(lista);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Curso> listarCurso(Long id) {
        return cursoRepository.findById(id).map(
                curso -> ResponseEntity.ok().body(curso)).orElse(ResponseEntity.notFound().build()
        );
    }

    public ResponseEntity<Curso> atualizarCurso(Long id, Curso curso) {
        return cursoRepository.findById(id).map(
                cursoUpdate -> {
                    cursoUpdate.setNome(curso.getNome());
                    cursoUpdate.setPreco(curso.getPreco());
                    cursoUpdate.setInstrutor(curso.getInstrutor());
                    Curso updated = cursoRepository.save(cursoUpdate);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deletarCurso(Long id) {
        return cursoRepository.findById(id).map(
                cursoToDelete -> {
                    cursoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
