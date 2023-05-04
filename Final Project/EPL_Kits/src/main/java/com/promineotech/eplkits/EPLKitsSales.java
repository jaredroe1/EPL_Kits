package com.promineotech.eplkits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class EPLKitsSales {
	
	  public static void main(String[] args) {
		    SpringApplication.run(EPLKitsSales.class, args);

		  }

}
