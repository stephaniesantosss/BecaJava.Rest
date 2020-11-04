package br.rest.app.controller;


	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import br.rest.app.model.Zona;

	@RestController
	@RequestMapping("/zonas")
	public class ZonaController {

	    @PostMapping
	    public ResponseEntity criar(@RequestBody Zona zona) {
	        if (zona.getId() == 0)
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código inválido!");
	        else if(zona.getNome() == "")
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome inválido!");
	        else
	            return ResponseEntity.status(HttpStatus.CREATED).body("Voto registrado com sucesso com sucesso!!");
	    }

	    @GetMapping
	    public ResponseEntity listar() {

	        List<Zona> lista = new ArrayList<Zona>();

	        Zona z = new Zona();
	        z.setId(new Long(1));
	        z.setNome("ZONA123");
	        lista.add(z);

	        z = new Zona();
	        z.setId(new Long(2));
	        z.setNome("ZONA456");
	        lista.add(z);

	        z = new Zona();
	        z.setId(new Long(3));
	        z.setNome("ZONA789");
	        lista.add(z);

	        return ResponseEntity.status(HttpStatus.OK).body(lista);
	    }
	@GetMapping(path = "/{id}")
	    public ResponseEntity byId(@PathVariable Long id) {

	        Zona z = new Zona();
	        z.setId(new Long(3));
	        z.setNome("ZONA789");

	        return ResponseEntity.status(HttpStatus.OK).body(z);
	    }

	    @PutMapping(path = "/{id}")
	    public ResponseEntity atualizar(@RequestBody Zona zona, @PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.OK).body(zona);
	    }

	    @DeleteMapping(path = "/{id}")
	    public ResponseEntity delete(@PathVariable Long id) {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }

	}
