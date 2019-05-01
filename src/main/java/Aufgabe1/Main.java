package Aufgabe1;

public class Main {
    public static void main(String[] args) {

        // Path to the list file
        // Change this path to test your own list
        String list1 = "\\Users\\Schnapfel\\IdeaProjects\\Test\\List1.txt";
        String list2 = "\\Users\\Schnapfel\\IdeaProjects\\Test\\List2.txt";


        Comparator comp = new Comparator();         // Create an Object of the class Comparator
        comp.compareLists(list1,list2);             // Call the function compare list, more of a test

        System.out.println(comp.serializeCompareLists(list1,list2)); // Does the same as the compareList method, but returns the result in the prescribed JSON format
    }
}
