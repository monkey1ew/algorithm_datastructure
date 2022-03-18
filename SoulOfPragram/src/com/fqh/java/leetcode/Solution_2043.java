package com.fqh.java.leetcode;

/**
 * @author 海盗狗
 * @version 1.0
 * 2043. 简易银行系统
 */
public class Solution_2043 {

    public static void main(String[] args) {
        long[] balance = {10, 100, 20, 50, 30};
        Bank bank = new Bank(balance);
        bank.withdraw(3, 10);
    }
}

class Bank {
    private final int len;
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
        len = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 > len || account1 <= 0 || account2 > len || account2 <= 0 || balance[account1-1] < money) return false;
        balance[account1-1] -= money;
        balance[account2-1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > len || account <= 0) return false;
        balance[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > len || account <= 0 || balance[account-1] < money) return false;
        balance[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */