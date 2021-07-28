package developer.crud.controller;

import developer.crud.model.Team;
import developer.crud.model.TeamStatus;
import developer.crud.service.TeamService;

import java.util.List;
import java.util.Map;

public class TeamController {

    TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    public Team read(Long id) {
        return service.read(id);
    }

    public List<Team> readAll() {
        return service.readAll();
    }

    public int delete(Long id) {
        return service.delete(id);
    }

    public void update(Long id, String name, int statusIndex) {
        service.update(id, name, statusIndex);
    }

    public void create(String name, int statusIndex) { service.create(name, statusIndex);}

}
