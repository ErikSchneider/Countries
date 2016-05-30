package com.theironyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        readFile(countryMap);

        System.out.println("Enter a letter to show country list");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        if (input.length() > 1 ) {
            throw new Exception("Can only be a single letter.");
        }

//        if (input.) {
//            throw new Exception("Must enter a letter.");
//        }

        writeFile(input, countryMap);

    }
    public static void readFile(HashMap<String, ArrayList<Country>> countryMap) throws FileNotFoundException {

        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {
            String line= fileScanner.nextLine();
            String columns[] = line.split("\\|");
            Country country = new Country(columns[1], columns[0]);
            String letter = String.valueOf(country.name.charAt(0)).toUpperCase();

            if (!countryMap.containsKey(letter)) {
                countryMap.put(letter, new ArrayList<>());
            }

            countryMap.get(letter).add(country);

        }
    }
    public static void writeFile(String s, HashMap<String, ArrayList<Country>> countryMap) throws IOException {
        String fileName = String.format("%s_countries.txt", s);
        FileWriter fW = new FileWriter(fileName);

        ArrayList<Country> countryList = countryMap.get(s);
        String content =  "";
        for (Country country: countryList) {
            content += String.format("%s | %s \n", country.abbreviation, country.name);
        }

        fW.write(content);
        fW.close();
    }
}

