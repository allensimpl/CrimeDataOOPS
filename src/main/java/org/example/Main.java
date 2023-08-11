package org.example;
import com.opencsv.bean.CsvToBeanBuilder;
import org.joda.time.DateTime;

import javax.swing.text.html.Option;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private final static String filePath = "C:\\Users\\Simplogics\\IdeaProjects\\CrimeDataOOPS\\atlcrime.csv";
    public static List<Crime> objectClassesBuilder(String fileName) throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(fileName)).withSkipLines(1).withType(Crime.class).build().parse();
    }
    public static String getMonthName(int monthNoInYear){
        String month = null;
        switch(monthNoInYear){
            case 1:
                month = "January";
                break;
            case 2:
                month =  "February";
                break;
            case 3:
                month =  "March";
                break;
            case 4:
                month =  "April";
                break;
            case 5:
                month =  "May";
                break;
            case 6:
                month =  "June";
                break;
            case 7:
                month =  "July";
                break;
            case 8:
                month =  "August";
                break;
            case 9:
                month =  "September";
                break;
            case 10:
                month =  "October";
                break;

            case 11:
                month =  "November";
                break;
            case 12:
                month =  "December";
                break;
            default:
                month =  "FalseValue";
                break;

        }
        return month;
    }

    public static HashMap<String,Integer> parseDateYearMonth(String date) throws ParseException {
        String dateFormat = "M/d/yyyy";
        Date formattedDate = new SimpleDateFormat(dateFormat).parse(date);
        DateTime dt = new DateTime(formattedDate);
        int month = dt.monthOfYear().get();
        int year = dt.year().get();
        HashMap<String,Integer> yearAndMonth = new HashMap<>();
        yearAndMonth.put("year",year);
        yearAndMonth.put("month",month);
        return yearAndMonth;
    }
    public static void findResults(List<Crime> crimesList, Results results) throws ParseException {
        HashMap<Integer, Integer> yearsCountMap = new HashMap<>();
        HashMap<String,Integer> monthsCount = new HashMap<>();
        HashMap<String,Integer> crimesCount = new HashMap<>();
        HashMap<String,Integer> neighbourhoodCount = new HashMap<>();
        int minCrimeCount = Integer.MAX_VALUE;
        String minCrimeValue = null;
        int maxCrimeCount = Integer.MIN_VALUE;
        String maxCrimeValue = null;
        int minNeighbourhoodCount = Integer.MAX_VALUE;
        String minNeighbourhoodValue = null;
        int maxNeighbourhoodCount = Integer.MIN_VALUE;
        String maxNeighbourhoodValue=null;
        for(Crime crime:crimesList){
            String criminality = crime.getCrime();
            String neighbourhood = crime.getNeighborhood();
            HashMap<String, Integer> yearAndMonth = parseDateYearMonth(crime.getDate());
            int monthNumber = yearAndMonth.get("month");
            int year = yearAndMonth.get("year");
            String month = getMonthName(monthNumber);
//            System.out.println(criminality+" "+neighbourhood+" "+monthNumber+" "+year+" "+month);
            //Filling Year wise
            if (yearsCountMap.get(year) == null) {
                yearsCountMap.put(year, 1);
            } else {
                yearsCountMap.put(year, yearsCountMap.get(year) + 1);
            }
            Integer currentMonthCount = monthsCount.get(month);
            //Filling Month wise
            if (currentMonthCount == null){
                monthsCount.put(month, 1);
            } else {
                monthsCount.put(month, ++currentMonthCount);
            }
            //Filling criminality-wise
            if (crimesCount.get(criminality) == null) {
                crimesCount.put(criminality, 1);
            } else {
                crimesCount.put(criminality, crimesCount.get(criminality) + 1);
            }
            //Filling neighbourhoodWise
            if (neighbourhoodCount.get(neighbourhood) == null) {
                neighbourhoodCount.put(neighbourhood, 1);
            } else {
                neighbourhoodCount.put(neighbourhood, neighbourhoodCount.get(neighbourhood) + 1);
            }
        }
        Optional<Integer> maxYearOptional = yearsCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        Integer maxYear = maxYearOptional.get();
        Optional<String> maxNeighbourhoodOptional = neighbourhoodCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        String maxNeighbourhood = null;
        if(maxNeighbourhoodOptional.isPresent()){
            maxNeighbourhood = maxNeighbourhoodOptional.get();
        }
        Optional<String> minNeighbourhoodOptional = neighbourhoodCount.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        String minNeighbourhood = null;
        if(minNeighbourhoodOptional.isPresent()){
            minNeighbourhood = minNeighbourhoodOptional.get();
        }

        Optional<String> maxCrimeOptional = crimesCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        String maxCrime = null;
        if(maxCrimeOptional.isPresent()){
            maxCrime = maxCrimeOptional.get();
        }
        Optional<String> minCrimeOptional = crimesCount.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
        String minCrime = null;
        if(minCrimeOptional.isPresent()){
            minCrime = minCrimeOptional.get();
        }


        results.minNeighbourhoodName = minNeighbourhood;
        results.minNeighbourhoodValue = neighbourhoodCount.get(minNeighbourhood);
        results.maxNeighbourhoodName = maxNeighbourhood;
        results.maxNeighbourhoodValue = neighbourhoodCount.get(maxNeighbourhood);

        results.minCrimeName = minCrime;
        results.minCrimeValue = crimesCount.get(minCrime);
        results.maxCrimeName = maxCrime;
        results.maxCrimeValue = crimesCount.get(maxCrime);

        results.setYearCounts(yearsCountMap);
        results.setMonthCounts(monthsCount);
    }
    public static void main(String[] args)  {
        try{
            List<Crime> crimesList = objectClassesBuilder(filePath);
            Results results = new Results();
            findResults(crimesList,results);
            System.out.println(results.maxCrimeName);
            System.out.println(results.maxCrimeValue);
            System.out.println(results.minCrimeName);
            System.out.println(results.minCrimeValue);
            System.out.println(results.maxNeighbourhoodName);
            System.out.println(results.maxNeighbourhoodValue);
            System.out.println(results.minNeighbourhoodName);
            System.out.println(results.minNeighbourhoodValue);
            HashMap<Integer,Integer> years = results.yearCounts;
            results.yearCounts.forEach((k,v)-> System.out.println(k +" "+v));
            results.monthCounts.forEach((k,v)-> System.out.println(k+" "+v));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}