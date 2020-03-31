package com.joke.jokes4u;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Class with necessary mutators and accessors for the Category class. 
 */

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotBlank
    private String name;

    public Category() {  }

    public Category(String name) {
        this.setName(name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + name + '\'' +
                '}';
    }


}
