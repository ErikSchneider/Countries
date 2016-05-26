package com.theironyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line= fileScanner.nextLine();
            String columns[] = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            String letter = String.valueOf(country.name.charAt(0));

            if (!countryMap.containsKey(letter)) {
                countryMap.put(letter, new ArrayList<>());
            }

            countryMap.get(letter).add(country);
            System.out.println(countryMap);

        }
        System.out.println("Enter a letter to show country list");
        Scanner scanner = new Scanner(System.in);
        String userInput



    }
}