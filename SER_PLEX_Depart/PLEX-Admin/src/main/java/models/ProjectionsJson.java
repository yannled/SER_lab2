package models;

import java.util.ArrayList;
import java.util.List;

public class ProjectionsJson {

    private List<ProjectionJson> projections;

    public ProjectionsJson() {
        this.projections = new ArrayList<>();
    }

    public List<ProjectionJson> getProjection() {
        return projections;
    }

    public void addProjection(ProjectionJson projection) {
        this.projections.add(projection);
    }
}
