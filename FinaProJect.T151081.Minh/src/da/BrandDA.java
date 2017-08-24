package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataobject.Brand;


public class BrandDA extends WHConnection{
	
	public Vector<Brand> getBrands() {
		String sql = "SELECT * FROM brand";
		Vector<Brand> brandList = new Vector<>();
		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				Brand brand = new Brand(rs.getInt("id"),
						rs.getString("brandname"),
						rs.getString("description"));
				brandList.add(brand);
			}
			return brandList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return brandList;
	}
	public Brand getBrand(int id ){
		String sql = "SELECT c.brandname, c.description  FROM brand c WHERE c.id = " + id;
		try(Connection conn = connect(); 
				Statement stmt = conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql)){
			if(rs.next()){
				Brand brand = new Brand();
				
				
				brand.setName(rs.getString("brandname"));
				brand.setDescription(rs.getString("description"));
				return brand;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
	public DefaultTableModel getBrand1() {
		String sql = "SELECT * FROM brand";

		try (Connection conn = connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			return buildTableModel(rs);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void insert(String name, String description) {
		String spl = "INSERT INTO brand(brandname, description)" + "VALUES(?, ?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(spl)) {
			pstmt.setString(1, name);
			pstmt.setString(2, description);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void update(String name, String description, int id) {
		String sql = "UPDATE brand SET brandname = ?, description = ? " + "WHERE(id = ?)";
		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, description);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
