package org.yn.app.resource;

import org.eclipse.microprofile.graphql.*;
import org.yn.app.domain.Film;
import org.yn.app.domain.Hero;
import org.yn.app.service.GalaxyService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@GraphQLApi
public class FilmResource {

    @Inject
    GalaxyService service;

    @Query("allFilms")
    @Description("Get all Films from a galaxy far far away")
    public List<Film> getAllFilms() {
        return service.getAllFilms();
    }

    @Query
    @Description("Get a Films from a galaxy far far away")
    public Film getFilm(@Name("filmId") int id) {
        return service.getFilm(id);
    }

    public List<List<Hero>> heroes(@Source List<Film> films) {
        List<List<Hero>> heroes = new ArrayList<>();
        for(Film film: films){
            heroes.add(service.getHeroesByFilm(film));
        }
        return heroes;
    }
}
