package usyd.elec5619.ratemycourse.domain.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
 
  @Autowired
 
  DataSource datasource;
 
  @Autowired
 
  JdbcTemplate jdbcTemplate;
 
  public void register(User user) {
 
    String sql = "insert into users values(?,?,?,?,?,?,?)";
 
    jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getUserPswd(), user.getUserUni(),
 
     user.getUserEmail(), });
 
    }
 
    public User validateUser(Login login) {
 
    String sql = "select * from users where name='" + login.getUsername() + "' and password='" + login.getPassword()
 
    + "'";
 
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
 
    return users.size() > 0 ? users.get(0) : null;
 
    }
 
  }
 
  class UserMapper implements RowMapper<User> {
 
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
 
    User user = new User();
 
    user.setUserName(rs.getString("name"));
 
    user.setUserPswd(rs.getString("password"));
 
    user.setUserEmail(rs.getString("email"));
 
    user.setUserUni(rs.getString("university"));
 
    return user;
 
  }
 
}