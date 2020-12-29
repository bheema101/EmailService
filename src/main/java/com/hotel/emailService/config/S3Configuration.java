package com.hotel.emailService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class S3Configuration {

	
	
	@Bean
	public AmazonS3 createAmzonS3Client() {
		
		AWSCredentials credentials = new BasicAWSCredentials(
				  "", 
				  ""
				);
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()//bheema101221@gmail.com
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.AP_SOUTH_1)
				  .build();
		return s3client;
	}
}
