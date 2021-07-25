package developer.crud.repository;

import developer.crud.dbmanager.DBManager;
import developer.crud.dbmanager.JDBCTemplate;
import developer.crud.dbmanager.RowMapper;
import developer.crud.model.Team;
import developer.crud.model.TeamStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeamRepositoryImpl implements TeamRepository{

    private JDBCTemplate<Team> template = new JDBCTemplate<>();

    private Team mapRow(ResultSet resultSet){
        Team team = new Team();
        try {
            team.setId(resultSet.getLong("id"));
            team.setName(resultSet.getString("name"));
            team.setStatus(TeamStatus.valueOf(resultSet.getString("status")));
        } catch (Exception ex) {
            sout
        }
        return team;
    }

    @Override
    public Team findById(Long id) throws Exception {
        String sql = "select * from team where id = ?";
        return template.queryForObject(sql, new Object[] {id}, this::mapRow);
    }

    @Override
    public List<Team> findAll() throws Exception {
        String sql = "select * from team";
        return template.query(sql, this::mapRow);
//        return template.query(sql, new RowMapper<Team>() {
//            @Override
//            public Team mapRow(ResultSet result) throws Exception {
//                Team team = new Team();
//                team.setId(result.getLong("id"));
//                team.setName(result.getString("name"));
//                team.setStatus(TeamStatus.valueOf(result.getString("status")));
//                return team;
//            }
//        });
    }

    @Override
    public int create(Team model) throws Exception {
        String sql = "insert into team(name, status) values(?, ?)";
        return template.update(sql, new Object[] {
                model.getName(),
                model.getStatus().name(),
                model.getId()
        });
    }

    @Override
    public int delete(Team model) throws Exception {
        String sql = "delete from team where id = ?";
        return template.update(sql, new Object[] {
            model.getId()
        });
    }

    @Override
    public int update(Team model) throws Exception {
        String sql = "update team set name=?, status = ?  where id = ?";
        return template.update(sql, new Object[] {
                model.getName(),
                model.getStatus(),
                model.getId()
        });
    }
}
