package pl.pk.java.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water = 400;
    private int milk = 540;
    private int beans = 120;
    private int cups = 9;
    private int money = 550;

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void makeCoffee() {
        System.out.println("Starting to make a coffee ");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("...");
        }
        String coffee;
        boolean actionLoop = false;

        while (!actionLoop) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine().toLowerCase();
            if (action.equals("buy")) {
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                coffee = scanner.nextLine();
                if (coffee.equals("1")) {
                    makeEspresso();
                } else if (coffee.equals("2")) {
                    makeLatte();
                } else if (coffee.equals("3")) {
                    makeCappuccino();
                } else if (coffee.equals("back")) {
                    makeCoffee();
                    break;
                } else {
                    System.out.println("Incorrect statement !!!");
                }
            } else if (action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                int fillWaterInMachine = scanner.nextInt();
                water += fillWaterInMachine;
                System.out.println("Write how many ml of milk do you want to add: ");
                int fillMilk1InMachine = scanner.nextInt();
                milk += fillMilk1InMachine;
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                int fillCoffeeBeansInMachine = scanner.nextInt();
                beans += fillCoffeeBeansInMachine;
                System.out.println("Write how many  disposable cups of coffee do you want to add: ");
                int fillAmountOfCups = scanner.nextInt();
                cups += fillAmountOfCups;
            } else if (action.equals("take")) {
                System.out.println("\nI gave you $" + money);
                money = 0;
            } else if (action.equals("remaining")) {
                printAmount(water, milk, beans, cups, money);
            } else if (action.equals("exit")) {
                actionLoop = true;
            } else {
                System.out.println("Incorrect statement !!!");
            }
        }
    }

    public void printAmount(int water, int milk, int beans, int cups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        if (money == 0) {
            System.out.println(money + " of money");
        } else
            System.out.println("$" + money + " of money");
    }

    public void makeEspresso() {
        int amountOfWater = 250;
        int amountOfMilk = 0;
        int amountOfBeans = 16;
        int amountOfCups = 1;
        int amountOfMoney = 4;
        calculateAmountOfResources(amountOfWater, amountOfMilk, amountOfBeans, amountOfCups, amountOfMoney);
    }

    public void makeLatte() {
        int amountOfWater = 350;
        int amountOfMilk = 75;
        int amountOfBeans = 20;
        int amountOfCups = 1;
        int amountOfMoney = 7;
        calculateAmountOfResources(amountOfWater, amountOfMilk, amountOfBeans, amountOfCups, amountOfMoney);
    }

    public void makeCappuccino() {
        int amountOfWater = 200;
        int amountOfMilk = 100;
        int amountOfBeans = 12;
        int amountOfCups = 1;
        int amountOfMoney = 6;
        calculateAmountOfResources(amountOfWater, amountOfMilk, amountOfBeans, amountOfCups, amountOfMoney);
    }

    public void calculateAmountOfResources(int amountOfWater, int amountOfMilk, int amountOfBeans, int amountOfCups, int amountOfMoney) {
        if (water < amountOfWater) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < amountOfMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < amountOfBeans) {
            System.out.println("Sorry, not enough beans!");
        } else if (cups < amountOfCups) {
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= amountOfWater;
            milk -= amountOfMilk;
            beans -= amountOfBeans;
            cups -= amountOfCups;
            money += amountOfMoney;
            System.out.println("I have enough resources, making you a coffee! ");
        }
    }
}


