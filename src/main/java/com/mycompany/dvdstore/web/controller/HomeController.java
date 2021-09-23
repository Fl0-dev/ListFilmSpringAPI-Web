package com.mycompany.dvdstore.web.controller;

import com.mycompany.dvdstore.entity.Film;
import com.mycompany.dvdstore.service.FilmServiceInterface;
import com.mycompany.dvdstore.web.form.FilmForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FilmServiceInterface filmService;

    public FilmServiceInterface getFilmService() {
        return filmService;
    }

    public void setFilmService(FilmServiceInterface filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/dvdstore-home")//indique vers quelle url
    public void displayHome(){
        //rien car utilisation du package Api
    }

    @GetMapping("/ajout-film-form")
    public void ajout(@ModelAttribute FilmForm filmForm){

    }
}
