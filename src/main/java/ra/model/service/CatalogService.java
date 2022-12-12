package ra.model.service;

import java.util.List;

public interface CatalogService <T,V>extends CatalogManagementService<T,V>{
    List<T> searchByName(String name);
    List<T> getForCreatProduct();

}
