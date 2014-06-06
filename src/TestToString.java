import java.util.ArrayList;
import java.util.List;





public class TestToString {

	public static void test(Object... args) {

		System.out.println(args != null);
		System.out.println(args.length);
	}



	public static void main(String[] args) {

		/*List<Object> list = new ArrayList<Object>();

		for(String s : "one world one dream".split(" ")) {

			list.add(s);
		}

		System.out.println(list);*/

		test();


		/*List<String> list = null;

		for(String s : list) {

			System.out.println(s);
		}


*/StringBuilder sql = new StringBuilder();

		sql.append("select t3.id          id,               ");
		sql.append("t3.invno              invno,            ");
		sql.append("t3.invkind            invkind,          ");
		sql.append("t3.invfees            invfees,          ");
		sql.append("t3.optime             optime,           ");
		sql.append("t3.serialno           serialno,         ");
		sql.append("t3.printcnt           printcnt,         ");
		sql.append("t3.custid             custid,           ");
		sql.append("t3.operator           operator,         ");
		sql.append("t3.invid              invid,            ");
		sql.append("t3.bookno             bookno,           ");
		sql.append("t3.invoice#id         invoice#id,       ");
		sql.append("t3.invoice#bookid     invoice#bookid,   ");
		sql.append("t3.invoice#sums       invoice#sums,     ");
		sql.append("t3.invoice#ptype      invoice#ptype,    ");
		sql.append("t3.invoice#place      invoice#place,    ");
		sql.append("t3.invoice#subkind    invoice#subkind,  ");
		sql.append("t3.invoice#invno      invoice#invno,    ");
		sql.append("t3.invoice#invcode    invoice#invcode,  ");
		sql.append("t3.invoice#usestatus  invoice#usestatus,");
		sql.append("t3.invoice#optime     invoice#optime,   ");
		sql.append("t3.invoice#deptid     invoice#deptid,   ");
		sql.append("t3.invoice#operid     invoice#operid,   ");
		sql.append("t3.invoice#manstatus  invoice#manstatus,");
		sql.append("t3.invoice#bilstatus  invoice#bilstatus,");
		sql.append("t3.invoice#bilptype   invoice#bilptype, ");
		sql.append("t3.invoice#bilplace   invoice#bilplace, ");
		sql.append("t3.invoice#custid     invoice#custid ,  ");
		sql.append("t3.serialnostr 				serialnostr       ");
		sql.append("from (select t2.cinvid    id,           ");
		sql.append("t2.invno     invno,                     ");
		sql.append("t2.invkind   invkind,                   ");
		sql.append("t2.invfees   invfees,                   ");
		sql.append("t2.optime    optime,                    ");
		sql.append("t2.serialno  serialno,                  ");
		sql.append("t2.printcnt  printcnt,                  ");
		sql.append("t2.custid    custid,                    ");
		sql.append("t2.operator  operator,                  ");
		sql.append("t2.invid     invid,                     ");
		sql.append("t2.bookno    bookno,                    ");
		sql.append("t1.invid     invoice#id,                ");
		sql.append("t1.bookid    invoice#bookid,            ");
		sql.append("t1.sums      invoice#sums,              ");
		sql.append("t1.ptype     invoice#ptype,             ");
		sql.append("t1.place     invoice#place,             ");
		sql.append("t1.subkind   invoice#subkind,           ");
		sql.append("t1.invno     invoice#invno,             ");
		sql.append("t1.invcode   invoice#invcode,           ");
		sql.append("t1.usestatus invoice#usestatus,         ");
		sql.append("t1.optime    invoice#optime,            ");
		sql.append("t1.deptid    invoice#deptid,            ");
		sql.append("t1.operid    invoice#operid,            ");
		sql.append("t1.manstatus invoice#manstatus,         ");
		sql.append("t1.bilstatus invoice#bilstatus,         ");
		sql.append("t1.bilptype  invoice#bilptype,          ");
		sql.append("t1.bilplace  invoice#bilplace,          ");
		sql.append("t1.custid    invoice#custid ,           ");
		sql
				.append("       (select STR_LINK(distinct s.serialno) serialnostr   ");
		sql.append("          from sys_invoice_cont s                 ");
		sql.append("         where s.cinvid = t2.cinvid) serialnostr  ");
		sql.append("  from res_invoice t1,                            ");
		sql.append("       sys_cust_invoice t2                        ");
		sql.append(" where 1 = 1                                      ");
		sql.append("   and t1.invid = t2.invid                        ");
		sql.append("   and t1.manstatus <> '30'						  ");

		// 其实不加也可以，只有已使用的，才会出现在sys_cust_invoice里面
		/*
		 * sql.append("   and t1.usestatus = ?                        ");
		 * params.add(ResConstant.Invoice.RES_INVSTATUS_USED);
		 */
		// AND （所属渠道类型=部门 and 所属渠道=当前部门 or所属渠道类型=个人 and 所属渠道=当前个人）
		//sql.append(" And ((t1.ptype = ? and t1.place= ?) Or (t1.ptype = ? and t1.place = ?)) ");


		sql.append(" And ((t1.ptype = '1' and t1.place= ?) Or (t1.ptype = '1' and t1.place = ?)) ");

		sql.append(" and t2.custid=? ");

		sql.append(" ) t3  order by t3.invoice#optime desc ");

		/*params.add(ResConstant.Device.RES_PLACETYPE_STORE);
		params.add(oprInfo.getLoginInfo().getDeptid());
		params.add(ResConstant.Device.RES_PLACETYPE_PERSONAL);
		params.add(oprInfo.getLoginInfo().getOperid());
*/
		System.out.println(sql.toString());

	}

}
