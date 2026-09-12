package com.unifranz.programaciontres.application.service;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDto> listarActivos();
    UsuarioDto guardar(UsuarioDto usuarioDto);
    UsuarioDto editar(Long id, UsuarioDto usuarioDto);
    void eliminarLogico(Long id);
}
