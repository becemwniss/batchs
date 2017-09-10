package com.example.demo;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableBatchProcessing
@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job1;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/launchjob")
	public String excute(){
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
		try {
			jobLauncher.run(job1, jobParameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "done";
	}

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob().ofType(com.example.demo.quartz.SampleJob.class)
				.storeDurably()
				.withIdentity("Qrtz_Job_Detail")
				.withDescription("Invoke Sample Job service...")
				.build();
	}

	@Bean
	public JobDetailFactoryBean jobDetail() {
		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(SampleJob.class);
		jobDetailFactory.setDescription("Invoke Sample Job service...");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}



}
