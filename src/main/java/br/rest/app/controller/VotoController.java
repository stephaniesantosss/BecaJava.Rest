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

import br.rest.app.model.Voto;

@RestController
@RequestMapping("/votos")
public class VotoController {

    @PostMapping
    public ResponseEntity criar(@RequestBody Voto voto) {
        if (voto.getId() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Código inválido!");
        else
            return ResponseEntity.status(HttpStatus.CREATED).body("Voto registrado com sucesso com sucesso!!");
    }

    @GetMapping
    public ResponseEntity listar() {

        List<Voto> lista = new ArrayList<Voto>();

        Voto v = new Voto();
        v.setId(new Long(1));
        lista.add(v);

        v = new Voto();
        v.setId(new Long(2));
        lista.add(v);

        v = new Voto();
        v.setId(new Long(3));
        lista.add(v);

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
@GetMapping(path = "/{id}")
    public ResponseEntity byId(@PathVariable Long id) {

        Voto v = new Voto();
        v.setId(new Long(1));

        return ResponseEntity.status(HttpStatus.OK).body(v);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity atualizar(@RequestBody Voto voto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(voto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

