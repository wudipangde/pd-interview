package com.pd.interview.demo.bus;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @title: Bus
 * @author: wudipangde
 * @date: 2023/9/6 14:30
 */
@Data
public class Bus {
    private static final int MAX_PASSENGER_COUNT = 10;
    private static int runningBusCount = 0;
    /**公交名称*/
    private String busNumber;
    /**到站名称*/
    private int currentStation;
    /**到站名称*/
    private int totalStations = 20;
    /**下一站*/
    private int nextStation;
    /**预期时间*/
    private int expectedArrivalTime;
    /**载客人数*/
    private int passengerCount;

    public Bus(String busNumber) {
        this.busNumber = busNumber;
        this.passengerCount = 0;
    }

    public void start() {
        System.out.println("公交车 " + busNumber + " 开始发车！");
        runningBusCount++;

//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        executor1.execute(()->{
            while(currentStation < totalStations){
                currentStation++;
                System.out.println("公交车 " + busNumber + " 到达第 " + currentStation + " 站！");

                int passengersBoarding = (int) (Math.random() * 20);
                int passengersAlighting = (int) (Math.random() * passengerCount);
                passengerCount = Math.max(0, passengerCount - passengersAlighting) + passengersBoarding;

                System.out.println("公交车 " + busNumber + " 第 " + currentStation + " 站上车人数：" + passengersBoarding);
                System.out.println("公交车 " + busNumber + " 第 " + currentStation + " 站下车人数：" + passengersAlighting);
                System.out.println("公交车 " + busNumber + " 当前乘客人数：" + passengerCount);

                if (passengerCount >= MAX_PASSENGER_COUNT) {
                    if (runningBusCount < 10) {
                        Bus newBus = new Bus("00" + (runningBusCount + 1));
                        newBus.start();
                    }
                }
            }
            System.out.println("公交车 " + busNumber + " 到达终点站！");
//            runningBusCount--;
            executor1.shutdown();
        });
    }


}
