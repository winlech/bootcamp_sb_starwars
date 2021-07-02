package br.com.mercadolivre.starwars.starwars;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class StarWarsRepository {

    private static final File FILE = new File("starwars.json");

	private final ObjectMapper mapper;

	@Autowired
    public StarWarsRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<StarWars> findAll() {
        List<StarWars> characters = new ArrayList<>();
		try {
			FileInputStream is = new FileInputStream(FILE);
			TypeReference<List<StarWars>> typeReference = new TypeReference<List<StarWars>>() {};
			characters = mapper.readValue(is, typeReference);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return characters;

    }


    public StarWars findByName(String name) {
		List<StarWars> characters = this.findAll();
		StarWars character;
		try {
			 character = characters.stream()
				.filter(c -> c.getName().contains(name))
				.findFirst()
				.get();
		} catch(NoSuchElementException e) {
			e.printStackTrace();
			character = new StarWars();
		}
		return character;

    }
}
