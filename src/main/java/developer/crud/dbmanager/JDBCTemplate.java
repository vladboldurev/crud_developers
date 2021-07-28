package developer.crud.dbmanager;

import developer.crud.model.Team;
import developer.crud.model.TeamStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCTemplate<T> {
    public List<T> query(String sql, RowMapper<T> mapper) throws Exception {
        List<T> rows = new ArrayList<>();
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            rows.add(mapper.mapRow(result));
        }
        connection.close();
        return rows;
    }

    private void setParameters(PreparedStatement statement, Object[] params) throws Exception {
        int i = 1;
        for(Object param: params){
            System.out.println(i);
            statement.setObject(i, param);
            i++;
        }
    }

    public T queryForObject(String sql, Object[] params, RowMapper<T> mapper) throws Exception {
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        T row = null;
        setParameters(statement, params);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            row = mapper.mapRow(result);
        }
        connection.close();
        return row;
    }

    public int update(String sql, Object[] params) throws Exception {
        Connection connection = DBManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        setParameters(statement, params);
        int result = statement.executeUpdate();
        connection.close();
        return result;
    }
}
