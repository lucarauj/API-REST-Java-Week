package com.linuxtips.javaweekapi.controller;

import com.linuxtips.javaweekapi.model.Curso;
import com.linuxtips.javaweekapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("/cursos")
    @ResponseStatus(HttpStatus.CREATED)
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.criarCurso(curso);
    }

    @GetMapping("/cursos")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Curso>> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Curso> listarCurso(@PathVariable (value = "id") Long id) {
        return cursoService.listarCurso(id);
    }

    @PutMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Curso> atualizarCurso(@PathVariable (value = "id") Long id, @RequestBody Curso curso) {
        return cursoService.atualizarCurso(id, curso);
    }

    @DeleteMapping("/cursos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletarCurso(@PathVariable (value = "id") Long id) {
        return cursoService.deletarCurso(id);
    }
}
