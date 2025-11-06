import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab_11_Listmaker {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        boolean yesOrNo;
        boolean surelyDone = false;
        boolean surelyNotDone = true;
        do {
            String menuChoice = SafeInput.getRegExString(pipe, "A – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\nChoose what you would like to do:", "[AaDdIiPpQq]");
            if(menuChoice.equalsIgnoreCase("Q")) {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            yesOrNo = SafeInput.getYNConfirm(pipe, "If you would like to be done, press Y, if you want to continue, press N");
            if(yesOrNo) {
                surelyDone = SafeInput.getYNConfirm(pipe, "Are you sure? ");
            }
            if(!yesOrNo) {
                surelyNotDone = SafeInput.getYNConfirm(pipe, "Are you sure? ");
            }
        }while(surelyNotDone && !surelyDone);

    }
}