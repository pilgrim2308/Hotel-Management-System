package com.example.demo.DAO;


import javax.transaction.Transactional;

// import myproject.demo.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate jt;

    public void save(User user) {
        String sql = "insert into User (username, password,role) values (?,?,?)";
        jt.update(sql, user.getUsername(),user.getPassword(),user.getRole() );
    }
    public void changetoemp(String username) {
        String sql = "update User set role='employee' where username=?";
        jt.update(sql, username);
    }
    public void delete(String username) {
        String sql = "delete from User where username=?";
        jt.update(sql,username);
    }

    public User findByUsername(String username) {
        String sql = "select * from User where username='" + username + "'";
        return jt.queryForObject(sql, new RowMapper<User>() {

            public User mapRow(ResultSet row, int rowNum) throws SQLException {
                User u = new User();
                u.setUsername(row.getString("username"));
                u.setPassword(row.getString("password"));
                u.setRole(row.getString("role"));
                return u;
            }
        });
    }

    public List<User> getAllusers() {
        String sql = "select * from User";
        return jt.query(sql, new RowMapper<User>() {

            public User mapRow(ResultSet row, int rowNum) throws SQLException {
                User u = new User();
                u.setUsername(row.getString("username"));
                u.setPassword(row.getString("password"));
                u.setRole(row.getString("role"));
                return u;
            }
        });
    }

    public boolean userExist(String username) {
        String sql = "select count(*) from User where username=?";
        int p = jt.queryForObject(sql, Integer.class, username);
        if (p == 0)
            return false;
        else
            return true;
    }
    public List<User> getCustomer(){  
        return jt.query("select * from User where role='customer'",new RowMapper<User>(){  
            public User mapRow(ResultSet rs, int row) throws SQLException {  
                User e=new User();  
                e.setUsername(rs.getString(1));  
                e.setRole(rs.getString(3));  
                return e;  
            }  
        });  
    }  
    public List<User> getEmployees(){  
        return jt.query("select * from User where role='employee'",new RowMapper<User>(){  
            public User mapRow(ResultSet rs, int row) throws SQLException {  
                User e=new User();  
                e.setUsername(rs.getString(1));  
                e.setRole(rs.getString(3));  
                return e;  
            }  
        });  
    }  
}