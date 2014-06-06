package dbprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 存储过程的例子，还包括游标(相当于Collection)
 * @author jian.li
 * @Date 2011-4-12 14:20                                                
 * @tip
 * 
 * 4 monthes:     4级                                                                                                                                                            <br/>
 * 2years：                     播音员                                                                                                                                                     <br/>
 * 4monthes：              专业播音员                 [creazy:美国之声英文稿 ]                    <br/>
 * </table>
 * 
 * 
 * 4.12 多么有意思的日子
 * 
 */

public class ProcudureDemo {
	
	private final static String NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@//149.16.20.102:1521/orcl2";
	private final static String USERNAME = "system";
	private final static String PASSWORD = "oxygenbrzone";
	
	/**
	 * procedure:
	 * 
	 * CREATE OR REPLACE PROCEDURE checkempright
	 * (username_in in varchar2,deptment_in in varchar2,amount_out out varchar2)
	 *	is
 	 *		begin
  	 *			select count(*) into amount_out
  	 *			from employee
  	 *			where username = username_in
  	 *			and deptment = deptment_in;
     *		end checkempright;
	 * 
	 * 
	 */
	
	
	/**
	 * 
	 * 几时 ，在某数据库中，执行此存储能够返回1
	 * I like losing face?
	 * 
	 */
	
	
	public static void query() {
		
		Connection conn = null;
		CallableStatement stat = null;

		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stat = conn.prepareCall("{call checkempright(?,?,?)}");
			
			stat.setString(1, "xiaoli");
			stat.setString(2, "可爱保洁员");
			
			/*输出的值需要注册: 输出参数的位置和类型*/
			stat.registerOutParameter(3, Types.VARCHAR);
			
			stat.execute();
			
			String amount = "";
			
			amount = stat.getString(3);
			
			/*暂时还不支持这种通过参数的名字获取数据，只能通过参数的位置*/
			//amount = stat.getString("amount_out");
			
			System.out.println("amount:" + amount);
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(stat != null){
				
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
	}

	/**
	 * procedure:                                                                          
	 *      create or replace procedure querybyeid                                         
	 *      		(eid_in in number,ecoursor out SYS_REFCURSOR)--使用系统默认的游标                         
	 *		IS                                                                             
  	 *			begin                                                                     
     *               open ecoursor for                                                      
     *               select * from employee                                                
     *               where EID = eid_in;                                                 
     *         end querybyeid;                                                              
	 * 
	 * 
	 *
	 */
	
	
	public static Employee queryAsCursor() {
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		Employee emp = null;
		
		try {
			Class.forName(NAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stat = conn.prepareCall("{call querybyeid(?,?)}");
			stat.setInt(1,20);
			
			/*在Oracle中，游标类型为 oracle.jdbc.OracleTypes.CURSOR*/
			stat.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			
			/*执行存储过程*/
			stat.execute();
			
			/*获取执行结果，造型为ResultSet，往后的处理和一般的查询是一样的了*/
			rs = (ResultSet)stat.getObject(2);
			
			
			/*只获取一条，用if便够了*/
			if(rs.next()) {
				
				int eid = rs.getInt("EID");
				String username = rs.getString("USERNAME");
				String deptment = rs.getString("DEPTMENT");
				
				emp = new Employee();
				emp.setEid(eid);
				emp.setUsername(username);
				emp.setDeptment(deptment);
			
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				stat.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return emp;
	}
	
	public static void main(String[] args) {
		
		//query();
		Employee emp  = queryAsCursor();
		
		System.out.println(emp == null ? "你的用户名或者密码有误!" : emp);
		
	}
	
}
