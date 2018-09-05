package cap.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cap.bean.Test;
import cap.dao.TestDAO;
import cap.db.DBCon;

/**
* @author 作者:
* @createDate 创建时间：2018年7月5日 下午3:42:44
*/
public class TestDAOImpl implements TestDAO {
         private DBCon dbc=null;
	@Override
	public int addTest(Test test) {
		int res=0;
		try {
			dbc=new DBCon();
			String sql="insert into test(username,password) values(?,?)";
			res=dbc.doUpdate(sql, new Object[] {test.getUsername(),test.getPassword()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int updateTest(Test test) {
		int res=0;
		try {
			DBCon dbc=new DBCon();
			String sql="update test set username=?,password=? where id=?";
			res=dbc.doUpdate(sql, new Object[] {test.getUsername(),test.getPassword(),test.getId()});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}

	@Override
	public int delById(int id) {
		int res=0;
		try {
			DBCon dbc=new DBCon();
			String sql="delete from test where id=?";
			res=dbc.doUpdate(sql, new Object[] {id});
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return res;
	}


	@Override
	public Test findById(int id) {
		Test test=null;
		try {
			DBCon dbc=new DBCon();
			String sql="select * from test where id=?";
			ResultSet rs=dbc.doQueryRS(sql, new Object[] {id});
			if(rs.next()) {
				test=new Test();
				test.setId(rs.getInt("id"));
				test.setUsername(rs.getString("username"));
				test.setPassword(rs.getString("password"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return test;
	}

	@Override
	public int getTotalRecords() {
		int count=0;
		try {
			DBCon dbc=new DBCon();
			String sql="select count(*) as t from test";
			ResultSet rs=dbc.doQueryRS(sql, new Object[] {});
			if(rs.next()) {
				count=rs.getInt("t");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return count;
	}

	@Override
	public List<Test> findByPage(int pageNo, int pageSize) {
		List<Test> testList=new ArrayList<Test>();
		try {
			dbc=new DBCon();
			int start=(pageNo-1)*pageSize;
			String sql="select * from test limit ?,?";
			ResultSet rs=dbc.doQueryRS(sql, new Object[] {start,pageSize});
			while(rs.next()) {
				Test test=new Test();
				test.setId(rs.getInt("id"));
				test.setUsername(rs.getString("username"));
				test.setPassword(rs.getString("password"));
		        testList.add(test);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbc.close();
		}
		return testList;
	}

}
 