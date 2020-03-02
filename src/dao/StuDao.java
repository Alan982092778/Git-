package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enity.Stu;
import ulit.BaseDao;

public class StuDao extends BaseDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	
	//显示的方法
	public List<Stu> find(){
		List<Stu> list =new ArrayList<Stu>();
		try {
			conn=getConnection();
			String sql="select * from student";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				list.add(new Stu(rs.getString(1),rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, conn);
		}
		
		return list;
	}
}
