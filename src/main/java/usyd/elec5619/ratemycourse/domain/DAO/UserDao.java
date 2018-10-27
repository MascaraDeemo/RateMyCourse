package usyd.elec5619.ratemycourse.domain.DAO;

import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;
 
public interface UserDao {
 
  void register(User user);
 
  User validateUser(Login login);
 
}