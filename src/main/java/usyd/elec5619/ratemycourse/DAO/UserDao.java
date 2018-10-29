package usyd.elec5619.ratemycourse.DAO;
 
//import usyd.elec5619.ratemycourse.domain.Login;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;



public interface UserDao {
 
  void register(User user);
 
  User validateUser(Login login);
 
}