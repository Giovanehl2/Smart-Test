package br.com.edu.SmartTest.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.SmartTest.Model.Usuario;
import br.com.edu.SmartTest.Model.Curso;
import br.com.edu.SmartTest.Model.Turma;
import br.com.edu.SmartTest.Model.Repository.UsuarioRepository;

@RestController
@RequestMapping({ "/Usuarios" })
public class UsuarioController {

	public static UsuarioRepository repositoryUsuario;

	UsuarioController(UsuarioRepository usuarioRepository) {
		repositoryUsuario = usuarioRepository;
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Usuario> findById(@PathVariable long id) {
		return repositoryUsuario.findById(id).map(x -> ResponseEntity.ok().body(x))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public void salvar(@RequestBody Usuario usuario) {
		usuario.getPessoa().
		repositoryUsuario.save(usuario);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		return repositoryUsuario.findById(id).map(x -> {
//	            x.setMatricula(usuario.getMatricula());
			Usuario updated = repositoryUsuario.save(x);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repositoryUsuario.findById(id).map(record -> {
			repositoryUsuario.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

	public static boolean salvarUsuario(Usuario usuario) {
		try {
			repositoryUsuario.save(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
