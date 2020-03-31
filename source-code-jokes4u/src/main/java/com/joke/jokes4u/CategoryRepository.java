package com.joke.jokes4u;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that finds categories based on their id.
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
}
