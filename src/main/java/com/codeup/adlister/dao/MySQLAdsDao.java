package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.codeup.adlister.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLAdsDao implements Ads {
    private static Connection conn;

    public MySQLAdsDao(Config config) {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUser(),
                        config.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database!", e);
            }
        }
    }


//    @Override
//    public Long insert(Ad ad) {
//        String sql = "INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            stmt.setLong(1, ad.getUserId());
//            stmt.setString(2, ad.getTitle());
//            stmt.setString(3, ad.getDescription());
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        PreparedStatement stmt;
        String sql = "SELECT * FROM ads";
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ads.add(new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        long bill = 0;
        String sql = "INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            bill = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }
}
