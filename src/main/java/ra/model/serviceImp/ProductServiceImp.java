package ra.model.serviceImp;

import ra.model.daoImp.ProductImp;
import ra.model.entyti.Product;
import ra.model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService<Product,Integer> {
    private ProductImp productDao=new ProductImp();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDao.searchByName(name);
    }

    @Override
    public List<Product> getProductByCatalogId(Integer id) {

        return productDao.getProductByCatalogId(id);
    }
}
