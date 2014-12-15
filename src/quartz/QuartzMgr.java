package quartz;

import java.text.ParseException;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import common.util.StringUtil;

/**
 * Quartz的管理器
 * <li>这里的JobDetail所对应的CronTrigger用的名字是JobDetail的名字</li>
 * @author brzone@126.com
 *
 * @date 2014年12月15日 下午2:34:38
 */
public class QuartzMgr {
	
	/**JobDetail的默认组名称*/
	private static final String JOBDETAIL_DEFAULT_GROUP = "JOBDETAIL_DEFAULT_GROUP";

	/**CronTrigger的默认组名称*/
	private static final String CRONTRIGGER_DEFAULT_GROUP = "CRONTRIGGER_DEFAULT_GROUP";
	
	/**SchedulerFactory,单例即可*/
	private static final SchedulerFactory SF = new StdSchedulerFactory();
	
	private static final QuartzMgr INSTANCE = new QuartzMgr();
	
	private QuartzMgr(){}
	
	public static QuartzMgr getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 添加一个job
	 * @param jobname    job的名称
	 * @param jobClass   job的class
	 * @param time       设置的时间cron参数
	 * @throws ParseException 
	 * @throws SchedulerException 
	 */
	public void addJob(String jobname,Class<? extends Job> jobClass,String time) throws ParseException, SchedulerException {
		
		if(StringUtil.isNullOrBlank(jobname) || jobClass == null || StringUtil.isNullOrBlank(time) ) {
			return;
		}
		
		JobDetail jobdetail =  JobBuilder.newJob(jobClass).withIdentity(jobname, JOBDETAIL_DEFAULT_GROUP).build();
		
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobname, CRONTRIGGER_DEFAULT_GROUP)
				.withSchedule(CronScheduleBuilder.cronSchedule(time)).build();
		
		Scheduler scheduler =  SF.getScheduler();
		
		scheduler.scheduleJob(jobdetail,trigger);
		
		scheduler.start();
		
	}
	
	
	/**
	 * 移除一个jop
	 * @param jobname job的名称
	 * @throws SchedulerException 
	 */
	public void removeJob(String jobname) throws SchedulerException {
		
		if(StringUtil.isNullOrBlank(jobname)){
			return;
		}
		
		Scheduler scheduler =  SF.getScheduler();
		
		//停止触发器 
		scheduler.pauseTrigger(TriggerKey.triggerKey(jobname, CRONTRIGGER_DEFAULT_GROUP));
		//移除触发器 
		scheduler.unscheduleJob(TriggerKey.triggerKey(jobname, CRONTRIGGER_DEFAULT_GROUP));
		//删除任务
		scheduler.deleteJob(JobKey.jobKey(jobname, JOBDETAIL_DEFAULT_GROUP));
		
	}
	
	
	/**
	 * 修改某个job的cron设置的时间
	 * @param jobname job的名称
	 * @param time	  设置的cron时间
	 * @throws SchedulerException 
	 * @throws ParseException 
	 */
	public void modifyJobTime(String jobname,String time) throws SchedulerException, ParseException {
		
		if(StringUtil.isNullOrBlank(jobname) || StringUtil.isNullOrBlank(time)){
			return;
		}
		
		Scheduler scheduler =  SF.getScheduler();
		Class<? extends Job> jobclass = scheduler.getJobDetail(JobKey.jobKey(jobname, JOBDETAIL_DEFAULT_GROUP)).getJobClass();
		
		//先移除
		removeJob(jobname);
		//然后添加
		addJob( jobname,jobclass, time);
	}
	
}
