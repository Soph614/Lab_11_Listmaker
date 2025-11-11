import java.util.Scanner;
import java.util.ArrayList;



public class Lab_11_Listmaker {
    ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        boolean surelyDone = false;
        do {
            String menuChoice = SafeInput.getRegExString(pipe, "------------- MENU --------------\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\n---------------------------------\nChoose what you would like to do:", "[AaDdIiPpQq]");
            if (menuChoice.equalsIgnoreCase("A")) {
                String whatToAdd = addItem(pipe, "Enter what you would like to add to the list: ");
                list.add(whatToAdd);
            } else if (menuChoice.equalsIgnoreCase("D")) {
                Integer offSize = list.size();
                Integer realSize = offSize - 1;
                int userInt = SafeInput.getRangedInt(pipe, "Type in the location of the item you want removed [0-" + realSize + "]. Location", "There is no item at that location.", 0, realSize);
                // Integer userInteger = Integer.valueOf(userInt);
                // list.remove(userInteger);
                list.remove(userInt);
            } else if (menuChoice.equalsIgnoreCase("I")) {
                Integer currentSizeOfList = list.size();
                System.out.print("What would you like to add to the list? ");
                String toBeAdded = pipe.nextLine();
                int userInt = SafeInput.getRangedInt(pipe, "Where would you like to add '" + toBeAdded + "'? Location", "There is no item at that location.", 0, currentSizeOfList);
                list.add(userInt, toBeAdded);
            }


            if (menuChoice.equalsIgnoreCase("Q")) {
                surelyDone = SafeInput.getYNConfirm(pipe, "Are you sure? ");
            }
            System.out.println("--- LIST ---");
            for (String l : list) {
                System.out.println(l);
            }
            System.out.println("------------");
        } while (!surelyDone);

    }

    // METHODS
    private static String addItem(Scanner pipe, String prompt) {
        String whatToAdd = addItem(pipe, "Enter what you would like to add to the list: ");
        list.add(whatToAdd);
        return pipe.nextLine();
    }
}