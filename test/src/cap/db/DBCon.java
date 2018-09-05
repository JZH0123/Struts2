package cap.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 作者:
* @createDate 创建时间：2018年7月5日 下午3:07:14
*/
public class DBCon {
	private static String dbDriver="com.mysql.jdbc.Driver";
	private String dbUrl="jdbc:mysql://localhost:3306/cap?serverTimezone=UTC";
	private String dbUser="root";
	private String dbPass="123456";
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	
	public Connection getConnection() {
		try {
			Class.forName(dbDriver);
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPass);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		return conn;
		
	}
	public ResultSet doQueryRS(String sql,Object[] params) throws SQLException{
		conn=this.getConnection();
		pstmt=conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++)
		{
			pstmt.setObject(i+1, params[i]);
		}
		rs=pstmt.executeQuery();
		return rs;
		
	}
	public int doUpdate(String sql,Object[] params) throws SQLException
	{
		int res=0;
		conn=this.getConnection();
		pstmt=conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++)
		{
			pstmt.setObject(i+1, params[i]);
		}
		res=pstmt.executeUpdate();
		return res;

}
	
				
	 public void close() 
		{
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
		}
}
}
 