package com.unifranz.programaciontres.application.service.Impl;

import com.unifranz.programaciontres.application.dto.UsuarioDto;
import com.unifranz.programaciontres.application.service.UsuarioService;
import com.unifranz.programaciontres.domain.Usuario;
import com.unifranz.programaciontres.infrastructure.Persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDto> listarActivos() {
        return usuarioRepository.listarActivos();
    }

    @Override
    public UsuarioDto guardar(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        if (usuarioDto.getRol() != null) {
            usuario.setRol(usuarioDto.getRol());
        }
        usuario.setEliminado(false);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return new UsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDto editar(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuario.setNombre(usuarioDto.getNombre());
        usuario.setEmail(usuarioDto.getEmail());
        if (usuarioDto.getRol() != null) {
            usuario.setRol(usuarioDto.getRol());
        }

        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return new UsuarioDto(usuarioActualizado);
    }

    @Override
    public void eliminarLogico(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuario.setEliminado(true);
        usuarioRepository.save(usuario);
    }
}