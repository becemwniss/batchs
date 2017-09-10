package com.example.demo.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by pc-becem on 9/10/2017.
 */
public class SampleJob implements Job {
    @Autowired
    private SampleJobService jobService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        jobService.executeSampleJob();
    }
}
