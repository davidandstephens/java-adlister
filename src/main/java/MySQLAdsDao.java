import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection conn;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
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
        try {
            String ps = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
            Statement stmt = this.conn.createStatement();
            bill = stmt.executeUpdate(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }
}
