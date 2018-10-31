<<<<<<< HEAD:src/main/java/usyd/elec5619/ratemycourse/domain/Dao/UserDao.java
package usyd.elec5619.ratemycourse.domain.DAO;

=======
package usyd.elec5619.ratemycourse.DAO;
 
//import usyd.elec5619.ratemycourse.domain.Login;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867:src/main/java/usyd/elec5619/ratemycourse/DAO/UserDao.java
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;



public interface UserDao {
 
  void register(User user);
 
  User validateUser(Login login);
 
}