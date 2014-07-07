package mongodb.util;


public class CSTLogger {

	public CSTLogger(Class clazz) {
	}

	public CSTLogger(String name) {
	}

	public void logError(String fmt, final Object... inParams) {
		println(fmt);
		println(inParams);
	}

	public void logWarn(String fmt, final Object... inParams) {
		println(fmt);
		println(inParams);
	}

	public void logInfo(String fmt, final Object... inParams) {
		println(fmt);
		println(inParams);
	}

	public void logDebug(String fmt, final Object... inParams) {
		println(fmt);
		println(inParams);
	}

	public void logError(Exception e) {
		e.printStackTrace();

	
	}
	
	private void println(Object obj) {
		System.out.println(obj);
	}
}
