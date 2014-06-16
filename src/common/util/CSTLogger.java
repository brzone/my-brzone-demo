package common.util;

import org.slf4j.LoggerFactory;

public class CSTLogger {
    
	private Class<?> clazz;
	
	public CSTLogger(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	
	public CSTLogger(String name) {
		printf(name);
	}

	public void logError(String fmt, final Object... inParams) {
		printf(fmt + "," + inParams);
	}

	public void logWarn(String fmt, final Object... inParams) {
		printf(fmt + "," + inParams);
	}

	public void logInfo(String fmt, final Object... inParams) {
		printf(fmt + "," + inParams);
	}

	public void logDebug(String fmt, final Object... inParams) {
		printf(fmt + "," + inParams);
	}

	public void logError(Exception e) {
		e.printStackTrace();
	}
	
	private void printf(Object obj) {
		System.out.println(obj);
	}
}
