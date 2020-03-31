package com.joke.jokes4u;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Interface to find joke by an id and category by id.
 */

@Repository
public interface JokeRepository extends JpaRepository<Joke, Long> {

    Joke findById(long id);
    List<Joke> findByCategoryId(long categoryid);

}
