package ra.model.service;

import ra.model.entyti.User;

import java.util.List;

public interface UserService<T,V>extends UserAppService<T,V> {
    boolean register(User user);
    User login(String userName,String pass);
    boolean updateUserLock(int id);
    List<T> searchByName(String name);
    boolean updateUserUnlock(int id);
}
