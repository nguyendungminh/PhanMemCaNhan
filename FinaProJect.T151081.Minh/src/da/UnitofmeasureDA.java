package da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dataobject.Uniofmeasure;

public class UnitofmeasureDA extends WHConnection{
	
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
		return UnitofmeasureList;
	}
}
