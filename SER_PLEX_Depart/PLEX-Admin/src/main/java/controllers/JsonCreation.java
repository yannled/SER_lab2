package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonCreation {
    private GlobalData globalData;

    public JsonCreation(GlobalData globalData) {
        this.globalData = globalData;
    }

    public void create() {

        //ProjectionsJson projectionsJson = new ProjectionsJson();

        JsonObject projectionsObject = new JsonObject();
        JsonArray projections = new JsonArray();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (Projection projection : globalData.getProjections()) {

            JsonObject projectionObject = new JsonObject();
            JsonObject actorObject = new JsonObject();

            projectionObject.addProperty("TitreFilm", projection.getFilm().getTitre());

            SimpleDateFormat format1 = new SimpleDateFormat("dd-mm-yyyy");
            String projectionDate = format1.format(projection.getDateHeure().getTime());
            projectionObject. addProperty("DateProjection", projectionDate);

            //Set<RoleActeur> roles = projection.getFilm().getRoles();

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

            actorObject.addProperty("1er Role", role1.getActeur().getNom());

            actorObject.addProperty("2eme Role", role2.getActeur().getNom());


            projectionObject.add("Acteurs", actorObject);

            projections.add(projectionObject);

            projectionsObject.add("Projections", projections);

            // créé les acteurs
            //ActeurJson acteurs = new ActeurJson(role1.getActeur().getNom(), role2.getActeur().getNom());

            // créé la projection
            //ProjectionJson Projections = new ProjectionJson(projection.getFilm().getTitre(),
                    //projection.getDateHeure().getTime().toString(), acteurs);

            //projectionsJson.addProjection(Projections);
        }

        try (FileWriter writer = new FileWriter("json.json")) {

            gson.toJson(projectionsObject, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
