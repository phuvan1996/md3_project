package ra.model.dao;

import ra.model.entyti.User;

import java.util.List;

public interface UserShopDao <T,V>{
    List<T> findAll();
    User findById(V id);
    boolean creat(T t);
    boolean update(T t);
}
