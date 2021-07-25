package developer.crud.model;

public class Skill extends BaseModel{

    private String name;

    private Developer developer;

    public String getName() {
        return name;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

}

