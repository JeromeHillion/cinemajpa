package fr.laerce.cinema.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import fr.laerce.cinema.dao.FilmsTmdbDao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class TmdbImportsFiles {

    private FilmsTmdbDao filmsTmdbDao;
    public TmdbImportsFiles( FilmsTmdbDao filmsTmdbDao) {
        this.filmsTmdbDao = filmsTmdbDao;

            }
    public void importMovies(){
        LocalDate date = LocalDate.now().minusDays(1);
        String day = String.format("%02d", date.getDayOfMonth());
        String month = String.format("%02d", date.getMonthValue());
        String year = String.valueOf(date.getYear());
        String filename = "movie_ids_" + month + "_" + day + "_"+ year +".json.gz";
        String url = "http://files.tmdb.org/p/exports/" + filename;
    }

}

