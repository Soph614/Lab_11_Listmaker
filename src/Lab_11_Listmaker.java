import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab_11_Listmaker {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean surelyDone = false;
        do {
            String menuChoice = SafeInput.getRegExString(pipe, "------------- MENU --------------\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\n---------------------------------\nChoose what you would like to do:", "[AaDdIiPpQq]");
            if(menuChoice.equalsIgnoreCase("Q")) {
                surelyDone = SafeInput.getYNConfirm(pipe, "Are you sure? ");
            }
        }while(!surelyDone);

    }
}