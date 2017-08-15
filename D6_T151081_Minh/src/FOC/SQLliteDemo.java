package FOC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 
 */

/**
 * @author Minh
 *
 */
public class SQLliteDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Update("Minh", 11);
		
		getAllProducts();
	}

	private static Connection connect() {
		String url = "jdbc:sqlite:sales.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private static void getAllProducts() {
		String sql = "SELECT * FROM products";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.format("%3d %-40s %6.2f %4d\n", rs.getInt("productid"), rs.getString("productname"),
						rs.getDouble("unitprice"), rs.getInt("unitinstock"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void insert(String name, int categoryid, double pPrice, int pUnitIntock) {
		String sql = "INSERT INTO products(productname, categoryid,unitprice,unitinstock)" + "VALUES(?,?,?,?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, categoryid);
			pstmt.setDouble(3, pPrice);
			pstmt.setInt(4, pUnitIntock);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void Update(String name, int categoryid){
		String sql = "UPDATE products SET productname=?,categoryid=?" + "WHERE productid=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, categoryid);
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
