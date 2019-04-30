package Aufgabe1;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read in .txt files, put them in an ArrayList.
 * Also provides methods to check for common entries in the files and which entries are only present in one of the files.
 */
public class Comparator {

    /**
     * Reads in a String (path to file) and read this file line by line and returns it in an ArrayList
     * @param path String, path to file
     * @return ArrayList containing all Strings from file
     */
    private static ArrayList<String> listToArray(String path){
        ArrayList<String> names = new ArrayList<String>();
        try{
            BufferedReader bfreader = new BufferedReader((new FileReader(path)));
            String line = bfreader.readLine();
            while (line != null){
                names.add(line);
                // read next line
                line = bfreader.readLine();
            }
            bfreader.close();
            //System.out.println(names.size());
            //System.out.println(names);
        } catch (IOException e){
            e.printStackTrace();
        }
        return names;
    }

    //Check methods with return value
    private static ArrayList<String> checkForCommon(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.retainAll(namesOfList2);
        System.out.println("Common: " + namesOfList1);
        return namesOfList1;
    }

    private static ArrayList<String> checkForDifference(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.removeAll(namesOfList2);
        System.out.println("Difference: " + namesOfList1);
        return namesOfList1;
    }

    /**
     * Reads in two .txt files (lists) and compare them.
     * What elements are only in list1, list 2 and which are in both?
     * @param list1 String (Path to list file)
     * @param list2 String (Path to list file)
     */
    public void compareLists(String list1, String list2){
        checkForCommon(list1,list2);
        checkForDifference(list1,list2);
        checkForDifference(list2,list1);
    }

    public String serializeCompareList(String list1, String list2){
        JsonOutput jsonOut = new JsonOutput(checkForDifference(list1,list2),checkForDifference(list2,list1),checkForCommon(list1,list2));
         String json = new Gson().toJson(jsonOut);
        return json;
    }


}

