package com.spicinemas.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spicinemas.arima.ARIMA;

@RestController
public class PredictController implements BaseController{
	
	@GetMapping(value = "/movieRecommend")
	public ResponseEntity<Object> movieRecm(@RequestParam String slotTimeDateMovie,@RequestParam String userId) {
		Scanner ino=null;
		try {
			ArrayList<Double> arraylist=new ArrayList<Double>();
			ino=new Scanner(new File("src/main/resources/"+slotTimeDateMovie+".txt"));
			while(ino.hasNext())
			{
				arraylist.add(Double.parseDouble(ino.next()));
			}
			System.out.println(arraylist);
			double[] dataArray=new double[arraylist.size()-1]; 
			for(int i=0;i<arraylist.size()-1;i++)
				dataArray[i]=arraylist.get(i);
			ARIMA arima=new ARIMA(dataArray); 
			int []model=arima.getARIMAmodel();
			System.out.println("Best model is [p,q]="+"["+model[0]+" "+model[1]+"]");
			System.out.println("Predict value="+arima.aftDeal(arima.predictValue(model[0],model[1])));
			int i = 0;
			while(true){
			if(arima.aftDeal(i)<25){
				break;
			}
			i = i + 1;
			}
			System.out.println("You need to book in "+i+" hours");
			System.out.println("Predict error="+(arima.aftDeal(arima.predictValue(model[0],model[1]))-arraylist.get(arraylist.size()-1))/arraylist.get(arraylist.size()-1)*100+"%");
		
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
