package com.unifranz.programaciontres.infrastructure.web.controller;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarActivos() {
        return ResponseEntity.ok(usuarioService.listarActivos());
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> guardar(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.guardar(usuarioDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> editar(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.editar(id, usuarioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        usuarioService.eliminarLogico(id);
        return ResponseEntity.noContent().build();
    }
}
