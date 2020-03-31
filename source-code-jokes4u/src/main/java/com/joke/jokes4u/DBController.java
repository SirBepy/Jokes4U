package com.joke.jokes4u;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DBController {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    JokeRepository jokeRepository;

    /**
     * Retrieve all jokes.
     * 
     * @return List<Joke> all jokes.
     */
    public List<Joke> queryJokes() {
        return jokeRepository.findAll();
    }

    /**
     * Retrieves jokes of a certain id.
     * 
     * @param categoryid
     * @return List<Joke> that are of the id in param.
     */
    public List<Joke> queryJokesOfCategory(long categoryid) {
        return jokeRepository.findByCategoryId(categoryid);
    }

    public Joke getJokeById(long id) {
        return jokeRepository.findById(id);
    }

    /**
     * Insert jokes with a given id and content (joke).
     * 
     * @param categoryid
     * @param content
     * @return function that saves the joke.
     */
    public Joke insert(long categoryid, String content) {
        return jokeRepository.save(new Joke(categoryid, content));
    }

    public void update(Joke joke) {
        jokeRepository.save(joke);
    }

    /**
     * Retrieves all categories.
     * 
     * @return List<Category> all categories.
     */
    public List<Category> queryCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieve a category based on it's id.
     * 
     * @param id
     * @return Category based on the given id.
     */
    public Category findCategory(long id) {
        return categoryRepository.findById(id);
    }

}