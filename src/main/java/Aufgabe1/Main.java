package Aufgabe1;

public class Main {
    public static void main(String[] args) {

        String list1 = "\\Users\\Schnapfel\\IdeaProjects\\Test\\List1.txt";
        String list2 = "\\Users\\Schnapfel\\IdeaProjects\\Test\\List2.txt";

        Comparator comp = new Comparator();
        comp.compareLists(list1,list2);
    }
}
