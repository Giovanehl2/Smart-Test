package br.com.edu.SmartTest.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.SmartTest.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findBymatricula(String matricula);
}
