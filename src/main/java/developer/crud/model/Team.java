package developer.crud.model;

public class Team extends BaseModel{
    private String name;

    private TeamStatus status;

    public Team() {}

    public Team(String name, TeamStatus status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public TeamStatus getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(TeamStatus status) { this.status = status; }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getStatus();
    }
}


