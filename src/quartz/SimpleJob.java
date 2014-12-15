package quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SimpleJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		
		System.out.println("==========================================================================================");
		System.out.print("start my job.." + new Date() + "\t");
		JobKey key =  context.getJobDetail().getKey();
		System.out.println("jobkey:" + key );
		
		System.out.println("==========================================================================================");
		
	}

}
