package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.*;

import java.io.FileWriter;
import java.io.IOException;

public class JsonCreation {
    private GlobalData globalData;

    public JsonCreation(GlobalData globalData) {
        this.globalData = globalData;
    }

    public void create() {

        ProjectionsJson projectionsJson = new ProjectionsJson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (Projection projection : globalData.getProjections()) {

            // Récupére le 1er ROle et le deuxième
            int i = 0;
            RoleActeur role1 = new RoleActeur();
            RoleActeur role2  = new RoleActeur();

            for(RoleActeur role : projection.getFilm().getRoles()){
                if(role.getPlace() == 1){
                    role1 = role;
                    i++;
                }
                if(role.getPlace() == 2) {
                    role2 = role;
                    i++;
                }
                if(i >= 2)
                    break;
            }

            // créé les acteurs
            ActeurJson acteurs = new ActeurJson(role1.getActeur().getNom(), role2.getActeur().getNom());

            // créé la projection
            ProjectionJson Projections = new ProjectionJson(projection.getFilm().getTitre(),
                    projection.getDateHeure().getTime().toString(), acteurs);

            projectionsJson.addProjection(Projections);
        }

        try (FileWriter writer = new FileWriter("json.json")) {

            gson.toJson(projectionsJson, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
