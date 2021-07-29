package developer.crud.service;

import developer.crud.model.Team;
import developer.crud.model.TeamStatus;
import developer.crud.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    TeamRepository repository;

    public TeamService(TeamRepository teamRepository) {
        this.repository = teamRepository;
    }

    public Team read(Long id) {
        try {
            return repository.findById(id);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public List<Team> readAll() {
        try {
            return repository.findAll();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<Team>();
    }

    public int delete(Long id) {
        try {
            return repository.delete(id);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int update(Long id, String name, int statusIndex) {
        try {
            Team team = new Team();
            team.setId(id);
            team.setName(name);
            team.setStatus(TeamStatus.getTeamStatusByIndex(statusIndex));
            return repository.update(team);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public int create(String name, int statusIndex) {
        try {
            Team team = new Team();
            team.setName(name);
            team.setStatus(TeamStatus.getTeamStatusByIndex(statusIndex));
            int result = repository.create(team);
            System.out.println("result:" + result);
            return result;
//            return repository.create(team);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
}
