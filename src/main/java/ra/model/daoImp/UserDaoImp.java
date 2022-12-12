package ra.model.daoImp;

import ra.model.dao.UserDao;
import ra.model.entyti.User;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao<User,Integer> {
    @Override
    public boolean register(User user) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_register(?,?,?,?)}");
            callst.setString(1,user.getUserName());
            callst.setString(2, user.getEmail());
            callst.setString(3, user.getPassword());
            callst.setString(4, user.getConfirmPassWord());
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
    public User login(String userName, String pass) {
        Connection conn = null;
        CallableStatement callst = null;
        User user = null ;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_login(?,?)}");
            callst.setString(1, userName);
            callst.setString(2, pass);
            ResultSet rs = callst.executeQuery();
            user = new User();
            if (rs.next()){
                user.setUserName(rs.getString("UserName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("PassWord"));
                user.setAddress(rs.getString("Address"));
                user.setPhoneNumber(rs.getString("PhoneNumber"));
                user.setUserStatus(Boolean.parseBoolean(rs.getString("UserStatus")));
                user.setPermission(rs.getBoolean("Userpemission"));
                user.setUserId(rs.getInt("UserId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return user;
    }

    @Override
    public boolean updateUserUnlock(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn=ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_deleteUserUnlock(?)}");
            callst.setInt(1,id);
            callst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public boolean updateUserLock(int id) {
        Connection conn = null;
        CallableStatement callst = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call proc_deleteUser(?)}");
            callst.setInt(1,id);
            callst.executeUpdate();
        }catch (Exception e){
            result= false;
        }finally {
            ConnectionDB.closeConnection(conn,callst);
        }
        return result;
    }

    @Override
    public List<User> serachByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> listUser = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_SearchByNameUser(?)}");
            listUser = new ArrayList<>();
            callSt.setString(1, name);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                User ur = new User();
                ur.setUserId(rs.getInt("userId"));
                ur.setUserName(rs.getString("userName"));
                ur.setEmail(rs.getString("email"));
                ur.setPassword(rs.getString("passWork"));
                ur.setAddress(rs.getString("address"));
                ur.setPhoneNumber(rs.getString("phoneNumber"));
                ur.setUserStatus(rs.getBoolean("userStatus"));
                ur.setPermission(rs.getBoolean("Userpemission"));
                listUser.add(ur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;
    }

    @Override
    public List<User> findAll() {

        Connection conn = null;
        CallableStatement callSt = null;
        List<User> listUser = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call  proc_getAllUser()}");
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                User ur = new User();
                ur.setUserId(rs.getInt("userId"));
                ur.setUserName(rs.getString("userName"));
                ur.setEmail(rs.getString("email"));
                ur.setPassword(rs.getString("passWord"));
                ur.setAddress(rs.getString("address"));
                ur.setPhoneNumber(rs.getString("phoneNumber"));
                ur.setUserStatus(rs.getBoolean("userStatus"));
                ur.setPermission(rs.getBoolean("Userpemission"));
                listUser.add(ur);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listUser;
    }

    @Override
    public User findById(Integer id) {
        Connection conn = null;
        CallableStatement callSt = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getUserById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("passWork"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                user.setPermission(rs.getBoolean("Userpemission"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return user;
    }
    @Override
    public boolean creat(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
