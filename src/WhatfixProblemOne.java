import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WhatfixProblemOne {

	public static void main(String[] args) {
		
		//Using Scanner class to accept input dynamically
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Orbit1 Traffic Speed in megamiles/hour: ");
		double OrbitOnetrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter Orbit2 Traffic Speed in megamiles/hour: ");
		double OrbitTwotrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter weather (Sunny, Rainy, Windy):");
		String weatherCondition = scan.next();
		
		timeCalculation(OrbitOnetrafficSpeed, OrbitTwotrafficSpeed, weatherCondition);

	}

	// Note: Total expected travel time in each orbit will be calculated using the below logic:
	//Total Travel Time = (Orbit Total Distance / Minimum (Vehicle Speed,Traffic Speed)) + Normal Crater Delay + Weather Delay
	
	public static void timeCalculation(double OrbitOnetrafficSpeed, double OrbitTowtrafficSpeed, String weatherCondition) {
		
		//Checking valid input for the variable 'weatherCondition'
		if(weatherCondition.equals("Sunny"))
			weatherCondition = "Sunny";
		else if(weatherCondition.equals("Rainy"))
			weatherCondition = "Rainy";
		else if(weatherCondition.equals("Windy"))
			weatherCondition = "Windy";
		else{
			System.out.println("Invalid weather input");
			System.exit(1);
		}
		
		//Orbit distance in megamiles provided in problem statement
		int orbitOneDistance = 18;
		int orbitTwoDistance = 20;
		
		//Crater count in each orbit as per problem statement
		int orbitOneCraterCount = 20;
		int orbitTwoCraterCount = 10;

		//Vehicle maximum speed in megamiles/hour provided in problem statement
		int MaxBikeSpeed = 10;
		int MaxTukTukSpped = 12;
		int MaxCarSpeed = 20;

		//Initializing all the required variables
		double BikeSpeedOne = 0;
		double CarSpeedOne = 0;
		double TukTukSpeedOne = 0;

		double BikeSpeedTwo = 0;
		double CarSpeedTwo = 0;
		double TukTukSpeedTwo = 0;

		int NormalBikeCraterDelayOne = 0;
		int NormalTukTukCraterDelayOne =0;
		int NormalCarCraterDelayOne =0;
		
		int NormalBikeCraterDelayTwo = 0;
		int NormalTukTukCraterDelayTwo =0;
		int NormalCarCraterDelayTwo =0;
		
		double WeatherBikeCraterDelayOne =0;
		double WeatherTukTukCraterDelayOne =0;
		double WeatherCarCraterDelayOne =0;
		
		double WeatherBikeCraterDelayTwo =0;
		double WeatherTukTukCraterDelayTwo =0;
		double WeatherCarCraterDelayTwo =0;
		
		double TotalTimeBikeOrbitOne = 0;
		double TotalTimeTukTukOrbitOne = 0;
		double TotalTimeCarOrbitOne = 0;
		
		double TotalTimeBikeOrbitTwo = 0;
		double TotalTimeTukTukOrbitTwo = 0;
		double TotalTimeCarOrbitTwo = 0;

		// Determining the speed of vehicle in which the vehicle can go i.e. the minimum of vehicle speed and traffic speed

		//Bike speed not calculated since it cannot be used in Rainy season as per problem statement
		if(!weatherCondition.equals("Rainy")){
		BikeSpeedOne = Math.min(MaxBikeSpeed, OrbitOnetrafficSpeed);
		BikeSpeedTwo = Math.min(MaxBikeSpeed, OrbitTowtrafficSpeed);
		}
		
		//Tuk Tuk speed not calculated since it cannot be used in Windy season as per problem statement
		if(!weatherCondition.equals("Windy")){
		TukTukSpeedOne = Math.min(MaxTukTukSpped, OrbitOnetrafficSpeed);
		TukTukSpeedTwo = Math.min(MaxTukTukSpped, OrbitTowtrafficSpeed);
		}
		
		CarSpeedOne = Math.min(MaxCarSpeed, OrbitOnetrafficSpeed);
		CarSpeedTwo = Math.min(MaxCarSpeed, OrbitTowtrafficSpeed);
		
		//Calculating normal crater delay:
		// formula : Crater Delay (No. of craters * Vehicle delay per crater)

		//Orbit1
		NormalBikeCraterDelayOne = orbitOneCraterCount * 2;
		NormalTukTukCraterDelayOne = orbitOneCraterCount *1;
		NormalCarCraterDelayOne = orbitOneCraterCount *3;
		
		//Orbit2
		
		NormalBikeCraterDelayTwo = orbitTwoCraterCount * 2;
		NormalTukTukCraterDelayTwo = orbitTwoCraterCount *1;
		NormalCarCraterDelayTwo = orbitTwoCraterCount *3;
		
		//Calculating weather delay
		//Sunny - craters reduce by 10%. Car, bike and tuktuk can be used in this weather. 
		//Rainy - craters increase by 20%. Car and tuktuk can be used in this weather. 
		//Windy - no change to number of craters. Bike and car can be used in this weather.
		
		if(weatherCondition.equals("Sunny")){
			
			//Orbit1
			WeatherBikeCraterDelayOne = NormalBikeCraterDelayOne * -0.1;
			WeatherTukTukCraterDelayOne = NormalTukTukCraterDelayOne *-0.1;
			WeatherCarCraterDelayOne = NormalCarCraterDelayOne *-0.1;
			
			//Orbit2
			
			WeatherBikeCraterDelayTwo = NormalBikeCraterDelayTwo * -0.1;
			WeatherTukTukCraterDelayTwo = NormalTukTukCraterDelayTwo *-0.1;
			WeatherCarCraterDelayTwo = NormalCarCraterDelayTwo *-0.1;
			
		}
		
		else if(weatherCondition.equals("Rainy")){
			
			//Orbit1
			//WeatherBikeCraterDelayOne = NormalBikeCraterDelayOne * 0.2;
			WeatherTukTukCraterDelayOne = NormalTukTukCraterDelayOne *0.2;
			WeatherCarCraterDelayOne = NormalCarCraterDelayOne *0.2;
			
			//Orbit2
			
			//WeatherBikeCraterDelayTwo = NormalBikeCraterDelayTwo * 0.2;
			WeatherTukTukCraterDelayTwo = NormalTukTukCraterDelayTwo *0.2;
			WeatherCarCraterDelayTwo = NormalCarCraterDelayTwo *0.2;
			
		}

		// formula : Total Travel Time = (Orbit total distance /Minimum(Vehicle Speed, Traffic Speed)*60) + Normal Crater Delay + Weather Delay
		//Note: Time is multiplied by 60 in the calculation to convert hours to minutes
TotalTimeBikeOrbitOne = ((orbitOneDistance/BikeSpeedOne)*60) + NormalBikeCraterDelayOne + WeatherBikeCraterDelayOne;
TotalTimeTukTukOrbitOne = ((orbitOneDistance/TukTukSpeedOne)*60) + NormalTukTukCraterDelayOne + WeatherTukTukCraterDelayOne;
TotalTimeCarOrbitOne = ((orbitOneDistance/CarSpeedOne)*60) + NormalCarCraterDelayOne + WeatherCarCraterDelayOne;	
TotalTimeBikeOrbitTwo = ((orbitTwoDistance/BikeSpeedTwo)*60) + NormalBikeCraterDelayTwo + WeatherBikeCraterDelayTwo;
TotalTimeTukTukOrbitTwo = ((orbitTwoDistance/TukTukSpeedTwo)*60) + NormalTukTukCraterDelayTwo + WeatherTukTukCraterDelayTwo;
TotalTimeCarOrbitTwo = ((orbitTwoDistance/CarSpeedTwo)*60) + NormalCarCraterDelayTwo + WeatherCarCraterDelayTwo;	


//Values are inserted in Hashmap in the order such that if there is a tie in which vehicle to choose - bike, tuktuk, car are used in the same order.
Map<Double, String> VehicleMap = new HashMap<>();
VehicleMap.put(TotalTimeBikeOrbitOne,"Vehicle Bike on Orbit1");
VehicleMap.put(TotalTimeBikeOrbitTwo, "Vehicle Bike on Orbit2");
VehicleMap.put(TotalTimeTukTukOrbitOne, "Vehicle TukTuk on Orbit1");
VehicleMap.put(TotalTimeTukTukOrbitTwo, "Vehicle TukTuk on Orbit2");
VehicleMap.put(TotalTimeCarOrbitOne, "Vehicle Car on Orbit1");
VehicleMap.put(TotalTimeCarOrbitTwo, "Vehicle Car on Orbit2");

//Sort the time taken by each vehicle in each orbit in ascending order
double[] TimeTakenList = {TotalTimeBikeOrbitOne,TotalTimeTukTukOrbitOne,TotalTimeCarOrbitOne,TotalTimeBikeOrbitTwo,TotalTimeTukTukOrbitTwo,TotalTimeCarOrbitTwo}; 
Arrays.sort(TimeTakenList);

//Identify the least time taken and its corresponding vehicle and orbit1
double FastestTravelTime = TimeTakenList[0];
//System.out.println(FastestTravelTime);
System.out.println(VehicleMap.get(FastestTravelTime));
}
	
}
