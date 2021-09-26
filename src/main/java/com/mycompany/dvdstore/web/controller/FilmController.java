package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Acteur;
import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.service.FilmServiceInterface;
import com.mycompany.dvdstore.web.form.FilmForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/film")
public class FilmController {

    //annotation Spring pour gérer les dépendances
    @Autowired
    private FilmServiceInterface filmService;

    public FilmServiceInterface getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
    }

   /* @GetMapping("/{id}")
    public String detailsFilm(@PathVariable("id") long id, Model model){
        Film film = filmService.getFilmById(id);
        model.addAttribute("film",film);
        return "film-details";
    }*/

    @PostMapping("/add")
    public String ajoutFilm(@Valid @ModelAttribute FilmForm filmForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ajout-film-form";
        }
        Acteur acteur =new Acteur();
        acteur.setFirstName(filmForm.getFirstName());
        acteur.setLastName(filmForm.getLastName());
        Film film = new Film();
        film.setMainActeur(acteur);
        film.setTitre(filmForm.getTitre());
        film.setGenre(filmForm.getGenre());
        film.setDescription(filmForm.getDescription());
        filmService.enregistrementFilm(film);
        return "film-ajoute";
    }
}
