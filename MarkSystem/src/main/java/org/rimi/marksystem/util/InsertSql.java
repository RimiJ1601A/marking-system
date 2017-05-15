package org.rimi.marksystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.mysql.jdbc.PreparedStatement;

public class InsertSql {
	
    private String connectStr = "jdbc:mysql://localhost:3306/marksystem?useServerPrepStmts=false&rewriteBatchedStatements=true";  
    // connectStr += "?useServerPrepStmts=false&rewriteBatchedStatements=true";
    private String username = "root";  
    private String password = "123456";  
	
	public int saveEmploeeBatch(){
		int row = 0;
		PreparedStatement pstmt =null;
		Connection con =null;
		try{
			con = DriverManager.getConnection(connectStr, username,password);  
			String sql = "insert into user(user_account,password,user_name,age,sex,role_id,bulid_time,headphoto_url)values(?,?,?,?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			Random random = new Random();
			for(int i = 0; i < 1000; i++){
				pstmt.setString(1 , "J2017"+i);
				pstmt.setString(2, Messagedest.getMD5("123456"));
				pstmt.setString(3, "第"+i+"位用户");
				pstmt.setInt(4, random.nextInt(100));
				pstmt.setInt(5, i % 2 == 0?1:2);
				pstmt.setInt(6, 3);
				pstmt.setString(7, randomDate("2016-01-01","2017-05-15"));
				pstmt.setString(8, "/images/defaultHeadPhoto.png");
				pstmt.addBatch();
			}
			int[] rows = pstmt.executeBatch();
			row = rows.length;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null)
					pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				if(con != null)
					con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return row;
	}
	
    /** 
     * 获取随机日期 
     *  
     * @param beginDate 
     *            起始日期，格式为：yyyy-MM-dd 
     * @param endDate 
     *            结束日期，格式为：yyyy-MM-dd 
     * @return 
     */   
    private static String randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);// 构造开始日期  
            Date end = format.parse(endDate);// 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
            if (start.getTime() >= end.getTime()) {  
                return null;  
            }  
            long date = random(start.getTime(), end.getTime());  
            Date date1 = new Date(date);
            return format.format(date1);
            //return new Date(date);
           // return format.format((new Date(date)));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
    
    public static void main(String[] args) {
    	System.out.println(new InsertSql().saveEmploeeBatch());
	}
    
  
}  

