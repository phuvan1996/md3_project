package ra.model.serviceImp;

import ra.model.dao.UserDao;
import ra.model.daoImp.UserDaoImp;
import ra.model.entyti.User;
import ra.model.service.UserService;

import java.util.List;

public class UserServiceImp implements UserService<User,Integer>{
    private static UserDao userDao = new UserDaoImp();
    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public User login(String UserName, String pass) {
        return userDao.login(UserName,pass);
    }

    @Override
    public boolean updateUserLock(int id) {
        return userDao.updateUserLock(id);
    }

    @Override
    public List<User> searchByName(String name) {
        return userDao.serachByName(name);
    }

    @Override
    public boolean updateUserUnlock(int id) {
        return userDao.updateUserUnlock(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean create(User user) {
        return userDao.creat(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }
}
