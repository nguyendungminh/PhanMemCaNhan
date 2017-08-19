package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Brand;
import dataobject.Category;
import dataobject.Uniofmeasure;;

public class SQLiteDB {
	private Connection connect() {
		String url = "jdbc:sqlite:foc2warehouse.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
			}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public void getAllProducts(){
		String sql = "SELECT * FROM products";
		
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				System.out.format("%3d %-40s %6.2f \n", 
						rs.getInt("productid"),
						rs.getInt("productcode"),
						rs.getString("productname"),
						rs.getInt("categoryid"),
						rs.getInt("brandid"),
						rs.getInt("unitofmeasureid"),
						rs.getDouble("price"),
						rs.getString("descriton"),
					
						
						rs.getDouble("unitprice"));
						
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void insert (int ID,String pCode, String pName, int categoryid, int brandid,  int unitofmeasureid, double price, String description){
		String sql = "INSERT INTO products(productid,productcode, productname, categoryid, brandid, unitofmeasureid, price, description)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1,ID);
			pstmt.setString(2, pCode);
			pstmt.setString(3, pName);
			pstmt.setInt(4, categoryid);
			pstmt.setInt(5, brandid);
			pstmt.setInt(6, unitofmeasureid);
			pstmt.setDouble(7, price);
			pstmt.setString(8, description);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
//	public void update(String name, int categoryid, double pPrice, int pUnitInStock, int productid){
//		String sql = "UPDATE products set productname = ?, categoryid = ?, unitprice = ?, unitinstock = ? "
//				+ "WHERE(productid = ?)";
//		
//		try (Connection conn = connect();
//				PreparedStatement pstmt = conn.prepareStatement(sql)){
//			pstmt.setString(1, name);
//			pstmt.setInt(2, categoryid);
//			pstmt.setDouble(3, pPrice);
//			pstmt.setInt(4, pUnitInStock);
//			pstmt.setInt(5, productid);
//			pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//	}
	
	public void delete( int productid){
		String sql = "DELETE FROM products WHERE productid = ? ";
		
		try (Connection conn = connect();
		PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, productid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public Vector<Category> getAllCategories(){
		String sql = "SELECT * FROM categories";
		Vector<Category> categoryList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				Category cat = new Category(rs.getInt("id"),
						rs.getString("categoryname"));
				
				categoryList.add(cat);
				
				
			}
			return categoryList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Vector<Brand> getAllBrands(){
		String sql = "SELECT * FROM brand";
		Vector<Brand> brandList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				Brand bra = new Brand(rs.getInt("id"),
						rs.getString("brandname"));
				
				brandList.add(bra);
				
				
			}
			return brandList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Vector<Uniofmeasure> getAllUnitOfMeasure(){
		String sql = "SELECT * FROM unitofmeasure";
		Vector<Uniofmeasure> UnitofmeasureList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				
				Uniofmeasure uom = new Uniofmeasure(rs.getInt("id"),
						rs.getString("unitname"));
				
				UnitofmeasureList.add(uom);
				
				
			}
			return UnitofmeasureList;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
}


