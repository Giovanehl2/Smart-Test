package br.com.edu.SmartTest.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.SmartTest.Model.Aluno;
import br.com.edu.SmartTest.Model.Curso;
import br.com.edu.SmartTest.Model.Repository.AlunoRepository;
import br.com.edu.SmartTest.Model.Repository.CursoRepository;

@RestController
@RequestMapping({ "/Curso" })
public class CursoController {

	private CursoRepository repository;

	CursoController(CursoRepository CursoRepository) {
		this.repository = CursoRepository;
	}
	  public  AlunoRepository repositoryAluno;
	  
	
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Curso> findById(@PathVariable long id) {
		return repository.findById(id).map(x -> ResponseEntity.ok().body(x)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public void salvar(@RequestBody Curso curso) {

		for (Aluno aluno : curso.getAlunos()) {
			AlunoController.salvarAluno(aluno);
		}

		repository.save(curso);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Curso> update(@PathVariable("id") long id, @RequestBody Curso curso) {
		return repository.findById(id).map(x -> {
			x.setDescricao(curso.getDescricao());
			x.setNome(curso.getNome());
			Curso updated = repository.save(x);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
