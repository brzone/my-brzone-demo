package quartz;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Client {
	
	public static void main(String[] args) throws ParseException, SchedulerException, InterruptedException {
		
		
		QuartzMgr.getInstance().addJob("simplejobA", SimpleJob.class, "0/10 * * * * ?");
		
		QuartzMgr.getInstance().addJob("simplejobB", SimpleJob2.class, "0/6 * * * * ?");
		
		TimeUnit.SECONDS.sleep(100);
		QuartzMgr.getInstance().modifyJobTime("simplejobB", "0/2 * * * * ?"); //加快频率
		
		TimeUnit.SECONDS.sleep(100);
		QuartzMgr.getInstance().modifyJobTime("simplejobB", "0/10 * * * * ?"); 
		
		
/*		TimeUnit.SECONDS.sleep(100);
		System.out.println("===============remove job=======================");
		QuartzMgr.getInstance().removeJob("simplejobB");
		
		
		TimeUnit.SECONDS.sleep(60);
		System.out.println("===============add job=======================");
		QuartzMgr.getInstance().addJob("simplejobB", SimpleJob2.class, "0/6 * * * * ?");*/
	}
	
	
	
	
	
	
	
	
	

	public static void mainTest(String[] args) throws ParseException, SchedulerException, InterruptedException {
		
		JobDetail jobdetail =  JobBuilder.newJob(SimpleJob.class).withIdentity("simplejob", "simplejobgroup").build();
		
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "trigger1group1")
		.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();  //每10s执行一次
		
		/**
		 * SchedulerFactory可以作为唯一实例，然后执行多个JobDetail & CronTrigger
		 * 
		 * 
		 */
		
		SchedulerFactory sf = new StdSchedulerFactory();
		
		Scheduler scheduler =  sf.getScheduler();
		
		
		
	
		
		
		/**
		 * 不能共用CronTrigger ，意思说，jobdetail & jobdetai2 不能共用一个CronTrigger
		 * 
		 * 俩个CronTrigger，不能用同一个JobDetail
		 * 
		 * 好像在运行中可以修改cron中运行时间描述（这样的话，当然一个JobDetail只能对应自己的CronTrigger）
		 * 
		 * 
		 * JobDetail & CronTrigger 中的 name必须不一样，但是group组可以相同
		 * 
		 */
		
		scheduler.scheduleJob(jobdetail,trigger);
		
		scheduler.start();
		
		TimeUnit.SECONDS.sleep(6);
		
		
		/**
		 * 不同的job用不同的Scheduler
		 */
		Scheduler scheduler2 =  sf.getScheduler();
		
		JobDetail jobdetai2 =  JobBuilder.newJob(SimpleJob2.class).withIdentity("simplejob2", "trigger1group1").build();
		CronTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "trigger1group1")
		.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();  //每10s执行一次
		
		scheduler2.scheduleJob(jobdetai2,trigger2);
		
	//	scheduler2.start();
		
	}
	
}
