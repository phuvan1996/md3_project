package ra.model.daoImp;

import org.springframework.stereotype.Repository;
import ra.model.dao.CatalogDao;
import ra.model.entyti.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CatalogImp implements CatalogDao<Catalog,Integer> {
    @Override
    public List<Catalog> getAll() {
        List<Catalog> listCat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listCat = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogId(rs.getInt("CatalogID"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setTitle(rs.getString("CatalogTitle"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
                listCat.add(cat);
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCat;
    }

    @Override
    public boolean save(Catalog catalog) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertCatalog(?,?,?)}");
            callSt.setString(1,catalog.getCatalogName());
            callSt.setString(2, catalog.getTitle());
            callSt.setBoolean(3,catalog.isCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(Catalog catalog) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateCatalog(?,?,?,?)}");
            callSt.setInt(1,catalog.getCatalogId());
            callSt.setString(2,catalog.getCatalogName());
            callSt.setString(3,catalog.getTitle());
            callSt.setBoolean(4,catalog.isCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_deleteCatalog(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public Catalog getById(Integer id) {
        Catalog cat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getCatalogById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            cat =  new Catalog();
            if (rs.next()){
                cat.setCatalogId(rs.getInt("CatalogID"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setTitle(rs.getString("CatalogTitle"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return cat;
    }

    @Override
    public List<Catalog> searchByName(String name) {
        List<Catalog> listCatalog = null;
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_CatalogSearchByName(?)}");
            callst.setString(1,name);
            ResultSet rs = callst.executeQuery();
            listCatalog = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogId(rs.getInt("CatalogId"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setTitle(rs.getString("CatalogTitle"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
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
    public List<Catalog> getForCreatProduct() {
        List<Catalog> listCat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getCatalogForCreatProduct()}");
            ResultSet rs = callSt.executeQuery();
            listCat = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogId(rs.getInt("CatalogID"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setTitle(rs.getString("CatalogTitle"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
                listCat.add(cat);
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCat;
    }
}
