package com.tcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.exception.DataLayerException;

public class DBUtil {
	public static Connection createConnection() throws DataLayerException{
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@LocalHost:1521:xe","system","sastra");
		} catch (ClassNotFoundException | SQLException e) {
			throw new DataLayerException(e.getMessage());
		}
		return con;
	}
	public static void closeAll(Connection con,PreparedStatement pst,ResultSet rs) throws DataLayerException{
		try {
			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			throw new DataLayerException(e.getMessage());
		}
	}
}
