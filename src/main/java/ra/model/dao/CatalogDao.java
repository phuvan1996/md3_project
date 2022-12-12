package ra.model.dao;

import java.util.List;

public interface CatalogDao<T,V> extends CatalogManagementDao<T,V> {
    List<T> searchByName(String name);
    List<T> getForCreatProduct();
}
