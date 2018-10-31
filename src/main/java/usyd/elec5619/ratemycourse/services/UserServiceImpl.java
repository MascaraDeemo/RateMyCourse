package usyd.elec5619.ratemycourse.services;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
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
        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        trans.begin();

        // Query Wiki Object
        SQLQuery query = currentSession.createSQLQuery("SELECT * FROM User WHERE userName=:username");
        query.setParameter("username", login.getUsername());
        User user = (User) query.setMaxResults(1).setResultTransformer(Transformers.aliasToBean(User.class)).uniqueResult();


        currentSession.flush();
        trans.commit();

        return user;
    }
}
