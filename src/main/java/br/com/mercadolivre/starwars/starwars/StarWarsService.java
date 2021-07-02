package br.com.mercadolivre.starwars.starwars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StarWarsService {

    private final StarWarsRepository starWarsRepository;

    @Autowired
    public StarWarsService(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }


    public StarWars getCharacter(String name) {
        return starWarsRepository.findByName(name);
    }
}
