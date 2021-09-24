package com.mycompany.dvdstore.web.api;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.service.FilmServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/film")
public class FilmResource {

    //annotation Spring pour gérer les dépendances
    @Autowired
    private FilmServiceInterface filmService;

    public FilmServiceInterface getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{id}")
    public Film get(@PathVariable("id") long id){
        Film film = filmService.getFilmById(id);
        return film;
    }

    @PostMapping
    public Film add(@RequestBody Film film){
        return filmService.enregistrementFilm(film);
    }

    @GetMapping//indique vers quelle url
    public Iterable<Film> list(){ //indique qu'il y aura une liste de films en objet
        //récupération des films et
        //envoie en attribut de la requête l'objet
        return filmService.getFilmList();
    }
}
