package developer.crud.model;

public class Developer extends BaseModel{

    private String name;

    private Team team;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

}
