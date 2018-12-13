import com.mysql.jdbc.Driver;

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
            System.out.println("The connection value:" + conn);
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
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO ads (user_id, title, description) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, ad.getUserId());
            ps.setString(2, ad.getTitle());
            ps.setString(3, ad.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            bill = rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    public static void main(String[] args) {
//        Ads adao = new MySQLAdsDao(new Config());
//        List<Ad> ads = adao.all();
//        for (Ad ad : ads) {
//            System.out.println(ad.getId());
//        }
        System.out.println(DaoFactory.getAdsDao().all());
    }
}
