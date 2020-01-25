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

import br.com.edu.SmartTest.Model.Disciplina;
import br.com.edu.SmartTest.Model.Pergunta;
import br.com.edu.SmartTest.Model.Resposta;
import br.com.edu.SmartTest.Model.Repository.PerguntaRepository;

@RestController
@RequestMapping({"/Pergunta"})
public class PerguntaController {


	  private static PerguntaRepository repository;

	  PerguntaController(PerguntaRepository PerguntaRepository) {
	      repository = PerguntaRepository;
	  }
	  
	  @GetMapping(path = {"/{id}"})
	  public ResponseEntity<Pergunta> findById(@PathVariable long id){
	    return repository.findById(id)
	            .map(x -> ResponseEntity.ok().body(x))
	            .orElse(ResponseEntity.notFound().build());
	  }
	  
	  @PostMapping
	  public void salvar(@RequestBody Pergunta pergunta) { 
		  
			if (!pergunta.getRespostas().isEmpty()) {
				for (Resposta resposta : pergunta.getRespostas()) {
					if (resposta != null)
						RespostaController.salvarResposta(resposta);
				}
			}
			
			if (!pergunta.getDisciplinas().isEmpty()) {
				for (Disciplina disciplina : pergunta.getDisciplinas()) {
					if (disciplina != null)
						DisciplinaController.salvarDisciplina(disciplina);
				}
			}
		  
		  repository.save(pergunta);
	  }
	  	  
	  @PutMapping(value="/{id}")
	  public ResponseEntity<Pergunta> update(@PathVariable("id") long id, @RequestBody Pergunta pergunta){
	    return repository.findById(id)
	        .map(x -> {
	            x.setEnunciado(pergunta.getEnunciado());
	            x.setTipoPergunta(pergunta.getTipoPergunta());
	            Pergunta updated = repository.save(x);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	  
	  @DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") long id) {
	    return repository.findById(id)
	        .map(record -> {
	            repository.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }

		public static void  salvarPergunta(Pergunta pergunta) {
			try {
				repository.save(pergunta);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
