package developer.crud.controller;

import developer.crud.model.Team;
import developer.crud.service.TeamService;

import java.util.List;

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

    public void delete(Long id) {
        service.delete(id);
    }

    public void update(Long id, String name) {
        service.update(id, name);
    }

    public void create(String name) {
        service.create(name);
    }

}
