package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.model.dao.CatalogDao;
import ra.model.daoImp.CatalogImp;
import ra.model.entyti.Catalog;
import ra.model.service.CatalogService;

import java.util.List;
@Service
public class CatalogServiceImp implements CatalogService<Catalog,Integer> {
    @Autowired
    private CatalogDao catalogDao;
    @Override
    public List<Catalog> getAll() {
       return catalogDao.getAll();
    }
    @Override
    public boolean save(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDao.update(catalog);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDao.delete(id);
    }

    @Override
    public Catalog getById(Integer id) {
        return (Catalog) catalogDao.getById(id);
    }

    @Override
    public List<Catalog> searchByName(String name) {
        return catalogDao.searchByName(name);
    }

    @Override
    public List<Catalog> getForCreatProduct() {
        return catalogDao.getForCreatProduct();
    }
}
