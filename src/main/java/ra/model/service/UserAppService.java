package ra.model.service;

import java.util.List;

public interface UserAppService <T,V>{
    List<T> findAll();
    boolean create(T t);
    boolean update(T t);
}
