package com.pd.interview.demo.bus;

/**
 * @title: DispatchSystem
 * @author: wudipangde
 * @date: 2023/9/6 14:43
 */
public class DispatchSystem {
    public static void main(String[] args) {
        Bus bus1 = new Bus("001");
        Bus bus2 = new Bus("002");
        bus1.start();
        bus2.start();
    }
}
