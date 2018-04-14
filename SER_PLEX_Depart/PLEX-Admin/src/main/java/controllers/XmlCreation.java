package controllers;

import models.*;
import org.jdom2.Document;
import org.jdom2.Element;
import views.*;

import java.io.*;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XmlCreation {
    private GlobalData globalData;

    public XmlCreation(GlobalData globalData) {
        this.globalData = globalData;
    }

    public void create() {
        Document document = new Document();
        Element racine = new Element("cinema");
        Element e_projections = new Element("projections");
        Element e_films = new Element("films");
        Element e_acteurs = new Element("acteurs");
        Element e_motsCle = new Element("motsCle");
        Element e_genres = new Element("genres");
        Element e_langages = new Element("langages");
        Element e_critiques = new Element("critiques");

        // ELEMENTS projections
        Element e_projection = new Element("projection");
        Element e_dateProjection = new Element("dateProjection");
        Element e_numeroSalle = new Element("numeroSalle");
        Element e_filmProj = new Element("filmProj");
        Element e_acteursProj = new Element("acteursProj");
        Element e_acteurProj = new Element("acteurProj");

        // ELEMENTS FILMS
        Element e_film = new Element("film");
        Element e_titre = new Element("titre");
        Element e_synopsis = new Element("synopsis");
        Element e_duree = new Element("duree");
        Element e_critiqueFilm = new Element("critiqueFilm");
        Element e_genresFilm = new Element("genresFilm");
        Element e_genreFilm = new Element("genreFilm");
        Element e_motsCleFilm = new Element("motsCleFilm");
        Element e_motCleFilm = new Element("motCleFilm");
        Element e_langagesFilm = new Element("langagesFilm");
        Element e_langageFilm = new Element("langageFilm");
        Element e_photo = new Element("photo");

        // ELEMENTS ACTEURS
        Element e_acteur = new Element("acteur");
        Element e_nom = new Element("nom");
        Element e_nomNaissance = new Element("nomNaissance");
        Element e_biographie = new Element("biographie");
        Element e_sexe = new Element("sexe");
        Element e_dateNaissance = new Element("dateNaissance");
        Element e_dateDeces = new Element("dateDeces");

        // ELEMENTS MOTSCLE
        Element e_motCle = new Element("motCle");
        Element e_labelMc = new Element("labelMc");

        // ELEMENTS GENRES
        Element e_genre = new Element("genre");
        Element e_labelGe = new Element("labelGe");

        // ELEMENTS LANGAGES
        Element e_langage = new Element("langage");
        Element e_labelLa = new Element("labelLa");

        // ELEMENTS CRITIQUES
        Element e_critique = new Element("critique");
        Element e_texte = new Element("texte");
        Element e_note = new Element("note");

        document.addContent(racine);
        racine.addContent(e_projections);

        for (Projection projection : globalData.getProjections()) {
            e_projections.addContent(e_projection);

            e_projection.addContent(e_dateProjection);
            e_projection.addContent(e_numeroSalle);
            e_projection.addContent(e_filmProj);
            e_projection.addContent(e_acteursProj);

            for(Acteur acteur : )


            e_dateProjection.setText(projection.getDateHeure().toString());
            e_numeroSalle.setText(projection.getSalle().toString());


        }


        racine.addContent(e_films);
        racine.addContent(e_acteurs);
        racine.addContent(e_motsCle);
        racine.addContent(e_genres);
        racine.addContent(e_langages);
        racine.addContent(e_critiques);

    }
}
