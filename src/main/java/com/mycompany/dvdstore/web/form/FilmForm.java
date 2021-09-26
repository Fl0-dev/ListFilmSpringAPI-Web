package com.mycompany.dvdstore.web.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class FilmForm {

    private Long id;
    @NotBlank(message = "Veuillez entrer un titre")
    @Length(min=1, max=20, message = "Pas plus de 20 caractères")
    private String titre;
    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    @Length(max=255, message = "Pas plus de 255 caractères")
    private String description;
    @NotBlank(message = "Veuillez entrer le prénom de l'acteur principal")
    @Length(message = "Pas plus de 20 caractères")
    private String firstName;
    @Length(message = "Pas plus de 20 caractères")
    private String lastName;

    public String getTitre() {
        return titre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
