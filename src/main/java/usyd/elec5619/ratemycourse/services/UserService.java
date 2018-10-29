package usyd.elec5619.ratemycourse.services;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.DAO.UserDao;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;


public interface UserService {
	//void save(User user);

	//User findByUsername(String username);
	 void register(User user);

//	public boolean alreadyExist(User user1){
//		if(userDao.validateUser(user1) != null){
//		    return true;
//        }else {
//		    return false;
//        }
//	}
	User validateUser(Login login);

//	static public boolean isEmail(String email);


}
