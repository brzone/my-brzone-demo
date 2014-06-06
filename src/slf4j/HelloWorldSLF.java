package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *SLF hello world.
 * @author Jian Lee
 * @mail   brzone@126.com
 * @date 2012-11-19 上午10:03:16
 */
public class HelloWorldSLF {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(HelloWorldSLF.class);

		/**
		 * 使用slf4j-simple-1.7.2.jar打印的日志输出为：
		 *
		 * 		[main] INFO slf4j.HelloWorldSLF - HelloWorldSLF info..
		 * 		[main] INFO slf4j.HelloWorldSLF - HelloWorldSLF error...
		 *
		 *使用slf4j-jdk14-1.7.2.jar打印的日志输出为：
		 *
		 *		2012-11-19 10:06:18 slf4j.HelloWorldSLF main
		 *		信息: HelloWorldSLF info..
		 *		2012-11-19 10:06:18 slf4j.HelloWorldSLF main
		 *		信息: HelloWorldSLF error...
		 *
		 *
		 *使用slf4j-log4j12-1.7.2.jar打印的日志输出为：
		 *		要添加3个jar包：
		 *                 1.  slf4j-api-1.7.2.jar （这个必须的）
		 *                 2.  slf4j-log4j12-1.7.2.jar (下载的slf4j中有)
		 *                 3.  从apache上下载的log4j-1.2.17.jar（我下载的是最新版的）
		 *
		 *     然后，配置log4j.properties文件，放在src目录下即可。
		 *
		 *     打印日志（和log4j.properties配置相关联）：
		 *     	[QC] INFO [main] slf4j.HelloWorldSLF.main(47) | HelloWorldSLF info..
		 *      [QC] INFO [main] slf4j.HelloWorldSLF.main(49) | HelloWorldSLF error...
		 *
		 *
		 *使用slf4j-nop-1.7.2.jar打印的日志输出为：
		 *                 官方文档说：silently discarding all logging
		 *                           （默默丢弃所有记录）
		 *
		 *					这是一个哑接口，没任何日志输出。
		 *
		 *
		 */


		logger.info("HelloWorldSLF info..");

		logger.info("HelloWorldSLF error...");

	}

}
