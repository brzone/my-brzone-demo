
public class TestString {

	public static void main(String[] args) {

		String tmpsql = "SELECT PLANID AS MCODE, NAME AS MNAME " +
		  				" FROM BIZ_TEMP_OPEN " +
		  				" WHERE TYPE = ? " +
		  " AND AREAS LIKE ? " +
		  " AND PERMARK = ? " +
		 "  AND (((RIGHTVALUE = '9' OR RIGHTVALUE = '7' OR RIGHTVALUE = '5' OR " +
		  "     RIGHTVALUE = '0') AND '9' = ?) OR " +
		   "    ((RIGHTVALUE = '7' OR RIGHTVALUE = '5' OR RIGHTVALUE = '0') AND " +
		    "   '7' = ?) OR ((RIGHTVALUE = '5' OR RIGHTVALUE = '0') AND '5' = ?) OR " +
		    "   (RIGHTVALUE = '0' AND '0' = ?)) " ;

	/*	    int count = 0;
			while (tmpsql.indexOf("?") > 0) {
				count++;
				tmpsql = tmpsql.substring(tmpsql.indexOf("?") + 1);
			}

		System.out.println(count);*/

		//System.out.println(tmpsql.replace("?", ""));

		System.out.println(tmpsql.length()-tmpsql.replace("?", "").length());

	}

}
