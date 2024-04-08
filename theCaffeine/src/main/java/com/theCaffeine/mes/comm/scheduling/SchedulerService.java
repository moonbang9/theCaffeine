package com.theCaffeine.mes.comm.scheduling;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {
	@Scheduled(fixedRate = 1000) // 1초마다 실행    
	public void run() {
		
	}
	
}
