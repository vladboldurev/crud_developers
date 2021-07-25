package developer.crud.service;

import developer.crud.model.Team;
import developer.crud.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    TeamRepository repository;

    public TeamService(TeamRepository teamRepository) {
        this.repository = teamRepository;
    }

    public Team read(Long id) {
        return repository.findById(id);
    }

    public List<Team> readAll() {
        System.out.printf("service readAll ");
        return new ArrayList<>();
    }

    public int delete(Long id) {

    }

    public int update(Long id, String name) {

    }

    public int create(String name) {
        System.out.printf("service create name: %s%n", name);
    }

}
