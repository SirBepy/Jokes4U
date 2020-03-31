package com.joke.jokes4u;

import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Main class of this file, it is the entity inside of the table. The bottom two
 * only exist to help this class.
 */
@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @NotNull
    @Column(name = "category_id_FK")
    private long categoryId;

    @NotBlank
    private String content;

    @Column(columnDefinition = "integer default 0")
    private int likes = 0;

    @Column(columnDefinition = "integer default 0")
    private int dislikes = 0;

    public Joke() {
    }

    public Joke(long categoryid, String content) {
        this.setCategoryid(categoryid);
        this.setContent(content);
    }

    // id
    public Long getId() {
        return this.id;
    }

    // id
    public void setId(Long id) {
        this.id = id;
    }

    // categoryid
    public long getCategoryid() {
        return this.categoryId;
    }

    public void setCategoryid(long categoryid) {
        this.categoryId = categoryid;
    }

    // content
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // likes
    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    // dislikes
    public int getDislikes() {
        return this.dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", categoryid='" + getCategoryid() + "'" + ", content='" + getContent()
                + "'" + ", likes='" + getLikes() + "'" + ", dislikes='" + getDislikes() + "'" + "}";
    }
}

/**
 * Simply a Joke class but also has the categoryName in it Made to make writing
 * jokes with their categories a bit more easy
 */
class JokeVisualised extends Joke {

    private String categoryName;
    private int index;
    private int difference;

    public JokeVisualised(long id, long categoryId, String content, int index) {
        super(categoryId, content);
        this.setId(id);
        this.setIndex(index);
        this.difference = this.getLikes() - this.getDislikes();
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDifference() {
        return this.difference;
    }

    @Override
    public void setLikes(int likes) {
        super.setLikes(likes);
        this.difference = this.getLikes() - this.getDislikes();
    }

    @Override
    public void setDislikes(int dislikes) {
        super.setDislikes(dislikes);
        this.difference = this.getLikes() - this.getDislikes();
    }

}

/**
 * A class used to for posting This JokeForm will be used in a form and it will
 * be posted and then converted into a real joke
 */
class JokeForm {

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 250)
    private String content;

    @NotNull
    @Min(1)
    private long categoryId;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}