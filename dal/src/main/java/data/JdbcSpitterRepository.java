package data;

import entity.Spitter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

//jdbc执行方法类。需要通过构造函数注入
public class JdbcSpitterRepository implements SpitterRepository {

    //定义jdbc对象
    private JdbcOperations jdbc;

    //构造函数。
    public JdbcSpitterRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter where id=?";

    public Spitter findByid(Integer id) {
        return jdbc.queryForObject(SELECT_SPITTER,new SpitterRowMapper(),id);
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullName, email, updateByEmail);
        }
    }

    /*
    private Spitter mapSpitter(ResultSet rs) throws SQLException{
        return new Spitter(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fullName"),
                rs.getString("email"),
                rs.getBoolean("updateByEmail"));
    }*/
}
