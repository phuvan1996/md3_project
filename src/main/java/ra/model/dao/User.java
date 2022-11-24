package ra.model.dao;

import java.util.List;

public interface User<T,V> extends UserManagement<T,V> {
    List<T> searchByName(String name);
}
