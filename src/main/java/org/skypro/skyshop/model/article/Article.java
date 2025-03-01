package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private String name;
    private String title;
    private final UUID uuid;

    public Article(String name, String title, UUID uuid) {

        if (title == null || name == null) {
            System.out.println("Article.Exc.Null.toString{" +
                    "name=" + name + ", title= " + title + '}');
            throw new IllegalArgumentException("Имя и/или содержание статьи не может быть null");
        }
        this.name = name;
        this.title = title;
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else this.uuid = uuid;
    }

    public Article(String name, String title) {

        if (title == null || name == null) {
            System.out.println("Article.Exc.Null.toString{" +
                    "name=" + name + ", title= " + title + '}');
            throw new IllegalArgumentException("Имя и/или содержание статьи не может быть null");
        }
        this.name = name;
        this.title = title;
        this.uuid = UUID.randomUUID();
    }


    public UUID getId() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article)) return false;
        return Objects.equals(name, ((Article) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {

        return name + " " + " \n"
                + title;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    @JsonIgnore
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return name + "\n" + title;
    }
}