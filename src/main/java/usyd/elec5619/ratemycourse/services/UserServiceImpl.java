package usyd.elec5619.ratemycourse.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.DAO.UserDao;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        userDao.register(user);

    }

    @Override
    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }
}
