package ra.model.daoImp;

import ra.model.dao.CatalogDao;
import ra.model.entyti.Catalog;
import ra.model.entyti.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CatalogImp implements CatalogDao<Catalog,Integer> {
    @Override
    public List<Catalog> searchByName(String name) {
        return null;
    }

    @Override
    public List<Catalog> getAll() {
        Connection conn = null;
        CallableStatement callst = null;
        List<Catalog>listCatalog = null;
        try {
            conn = ConnectionDB.openConnection();
            callst= conn.prepareCall("{call proc_getAllCatalog()}");
            ResultSet resul = callst.executeQuery();
            listCatalog = new ArrayList<>();
            while (resul.next()){
                Catalog cat= new Catalog();
                cat.setCatalogId(resul.getInt("catalogId"));
                cat.setCatalogName(resul.getString("catalogName"));
                cat.setCatalogStatus(resul.getBoolean("catalogstatus"));
                listCatalog.add(cat);

            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return listCatalog;
    }

    @Override
    public boolean save(Catalog catalog) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_insertCatalog(?,?)}");
            callst.setString(1, catalog.getCatalogName());
            callst.setBoolean(2, catalog.isCatalogStatus());
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_updateCatalog(?,?,?)}");
            callst.setInt(1,catalog.getCatalogId());
            callst.setString(2, catalog.getCatalogName());
            callst.setBoolean(3, catalog.isCatalogStatus());
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn= ConnectionDB.openConnection();
            callst = conn.prepareCall("{call  proc_deleteCatalog(?)}");
            callst.setInt(1,id);
            callst.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public Catalog getById(Integer id) {
        Connection conn = null;
        CallableStatement callst = null;
        Catalog catalogInfo = null;
        try {
            conn =ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getCatalogById(?)}");
            callst.setInt(1,id);
            ResultSet rs = callst.executeQuery();
            catalogInfo = new Catalog();
            if (rs.next()){
                catalogInfo.setCatalogId(rs.getInt("catalogId"));
                catalogInfo.setCatalogName(rs.getString("catalogName"));
                catalogInfo.setCatalogStatus(rs.getBoolean("catalogstatus"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return catalogInfo;
    }
}
