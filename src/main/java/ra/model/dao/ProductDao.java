package ra.model.dao;

import java.util.List;

public interface ProductDao <T,V>extends ProductManagementDao<T,V> {
    List<T> searchByName(String name);
    List<T> getProductByCatalogId(Integer id);

}
