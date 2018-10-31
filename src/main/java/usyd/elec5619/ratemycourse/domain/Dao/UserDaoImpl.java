<<<<<<< HEAD:src/main/java/usyd/elec5619/ratemycourse/domain/Dao/UserDaoImpl.java
package usyd.elec5619.ratemycourse.domain.Dao;

=======
package usyd.elec5619.ratemycourse.DAO;
 
import java.sql.ResultSet;
 
import java.sql.SQLException;
 
import java.util.List;
 
import javax.sql.DataSource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867:src/main/java/usyd/elec5619/ratemycourse/DAO/UserDaoImpl.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
<<<<<<< HEAD:src/main/java/usyd/elec5619/ratemycourse/domain/Dao/UserDaoImpl.java
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

=======
 
//import usyd.elec5619.ratemycourse.domain.Login;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;

@Repository
@Transactional
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867:src/main/java/usyd/elec5619/ratemycourse/DAO/UserDaoImpl.java
public class UserDaoImpl implements UserDao {
 
  @Autowired
 
  DataSource datasource;


  @Autowired
  private SessionFactory sessionFactory;
 
  @Autowired
  JdbcTemplate jdbcTemplate;
 
  public void register(User user) {

    Session currentSession=this.sessionFactory.getCurrentSession();
    Transaction transaction=currentSession.beginTransaction();
    currentSession.save(user);
    transaction.commit();

    }

  @Override
  public User validateUser(Login login) {
 
    Session currentSession = this.sessionFactory.getCurrentSession();
    Transaction transaction = currentSession.beginTransaction();
    SQLQuery sqlQuery = currentSession.createSQLQuery("SELECT * FROM User WHERE userName=:userName");
    sqlQuery.setParameter("userName", login.getUsername());
    User user = (User) sqlQuery.setMaxResults(1).setResultTransformer(Transformers.aliasToBean(User.class)).uniqueResult();


    currentSession.flush();
    transaction.commit();
    return user;

    }
 
  }
 
  class UserMapper implements RowMapper<User> {
 
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
 
    User user = new User();
 
    user.setUserName(rs.getString("name"));
 
    user.setPassword(rs.getString("password"));
 
    user.setUserEmail(rs.getString("email"));
 
    user.setUniversity(rs.getString("university"));
 
    return user;
 
  }
 
}