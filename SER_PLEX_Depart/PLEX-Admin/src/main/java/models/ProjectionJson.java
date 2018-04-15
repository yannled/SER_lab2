package models;

public class ProjectionJson {
    private String TitreFilm;
    private String DateProjection;
    private ActeurJson acteurs;

    public ProjectionJson(String titreFilm, String dateProjection, ActeurJson acteurs) {
        TitreFilm = titreFilm;
        DateProjection = dateProjection;
        this.acteurs = acteurs;
    }

    public String getTitreFilm() {
        return TitreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        TitreFilm = titreFilm;
    }

    public String getDateProjection() {
        return DateProjection;
    }

    public void setDateProjection(String dateProjection) {
        DateProjection = dateProjection;
    }

    public ActeurJson getActeurs() {
        return acteurs;
    }

    public void setActeurs(ActeurJson acteurs) {
        this.acteurs = acteurs;
    }
}
