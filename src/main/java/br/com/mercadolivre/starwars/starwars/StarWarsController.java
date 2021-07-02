package br.com.mercadolivre.starwars.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarWarsController {

    private final StarWarsService starWarsService;

    @Autowired
    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<StarWars> character(@PathVariable String name) {
        return new ResponseEntity<>(starWarsService.getCharacter(name), HttpStatus.OK);
    }
}
