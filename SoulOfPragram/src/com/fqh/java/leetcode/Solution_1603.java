package com.fqh.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 海盗狗
 * @version 1.0
 * 1603. 设计停车系统
 */
public class Solution_1603 {

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));

    }
}

class ParkingSystem {

    int[] bigSpace, mediumSpace, smallSpace;
    int bigSize, mediumSize, smallSize;

    public ParkingSystem(int big, int medium, int small) {
        bigSpace = new int[big];
        mediumSpace = new int[medium];
        smallSpace = new int[small];
    }

    public boolean addCar(int carType) {
        if (carType == 1 && bigSize < bigSpace.length) {
            bigSpace[bigSize++] = carType;
            return true;
        }else if (carType == 2 && mediumSize < mediumSpace.length) {
            mediumSpace[mediumSize++] = carType;
            return true;
        }else if (carType == 3 && smallSize < smallSpace.length) {
            smallSpace[smallSize++] = carType;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */