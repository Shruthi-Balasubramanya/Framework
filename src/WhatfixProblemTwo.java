import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WhatfixProblemTwo {

	public static void main(String[] args) {
		
		//Using Scanner class to accept input dynamically
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Orbit1 Traffic Speed in megamiles/hour: ");
		double OrbitOnetrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter Orbit2 Traffic Speed in megamiles/hour: ");
		double OrbitTwotrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter Orbit3 Traffic Speed in megamiles/hour: ");
		double OrbitThreetrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter Orbit4 Traffic Speed in megamiles/hour: ");
		double OrbitFourtrafficSpeed = scan.nextDouble();
		
		System.out.println("Enter weather (Sunny, Rainy, Windy):");
		String weatherCondition = scan.next();
		
		timeCalculation(OrbitOnetrafficSpeed, OrbitTwotrafficSpeed, OrbitThreetrafficSpeed,OrbitFourtrafficSpeed,weatherCondition);

	}

	// Note: Total expected travel time in each orbit will be calculated using the below logic:
	//Total Travel Time = (Orbit Total Distance / Minimum (Vehicle Speed,Traffic Speed)) + Normal Crater Delay + Weather Delay
	
	public static void timeCalculation(double OrbitOnetrafficSpeed, double OrbitTwotrafficSpeed, double OrbitThreetrafficSpeed,double OrbitFourtrafficSpeed ,String weatherCondition) {
		
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
		int orbitThreeDistance = 30;
		int orbitFourDistance = 15;
		
		//Crater count in each orbit as per problem statement
		int orbitOneCraterCount = 20;
		int orbitTwoCraterCount = 10;
		int orbitThreeCraterCount = 15;
		int orbitFourCraterCount = 18;
		
		//Vehicle maximum speed in megamiles/hour provided in problem statement
		int MaxBikeSpeed = 10;
		int MaxTukTukspeed = 12;
		int MaxCarSpeed = 20;

		//Initializing all the required variables
		double BikeSpeedOne = 0;
		double CarSpeedOne = 0;
		double TukTukSpeedOne = 0;

		double BikeSpeedTwo = 0;
		double CarSpeedTwo = 0;
		double TukTukSpeedTwo = 0;
		
		double BikeSpeedThree = 0;
		double CarSpeedThree = 0;
		double TukTukSpeedThree = 0;

		double BikeSpeedFour = 0;
		double CarSpeedFour = 0;
		double TukTukSpeedFour = 0;

		int NormalBikeCraterDelayOne = 0;
		int NormalTukTukCraterDelayOne =0;
		int NormalCarCraterDelayOne =0;
				
		int NormalBikeCraterDelayTwo = 0;
		int NormalTukTukCraterDelayTwo =0;
		int NormalCarCraterDelayTwo =0;
		
		int NormalBikeCraterDelayThree = 0;
		int NormalTukTukCraterDelayThree =0;
		int NormalCarCraterDelayThree =0;
				
		int NormalBikeCraterDelayFour = 0;
		int NormalTukTukCraterDelayFour =0;
		int NormalCarCraterDelayFour =0;
		
		
		
		double WeatherBikeCraterDelayOne =0;
		double WeatherTukTukCraterDelayOne =0;
		double WeatherCarCraterDelayOne =0;
		
		double WeatherBikeCraterDelayTwo =0;
		double WeatherTukTukCraterDelayTwo =0;
		double WeatherCarCraterDelayTwo =0;
		
		double WeatherBikeCraterDelayThree =0;
		double WeatherTukTukCraterDelayThree =0;
		double WeatherCarCraterDelayThree =0;
		
		double WeatherBikeCraterDelayFour =0;
		double WeatherTukTukCraterDelayFour =0;
		double WeatherCarCraterDelayFour =0;
		
		double TotalTimeBikeOrbitOne = 0;
		double TotalTimeTukTukOrbitOne = 0;
		double TotalTimeCarOrbitOne = 0;
		
		double TotalTimeBikeOrbitTwo = 0;
		double TotalTimeTukTukOrbitTwo = 0;
		double TotalTimeCarOrbitTwo = 0;
		
		double TotalTimeBikeOrbitThree = 0;
		double TotalTimeTukTukOrbitThree = 0;
		double TotalTimeCarOrbitThree = 0;
		
		double TotalTimeBikeOrbitFour = 0;
		double TotalTimeTukTukOrbitFour = 0;
		double TotalTimeCarOrbitFour = 0;

		// Determining the speed of vehicle in which the vehicle can go i.e. the minimum of vehicle speed and traffic speed

		//Bike speed not calculated since it cannot be used in Rainy season as per problem statement
		if(!weatherCondition.equals("Rainy")){
		BikeSpeedOne = Math.min(MaxBikeSpeed, OrbitOnetrafficSpeed);
		BikeSpeedTwo = Math.min(MaxBikeSpeed, OrbitTwotrafficSpeed);
		BikeSpeedThree = Math.min(MaxBikeSpeed, OrbitThreetrafficSpeed);
		BikeSpeedFour = Math.min(MaxBikeSpeed, OrbitFourtrafficSpeed);
		}
		
		//Tuk Tuk speed not calculated since it cannot be used in Windy season as per problem statement
		if(!weatherCondition.equals("Windy")){
		TukTukSpeedOne = Math.min(MaxTukTukspeed, OrbitOnetrafficSpeed);
		TukTukSpeedTwo = Math.min(MaxTukTukspeed, OrbitTwotrafficSpeed);
		TukTukSpeedThree = Math.min(MaxTukTukspeed, OrbitThreetrafficSpeed);
		TukTukSpeedFour = Math.min(MaxTukTukspeed, OrbitFourtrafficSpeed);
		}
		
		CarSpeedOne = Math.min(MaxCarSpeed, OrbitOnetrafficSpeed);
		CarSpeedTwo = Math.min(MaxCarSpeed, OrbitTwotrafficSpeed);
		CarSpeedThree = Math.min(MaxCarSpeed, OrbitThreetrafficSpeed);
		CarSpeedFour = Math.min(MaxCarSpeed, OrbitFourtrafficSpeed);
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
		
		//Orbit3
		NormalBikeCraterDelayThree = orbitThreeCraterCount *2;
		NormalTukTukCraterDelayThree = orbitThreeCraterCount *1;
		NormalCarCraterDelayThree = orbitThreeCraterCount *3;
		
		//Orbit4
		NormalBikeCraterDelayFour = orbitFourCraterCount *2;
		NormalTukTukCraterDelayFour = orbitFourCraterCount *1;
		NormalCarCraterDelayFour = orbitFourCraterCount *3;
		
		
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
			
			//Orbit3
			WeatherBikeCraterDelayThree = NormalBikeCraterDelayThree * -0.1;
			WeatherTukTukCraterDelayThree = NormalTukTukCraterDelayThree *-0.1;
			WeatherCarCraterDelayThree = NormalCarCraterDelayThree *-0.1;
			
			//Orbit4
			WeatherBikeCraterDelayFour = NormalBikeCraterDelayFour * -0.1;
			WeatherTukTukCraterDelayFour = NormalTukTukCraterDelayFour *-0.1;
			WeatherCarCraterDelayFour = NormalCarCraterDelayFour *-0.1;
			
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
			
			//Orbit3
			WeatherTukTukCraterDelayThree = NormalTukTukCraterDelayThree *0.2;
			WeatherCarCraterDelayThree = NormalCarCraterDelayThree *0.2;
			
			//Orbit4
			WeatherTukTukCraterDelayFour = NormalTukTukCraterDelayFour *0.2;
			WeatherCarCraterDelayFour = NormalCarCraterDelayFour *0.2;
			
		}

		// formula : Total Travel Time = (Orbit total distance /Minimum(Vehicle Speed, Traffic Speed)*60) + Normal Crater Delay + Weather Delay
		//Note: Time is multiplied by 60 in the calculation to convert hours to minutes
TotalTimeBikeOrbitOne = ((orbitOneDistance/BikeSpeedOne)*60) + NormalBikeCraterDelayOne + WeatherBikeCraterDelayOne;
TotalTimeTukTukOrbitOne = ((orbitOneDistance/TukTukSpeedOne)*60) + NormalTukTukCraterDelayOne + WeatherTukTukCraterDelayOne;
TotalTimeCarOrbitOne = ((orbitOneDistance/CarSpeedOne)*60) + NormalCarCraterDelayOne + WeatherCarCraterDelayOne;	

TotalTimeBikeOrbitTwo = ((orbitTwoDistance/BikeSpeedTwo)*60) + NormalBikeCraterDelayTwo + WeatherBikeCraterDelayTwo;
TotalTimeTukTukOrbitTwo = ((orbitTwoDistance/TukTukSpeedTwo)*60) + NormalTukTukCraterDelayTwo + WeatherTukTukCraterDelayTwo;
TotalTimeCarOrbitTwo = ((orbitTwoDistance/CarSpeedTwo)*60) + NormalCarCraterDelayTwo + WeatherCarCraterDelayTwo;	

TotalTimeBikeOrbitThree = ((orbitThreeDistance/BikeSpeedThree)*60) + NormalBikeCraterDelayThree + WeatherBikeCraterDelayThree;
TotalTimeTukTukOrbitThree = ((orbitThreeDistance/TukTukSpeedThree)*60) + NormalTukTukCraterDelayThree + WeatherTukTukCraterDelayThree;
TotalTimeCarOrbitThree = ((orbitThreeDistance/CarSpeedThree)*60) + NormalCarCraterDelayThree + WeatherCarCraterDelayThree;	

TotalTimeBikeOrbitFour = ((orbitFourDistance/BikeSpeedFour)*60) + NormalBikeCraterDelayFour + WeatherBikeCraterDelayFour;
TotalTimeTukTukOrbitFour = ((orbitFourDistance/TukTukSpeedFour)*60) + NormalTukTukCraterDelayFour + WeatherTukTukCraterDelayFour;
TotalTimeCarOrbitFour = ((orbitFourDistance/CarSpeedFour)*60) + NormalCarCraterDelayFour + WeatherCarCraterDelayFour;	

//Total time taken by each vehicle via RK Puram
double TotalBikeTimeViaRKPuram =0;
double TotalTukTukTimeViaRKPuram =0;
double TotalCarTimeViaRKPuram =0;
TotalBikeTimeViaRKPuram = TotalTimeBikeOrbitThree+TotalTimeBikeOrbitFour;
TotalTukTukTimeViaRKPuram = TotalTimeTukTukOrbitThree+TotalTimeTukTukOrbitFour;
TotalCarTimeViaRKPuram = TotalTimeCarOrbitThree+TotalTimeCarOrbitFour;

//Total time taken by each vehicle via Hallitaram
double TotalBikeTimeViaHallitaramOrbitOne =0;
double TotalBikeTimeViaHallitaramOrbitTwo =0;
double TotalTukTukTimeViaHallitaramOrbitOne =0;
double TotalTukTukTimeViaHallitaramOrbitTwo =0;
double TotalCarTimeViaHallitaramOrbitOne =0;
double TotalCarTimeViaHallitaramOrbitTwo =0;

TotalBikeTimeViaHallitaramOrbitOne = TotalTimeBikeOrbitOne+TotalTimeBikeOrbitFour;
TotalBikeTimeViaHallitaramOrbitTwo = TotalTimeBikeOrbitTwo+TotalTimeBikeOrbitFour;

TotalTukTukTimeViaHallitaramOrbitOne = TotalTimeTukTukOrbitOne+TotalTimeTukTukOrbitFour;
TotalTukTukTimeViaHallitaramOrbitTwo = TotalTimeTukTukOrbitTwo+TotalTimeTukTukOrbitFour;

TotalCarTimeViaHallitaramOrbitOne = TotalTimeCarOrbitOne+TotalTimeCarOrbitFour;
TotalCarTimeViaHallitaramOrbitTwo = TotalTimeCarOrbitTwo+TotalTimeCarOrbitFour;



//Values are inserted in Hashmap in the order such that if there is a tie in which vehicle to choose - bike, tuktuk, car are used in the same order.

Map<Double, String> VehicleMap = new HashMap<>();
VehicleMap.put(TotalBikeTimeViaRKPuram," Vehicle Bike to RK Puram via Orbit3 and Hallitharam via Orbit4");
VehicleMap.put(TotalBikeTimeViaHallitaramOrbitOne, "Vehicle Bike to Hallitharam via Orbit1 and RK Puram via Orbit4");
VehicleMap.put(TotalBikeTimeViaHallitaramOrbitTwo, "Vehicle Bike to Hallitharam via Orbit2 and RK Puram via Orbit4");

VehicleMap.put(TotalTukTukTimeViaRKPuram," Vehicle TukTuk to RK Puram via Orbit3 and Hallitharam via Orbit4");
VehicleMap.put(TotalTukTukTimeViaHallitaramOrbitOne, "Vehicle TukTuk to Hallitharam via Orbit1 and RK Puram via Orbit4");
VehicleMap.put(TotalTukTukTimeViaHallitaramOrbitTwo, "Vehicle TukTuk to Hallitharam via Orbit2 and RK Puram via Orbit4");

VehicleMap.put(TotalCarTimeViaRKPuram," Vehicle Car to RK Puram via Orbit3 and Hallitharam via Orbit4");
VehicleMap.put(TotalCarTimeViaHallitaramOrbitOne, "Vehicle Car to Hallitharam via Orbit1 and RK Puram via Orbit4");
VehicleMap.put(TotalCarTimeViaHallitaramOrbitTwo, "Vehicle Car to Hallitharam via Orbit2 and RK Puram via Orbit4");


//Sort the time taken by each vehicle in each orbit in ascending order
double[] TimeTakenList = {TotalBikeTimeViaRKPuram,TotalCarTimeViaRKPuram,TotalTukTukTimeViaRKPuram,
		TotalBikeTimeViaHallitaramOrbitOne,TotalBikeTimeViaHallitaramOrbitTwo,
		TotalCarTimeViaHallitaramOrbitOne,TotalCarTimeViaHallitaramOrbitTwo,
		TotalTukTukTimeViaHallitaramOrbitOne,TotalTukTukTimeViaHallitaramOrbitTwo}; 
//System.out.println("...."+TotalBikeTimeViaRKPuram);
//System.out.println("..."+TotalCarTimeViaRKPuram);
//System.out.println(".."+TotalTukTukTimeViaRKPuram);
//System.out.println(".."+TotalBikeTimeViaHallitaramOrbitOne);
//System.out.println("..."+TotalBikeTimeViaHallitaramOrbitTwo);
//System.out.println(".."+TotalCarTimeViaHallitaramOrbitOne);
//System.out.println("..."+TotalCarTimeViaHallitaramOrbitTwo);
//System.out.println("..."+TotalTukTukTimeViaHallitaramOrbitOne);
//System.out.println("..."+TotalTukTukTimeViaHallitaramOrbitTwo);
//System.out.println();

System.out.println();

Arrays.sort(TimeTakenList);
//for (int i = 0; i < TimeTakenList.length; i++) {
//	System.out.println(TimeTakenList[i]);
//}
//Identify the least time taken and its corresponding vehicle and orbit1
double FastestTravelTime = TimeTakenList[0];
//System.out.println(FastestTravelTime);
System.out.println(VehicleMap.get(FastestTravelTime));
}
	
}
