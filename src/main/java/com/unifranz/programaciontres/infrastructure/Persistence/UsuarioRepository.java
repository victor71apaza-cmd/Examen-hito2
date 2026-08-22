package com.unifranz.programaciontres.infrastructure.Persistence;

import com.unifranz.programaciontres.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
