import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        boolean surelyDone = false;
        do {
            displayMenu();
            String menuChoice = SafeInput.getRegExString(pipe, "Choose what you would like to do:", "[AaDdIiPpQq]");
            switch(menuChoice) {
                case "A":
                case "a":
                    addToList(pipe, "What would you like to add to the list?");
                    break;
                case "D":
                case "d":
                    deleteFromList(pipe);
                    break;
                case "I":
                case "i":
                    insertItem(pipe);
                    break;
                case "P":
                case "p":
                    displayList();
                    break;
                case "Q":
                case "q":
                    surelyDone = SafeInput.getYNConfirm(pipe, "Are you sure? ");
                    break;
            }
        }while(!surelyDone);
    }

    private static void addToList(Scanner pipe, String prompt) {
        System.out.print(prompt + " ");
        list.add(pipe.nextLine());
    }

    private static void deleteFromList(Scanner pipe) {
        Integer offSize = list.size();
        Integer realSize = offSize - 1;
        if(realSize == -1) {
            System.out.println("You can't remove anything because there is nothing in your list!");
        }
        else {
            int userInt = SafeInput.getRangedInt(pipe, "Type in the location of the item you want removed [0-" + realSize + "]. Location", "There is no item at that location.", 0, realSize);
            // Integer userInteger = Integer.valueOf(userInt);
            // list.remove(userInteger);
            list.remove(userInt);
        }
    }

    private static void displayList() {
        System.out.println("---- LIST ----");
        for (String l : list) {
            System.out.println(l);
        }
        System.out.println("--------------");
    }

    private static void displayMenu() {
        System.out.print("------------- MENU --------------\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\n---------------------------------\n");
    }

    private static void insertItem(Scanner pipe) {
        Integer currentSizeOfList = list.size();
        System.out.print("What would you like to add to the list? ");
        String toBeAdded = pipe.nextLine();
        int userInt = SafeInput.getRangedInt(pipe, "Where would you like to add '" + toBeAdded + "'? Location", "There is no item at that location.", 0, currentSizeOfList);
        list.add(userInt, toBeAdded);
    }
}