package com.gec.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil<T> {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	//杩炴帴鏁版嵁搴�
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/class1?characterEncoding=utf-8", "root",
					"1234");
		return conn;
	}
	
	public int update(String sql,Object...obj){
		int row = 0;
		try {
			//濡傛灉涓嶈皟鐢╣etConnection鏂规硶锛宑onn鏄痭ull
			pst = getConnection().prepareStatement(sql);
			//鏍规嵁鍗犱綅绗﹀搴斿弬鏁扮殑涓暟杩涜寰幆,濡傛灉娌℃湁鍙傛暟鍒欎笉寰幆
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i+1, obj[i]);
			}
			row = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.getClose(rs, pst, conn);
		}
		return row;
	}
	
	//浣跨敤鍙嶅皠瀹炵幇缁撴灉闆嗙殑澶勭悊
	public List<T> query(String sql,Object...obj){
		//瀹氫箟涓�涓泦鍚� 鐢ㄦ潵瀛樻斁鏌ユ暟鎹殑缁撴灉
		List<T> list = new ArrayList<>();
		try {
			//濡傛灉涓嶈皟鐢╣etConnection鏂规硶锛宑onn鏄痭ull,prepareStatement鏄紶鍏ヨ鎵ц鐨剆ql璇彞
			pst = getConnection().prepareStatement(sql);
			//select * from book where id = ? and name = ?
			//鏍规嵁鍗犱綅绗﹀搴斿弬鏁扮殑涓暟杩涜寰幆,濡傛灉娌℃湁鍙傛暟鍒欎笉寰幆
			//杩欎釜寰幆灏辨槸鐢ㄦ潵缁欐煡璇㈡潯浠惰祴鍊肩殑
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i+1, obj[i]);
			}
			rs = pst.executeQuery();//璋冪敤鎵ц鏌ヨ鐨勬柟娉�
			//鑾峰彇鍒皉s涓殑鏁翠釜缁撴瀯
			ResultSetMetaData rmd = rs.getMetaData();
			//浠庤〃缁撴瀯涓幏鍙栧埌琛ㄦ槑,鏉ユ嫾鎺ュ嚭绫诲悕
			String str = "com.gec.bean."+rmd.getTableName(1).substring(0, 1).toUpperCase()+rmd.getTableName(1).substring(1);
			//鍔犺浇绫诲悕鎴愪负涓�涓被
			Class clazz = Class.forName(str);
			int count = rmd.getColumnCount();  //鑾峰彇鍒板睘鎬х殑涓暟
			while(rs.next()){
				//閫氳繃绫诲弽灏勭敓浜у璞�
				T t = (T) clazz.newInstance();
				//澶勭悊姣忎釜鍒楄祴鍊肩粰灞炴��
				for(int i=0;i<count;i++){
					//鑾峰彇鍒板垪鍚�
					String cname = rmd.getColumnName(i+1);
					//閫氳繃鍒楀悕鑾峰彇鍒板睘鎬�
					Field f = clazz.getDeclaredField(cname);
					//蹇界暐灞炴�ф潈闄�
					f.setAccessible(true);
					//涓哄睘鎬ц祴鍊�
					f.set(t, rs.getObject(i+1));
				}
				//灏嗗璞′繚瀛樺湪闆嗗悎
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.getClose(rs, pst, conn);
		}
		return list;
	}
	
	public void getClose(ResultSet rs,PreparedStatement pst,Connection conn){
		try {
			if (rs != null)
				rs.close();
			if(pst!=null)
				pst.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
