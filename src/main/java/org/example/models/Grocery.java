package org.example.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
        int choice;
        do {
            System.out.println("Press 0 for exit, 1 for add, 2 for remove.. ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Eklemek istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        } while(choice != 0);
        scanner.close();
    }

    public static void removeItems(String itemsToRemove) {
        String[] splitItems = itemsToRemove.split(",");
        for(String item : splitItems) {
            item = item.trim();
            if(!checkItemsInList(item)) {
                System.out.println("Item does not exist: " + item);
            } else {
                groceryList.remove(item);
                System.out.println(item + " removed.");
            }
        }
        sortItems();
    }

    public static void addItems(String itemsToAdd) {
        String[] splitItems = itemsToAdd.split(",");
        for(String item : splitItems) {
            item = item.trim();
            if(checkItemsInList(item)) {
                System.out.println("Item already exists: " + item);
            } else {
                groceryList.add(item);
                System.out.println(item + " added.");
            }
        }
        sortItems();
    }

    public static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Existing list: " + groceryList);
    }

    public static void sortItems() {
        Collections.sort(groceryList);
    }
}