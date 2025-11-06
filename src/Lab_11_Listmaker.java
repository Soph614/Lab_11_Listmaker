import java.util.Scanner;
import java.util.ArrayList;

public class Lab_11_Listmaker {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean done;
        do {
            String menuChoice = SafeInput.getRegExString(pipe, "Choose what you would like to do:\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\n   ", "[AaDdIiPpQq]");
            System.out.println(menuChoice);
            done = SafeInput.getYNConfirm(pipe, "If you would like to be done, press Y, if you want to continue, press N");
        }while(!done);

    }
}