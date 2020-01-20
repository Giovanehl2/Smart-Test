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

import br.com.edu.SmartTest.Model.Aluno;
import br.com.edu.SmartTest.Model.Repository.AlunoRepository;
import br.com.edu.SmartTest.Model.Repository.CursoRepository;

@RestController
@RequestMapping({"/Alunos"})
public class AlunoController {

	

	  public static  AlunoRepository repositoryAluno;
	  
	  AlunoController(AlunoRepository alunoRepository) {
	      this.repositoryAluno = alunoRepository;
	  }
	  
	  
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Aluno> findById(@PathVariable long id){
	    return repositoryAluno.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Aluno aluno) {	  
		  repositoryAluno.save(aluno);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Aluno> update(@PathVariable("id") long id, @RequestBody Aluno aluno){
	    return repositoryAluno.findById(id)
	        .map(x -> {
	            x.setMatricula(aluno.getMatricula());
	            x.setNome(aluno.getNome());
	            x.setSexo(aluno.getSexo());
	            Aluno updated = repositoryAluno.save(x);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	  
	  @DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return repositoryAluno.findById(id)
	        .map(record -> {
	            repositoryAluno.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }
	  
	  

	public static boolean salvarAluno(Aluno aluno) {
		try {
			repositoryAluno.save(aluno);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
