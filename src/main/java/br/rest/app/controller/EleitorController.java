package br.rest.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.rest.app.model.Eleitor;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/eleitor")
public class EleitorController {


	    @PostMapping
	    public ResponseEntity criar(@RequestBody Eleitor eleitor) {    	    	
	    	if (eleitor.getNome()== "")    	
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome não informado.");
	    	else if (eleitor.getIdade() < 16)
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuário não poderá ser uma pessoa menor de idade.");
	    	
	    	else
	    		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
	    }

	    @GetMapping
	    public ResponseEntity listar() {
	    	    	
	    	List<Eleitor> lista = new ArrayList<Eleitor>();
	    	
	    	Eleitor e = new Eleitor();
	    	e.setNome("Leandro");
	    	e.setIdade(69);
	       	lista.add(e);
	    	
	       	e = new Eleitor();
	    	e.setNome("Isabelly");
	    	e.setIdade(54);
	       	lista.add(e);
	    	
	       	e.setNome("Stephanie");
	    	e.setIdade(25);
	       	lista.add(e);
	    	
	       	e = new Eleitor();
	    	e.setNome("Eduarda");
	    	e.setIdade(89);
	       	lista.add(e);
	    	   	
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(lista);
	    }

	    @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {    	  	
	    	
	    	Eleitor e = new Eleitor();
	    	e.setNome("Danilo");
	    	e.setIdade(20);
	    	
	    	
	        return ResponseEntity.status(HttpStatus.OK).body(e);
	    }

	    @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Eleitor eleitor, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(eleitor);
	    }

	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	}
	
