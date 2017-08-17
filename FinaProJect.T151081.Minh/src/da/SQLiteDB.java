package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Category;

public class SQLiteDB {
	private Connection connect() {
		String url = "jdbc:sqlite:foc2warehouse.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void getAllProducts() {
		String sql = "SELECT * FROM products";
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				System.out.format("%3d %-40s %6.2f %4d\n", rs.getInt("productcode"), rs.getString("productname"),
						rs.getDouble("categoryid"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 

	}

	public  void insert(String pCode, String PName, int categoryid, int brandid, int unitofmeasure, int uniprice, String description) {
		String sql = "INSERT INTO products(productcode, productname,categoryid,brandid,unitofmeasure, uniprice, description)" + "VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, pCode);
			pstmt.setString(2, PName);
			pstmt.setDouble(3, categoryid);
			pstmt.setInt(4, brandid);
			pstmt.setInt(5, unitofmeasure);
			pstmt.setInt(6, uniprice);
			pstmt.setString(7, description);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public  void Update(String name, int categoryid){
		String sql = "UPDATE products SET productname=?,categoryid=?" + "WHERE productid=?";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, categoryid);
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public Vector<Category> getCategories(){
		String sql = "SELECT * FROM categories";
		Vector<Category> categoryList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				Category cat = new Category();
				cat.setCategoryId(rs.getInt("categoryid"));
				cat.setCategoryName(rs.getString("categoryname"));
				categoryList.add(cat);
			}
			return categoryList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return categoryList;
	}
}
