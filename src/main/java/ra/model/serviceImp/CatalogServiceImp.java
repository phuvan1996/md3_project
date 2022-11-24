package ra.model.serviceImp;

import ra.model.daoImp.CatalogImp;
import ra.model.daoImp.ProductImp;
import ra.model.entyti.Catalog;
import ra.model.service.CatalogManagementService;
import ra.model.service.CatalogService;

import java.util.List;

public class CatalogServiceImp implements CatalogService<Catalog,Integer> {
    private CatalogImp catalogDao=new CatalogImp();

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
        return catalogDao.getById(id);
    }

    @Override
    public List<Catalog> searchByName(String name) {
        return catalogDao.searchByName(name);
    }
}
