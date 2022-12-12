package ra.model.dao;

import ra.model.entyti.User;

import java.util.List;

public interface UserDao<T,V> extends UserShopDao<T,V>{
    boolean register(User user);
    User login(String userName,String pass);
    boolean updateUserUnlock(int id);
    boolean updateUserLock(int id);
    List<T> serachByName(String name);
}
