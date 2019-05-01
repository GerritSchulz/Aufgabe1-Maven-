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

    /**
     * Checking for common entries in both lists.
     * Takes the first list and manipulates it.
     * @param list1 String, file and path to the first list
     * @param list2 String, file and path to the second list
     * @return ArrayList
     */
    private static ArrayList<String> checkForCommon(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.retainAll(namesOfList2);
        return namesOfList1;
    }

    /**
     * Checking for differences in both lists.
     * Takes the first list and manipulates it.
     * @param list1 String, file and path to the first list
     * @param list2 String, file and path to the second list
     * @return ArrayList
     */
    private static ArrayList<String> checkForDifference(String list1, String list2){
        ArrayList<String> namesOfList1 = listToArray(list1);
        ArrayList<String> namesOfList2 = listToArray(list2);
        namesOfList1.removeAll(namesOfList2);
        return namesOfList1;
    }

    /**
     * Reads in two .txt files (lists) and compare them.
     * What elements are only in list1, list 2 and which are in both?
     * Prints the result to the console.
     * @param list1 String (Path to list file)
     * @param list2 String (Path to list file)
     */
    public void compareLists(String list1, String list2){
        System.out.println("In both lists: " + checkForCommon(list1,list2));
        System.out.println("Only in list1" + checkForDifference(list1,list2));
        System.out.println("Only in list2" + checkForDifference(list2,list1));
    }

    /**
     * Reads in two Strings (path to list file) and returns a json as a String
     * @param list1 String (Path to list file)
     * @param list2 String (Path to list file)
     * @return String (json format)
     */
    public String serializeCompareLists(String list1, String list2){
        JsonOutput jsonOut = new JsonOutput(checkForDifference(list1,list2),checkForDifference(list2,list1),checkForCommon(list1,list2));
        return new Gson().toJson(jsonOut);
    }


}

