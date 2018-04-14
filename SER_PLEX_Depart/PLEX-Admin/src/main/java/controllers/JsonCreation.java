package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Acteur;
import models.GlobalData;
import models.Projection;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCreation {
    private GlobalData globalData;

    public JsonCreation(GlobalData globalData) {
        this.globalData = globalData;
    }

    public void create() {

        //globalData.getProjections();

        List<Projection> Projections = new ArrayList<>();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        for (Projection projection : globalData.getProjections()) {
            Projections.add(projection);
        }

        try (FileWriter writer = new FileWriter("json.json")) {

            gson.toJson(Projections, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
