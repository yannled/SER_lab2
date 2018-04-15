package models;

public class ActeurJson {
    private String _1er_Role;
    private String _2eme_Role;

    public ActeurJson(String _1er_Role, String _2eme_Role) {
        this._1er_Role = _1er_Role;
        this._2eme_Role = _2eme_Role;
    }

    public String get_1er_Role() {
        return _1er_Role;
    }

    public void set_1er_Role(String _1er_Role) {
        this._1er_Role = _1er_Role;
    }

    public String get_2eme_Role() {
        return _2eme_Role;
    }

    public void set_2eme_Role(String _2eme_Role) {
        this._2eme_Role = _2eme_Role;
    }
}
