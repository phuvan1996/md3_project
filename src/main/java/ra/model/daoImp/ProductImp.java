package ra.model.daoImp;

import ra.model.dao.ProductDao;
import ra.model.entyti.Catalog;
import ra.model.entyti.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductImp implements ProductDao<Product,Integer> {

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listProduct = null;
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getProductByname(?)}");
            callst.setString(1,name);
            ResultSet rs = callst.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getInt("ProductID"));
                pro.setProductName(rs.getString("ProductName"));
                pro.setPrice(rs.getFloat("Price"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setTitle(rs.getString("ProductTitle"));
                pro.setDescription(rs.getString("ProductDescription"));
                pro.setProductImage(rs.getString("ProductImage"));
                pro.setProductStatus(rs.getBoolean("ProductStatus"));
                pro.setCatalogId(rs.getInt("CatalogId"));
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
    public List<Product> getProductByCatalogId(Integer id) {
        List<Product> listProduct = null;
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getProductByCatalogId(?)}");
            callst.setInt(1,id);
            ResultSet rs = callst.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getInt("ProductID"));
                pro.setProductName(rs.getString("ProductName"));
                pro.setPrice(rs.getFloat("Price"));
                pro.setQuantity(rs.getInt("Quantity"));
                pro.setTitle(rs.getString("ProductTitle"));
                pro.setDescription(rs.getString("ProductDescription"));
                pro.setProductImage(rs.getString("ProductImage"));
                pro.setProductStatus(rs.getBoolean("ProductStatus"));
                pro.setCatalogId(rs.getInt("CatalogId"));
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
                pro.setProductId(resul.getInt("ProductID"));
                pro.setProductName(resul.getString("ProductName"));
                pro.setPrice(resul.getFloat("Price"));
                pro.setQuantity(resul.getInt("Quantity"));
                pro.setTitle(resul.getString("ProductTitle"));
                pro.setCatalogId(resul.getInt("CatalogID"));
                pro.setProductImage(resul.getString("ProductImage"));
                pro.setDescription(resul.getString("productDescription"));
                pro.setProductStatus(resul.getBoolean("ProductStatus"));
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
            callst = conn.prepareCall("{call proc_insertProduct(?,?,?,?,?,?,?,?,?)}");
            callst.setString(1, product.getProductName());
            callst.setFloat(2,product.getPrice());
            callst.setInt(3,product.getQuantity());
            callst.setString(4, product.getTitle());
            callst.setString(5, product.getProductImage());
            callst.setString(6, product.getDescription());
            callst.setBoolean(7, product.isProductStatus());
            callst.setInt(8,product.getCatalogId());
            callst.registerOutParameter(9, Types.INTEGER);
            callst.execute();
            int productId = callst.getInt(9);
            for (String proimageURL : product.getListImageUrl()){
                CallableStatement callst2 = conn.prepareCall("{call proc_insertImage(?,?)}");
                callst2.setString(1,proimageURL);
                callst2.setInt(2,productId);
                callst2.executeUpdate();
                callst2.close();
            }
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
            //Thuc hien cap nhat thong tin san pham
            callst = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?,?)}");
            callst.setInt(1,product.getProductId());
            callst.setString(2, product.getProductName());
            callst.setFloat(3,product.getPrice());
            callst.setInt(4,product.getQuantity());
            callst.setString(5, product.getTitle());
            callst.setString(6,product.getDescription());
            callst.setString(7,product.getProductImage());
            callst.setBoolean(8, product.isProductStatus());
            callst.executeUpdate();
            //Xoa cac anh phu cu
            CallableStatement callst3 = conn.prepareCall("{ call proc_getdeleteimage(?)}");
            callst3.setInt(1,product.getProductId());
            callst3.executeUpdate();
            callst3.close();
            //Them cac anh phu moi
            for (String urlImg: product.getListImageUrl()) {
                CallableStatement callSt4 = conn.prepareCall("{call proc_insertImage(?,?)}");
                callSt4.setString(1,urlImg);
                callSt4.setInt(2,product.getProductId());
                callSt4.executeUpdate();
                callSt4.close();
            }

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
            callst = conn.prepareCall("{call  proc_deleteproduct(?)}");
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
    public Product getById(Integer id) {
        Connection conn = null;
        CallableStatement callst = null;
        Product productInfo = null;
        try {
            conn =ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_getproductbyid(?)}");
            callst.setInt(1,id);
            ResultSet rs = callst.executeQuery();
            productInfo = new Product();
            if (rs.next()){
                productInfo.setProductId(rs.getInt("ProductID"));
                productInfo.setProductName(rs.getString("ProductName"));
                productInfo.setPrice(rs.getFloat("Price"));
                productInfo.setQuantity(rs.getInt("Quantity"));
                productInfo.setTitle(rs.getString("ProductTitle"));
                productInfo.setProductImage(rs.getString("ProductImage"));
                productInfo.setDescription(rs.getString("productDescription"));
                productInfo.setProductStatus(rs.getBoolean("ProductStatus"));
                productInfo.setCatalogId(rs.getInt("catalogid"));
            }
            //Lay cac anh phu cua san pham
            CallableStatement callSt2 = conn.prepareCall("{call proc_getimageById(?)}");
            callSt2.setInt(1,id);
            ResultSet rs2 = callSt2.executeQuery();
            while (rs2.next()){
                productInfo.getListImageUrl().add(rs2.getString("ImageUrl"));
            }
            callSt2.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return productInfo;
    }
}
