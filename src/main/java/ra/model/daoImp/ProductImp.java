package ra.model.daoImp;

import ra.model.dao.ProductDao;
import ra.model.entyti.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductImp implements ProductDao<Product,String> {

    @Override
    public List<Product> searchByName(String name) {
        return null;
    }

    @Override
    public List<Product> getAll() {

        Connection conn = null;
        CallableStatement callst = null;
        List<Product>listProduct = null;
        try {
            conn = ConnectionDB.openConnection();
            callst= conn.prepareCall("{call proc_getAllProduct()}");
            ResultSet resul = callst.executeQuery();
            listProduct = new ArrayList<>();
            while (resul.next()){
                Product pro= new Product();
                pro.setProductId(resul.getString("productId"));
                pro.setProductName(resul.getString("productName"));
                pro.setPrice(resul.getFloat("price"));
                pro.setTitle(resul.getString("title"));
                pro.setProductStatus(resul.getBoolean("productstatus"));
                listProduct.add(pro);

            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return listProduct;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_insertProduct(?,?,?,?,?,?,?)}");
            callst.setString(1,product.getProductId());
            callst.setString(2, product.getProductName());
            callst.setFloat(3,product.getPrice());
            callst.setInt(4,product.getQuantity());
            callst.setString(5, product.getTitle());
            callst.setString(6, product.getProductImage());
            callst.setBoolean(7, product.isProductStatus());
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
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?)}");
            callst.setString(1,product.getProductId());
            callst.setString(2, product.getProductName());
            callst.setFloat(3,product.getPrice());
            callst.setInt(4,product.getQuantity());
            callst.setString(5, product.getTitle());
            callst.setString(6, product.getProductImage());
            callst.setBoolean(7, product.isProductStatus());
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
    public boolean delete(String id) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn= ConnectionDB.openConnection();
            callst = conn.prepareCall("{call  proc_deleteproduct(?)}");
            callst.setString(1,id);
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
    public Product getById(String id) {
        Connection conn = null;
        CallableStatement callst = null;
        Product productInfo = null;
        try {
            conn =ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getproductbyid(?)}");
            callst.setString(1,id);
            ResultSet rs = callst.executeQuery();
            productInfo = new Product();
            if (rs.next()){
                productInfo.setProductId(rs.getString("productId"));
                productInfo.setProductName(rs.getString("productName"));
                productInfo.setPrice(rs.getFloat("price"));
                productInfo.setTitle(rs.getString("title"));
                productInfo.setProductStatus(rs.getBoolean("productstatus"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return productInfo;
    }
}
