package com.tcharles.nfescrapper.config;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tcharles.nfescrapper.suport.Scrapper;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	// 5 min
	//private final long TIME_RUN = 1000 * 60 * 5;
	// 5 seg
	private final long TIME_RUN = 1000 * 60;
	
	@Override
	public void run(String... args){
		timerRun();
	}
	
    public void timerRun() {
		Timer timer = new Timer(); 
		timer.scheduleAtFixedRate(new TimerTask() {
			    @Override public void run() { 
			    	try {
						Scrapper scrapper = new Scrapper();
						
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }

		    }, 1000, TIME_RUN
		);
    }
    
    
	
}
