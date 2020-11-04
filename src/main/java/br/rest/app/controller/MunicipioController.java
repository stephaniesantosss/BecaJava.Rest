package br.rest.app.controller;

	
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import br.rest.app.model.*;

	import java.util.ArrayList;
	import java.util.List;

	@RestController
	@RequestMapping("/municipios")
	public class MunicipioController {

	    @PostMapping
	    public ResponseEntity criar(@RequestBody Municipio municipio) {
	        if (municipio.getNome() == "")
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERRO: Nome não informado!");
	        else if (municipio.getPopulacao() <= 0)
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("ERRO: População preenchida com um valor inválido!");
	        else
	            return ResponseEntity.status(HttpStatus.CREATED).body("Municipio criado com sucesso!");
	    }
	@GetMapping
	    public ResponseEntity listar() {

	        List<Municipio> lista = new ArrayList<Municipio>();

	        Municipio m = new Municipio();
	        m.setNome("São Paulo");
	        m.setPopulacao(1200000);
	        lista.add(m);

	        m = new Municipio();
	        m.setNome("Guarulhos");
	        m.setPopulacao(1000000);
	        lista.add(m);

	        m = new Municipio();
	        m.setNome("Sorocaba");
	        m.setPopulacao(800000);
	        lista.add(m);

	        return ResponseEntity.status(HttpStatus.OK).body(lista);
	    }

	    @GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {

	        Municipio m = new Municipio();
	        m.setNome("São Paulo");
	        m.setPopulacao(1200000);

	        return ResponseEntity.status(HttpStatus.OK).body(m);
	    }

	    @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Municipio m, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(m);
	    }

	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
}
