package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract  class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public static Car create(int type, int numberOfPassengers){
        switch (type){
            case 0:return new Truck(numberOfPassengers);
            case 1:return new Sedan(numberOfPassengers);
            case 2:return new Cabriolet(numberOfPassengers);
        }
       return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }
    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if (date.getTime()>summerStart.getTime()&&date.getTime()<summerEnd.getTime()){
            return true;
        }else return false;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        boolean isSummer = isSummer(date, SummerStart, SummerEnd);
        double consumption;
        if (isSummer){
            consumption = getSummerConsumption(length);
        }else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        else return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
            fastenDriverBelt();

    }
    public double getWinterConsumption(int length){

        return length*winterFuelConsumption+winterWarmingUp;
    }
   private boolean canPassengersBeTransferred(){
        if (isDriverAvailable()&&fuel>0)
        return true;
        else return false;
    }


    public double getSummerConsumption(int length){
        return length*summerFuelConsumption;
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();
}