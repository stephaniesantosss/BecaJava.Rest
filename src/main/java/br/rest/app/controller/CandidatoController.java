package br.rest.app.controller;

import br.rest.app.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {
	
	@PostMapping
	public ResponseEntity criar(@RequestBody Candidato candidato) {
		if (candidato.getNome() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
		else if (candidato.getTipo() == "")
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo não informado.");
		else
			return ResponseEntity.status(HttpStatus.CREATED).body("Candidato criado com sucesso!");
	}
	@GetMapping
	public ResponseEntity listar() {

		List<Candidato> lista = new ArrayList<Candidato>();

		Candidato u = new Candidato();
		u.setNome("João");
		u.setTipo("Vereador");
		lista.add(u);

		u = new Candidato();
		u.setNome("Maria");
		u.setTipo("Prefeito");
		lista.add(u);

		u = new Candidato();
		u.setNome("Eduarda");
		u.setTipo("Deputado");
		lista.add(u);

		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity byId(@PathVariable Long id) {

		Candidato u = new Candidato();
		u.setNome("Eduarda");
		u.setTipo("Deputado");
		

		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody Candidato candidato, @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(candidato);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
