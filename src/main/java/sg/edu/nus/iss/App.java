package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private App() {
    }
    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */

    public static void main(String[] args) {
        //specify directory
        //create a folder
        String dirPath = "\\data2";
        //create file with empty name as it will be within main function
        String fileName = "";

        File newDirectory = new File(dirPath);
        if (newDirectory.exists()){
            System.out.println("Directory already exists!");
        } else {
            newDirectory.mkdir();
        }

        System.out.println("Welcome to My Shopping Cart!");

        //creates list, a dynamic array as it can have no limits on array
        List<String> cartItems = new ArrayList<String>();

        Console con = System.console();
        String input = ""; 

        while (!input.equals("quit")){
            input.con.readLine("What do you want to perform? Type 'quit' to exit program.");
            
            switch (input) {
                case "help":
                    displayMessage("'list' to show a list of items in the shopping cart");
                    displayMessage("login name to access yout shopping cart");
                    displayMessage("add item to add items to your shopping cart");
                    displayMessage("login name to access yout shopping cart");
                    displayMessage("delete <item #>");
                    displayMessage("quit to quit");
                    break;
                case "list":
                //creates list
                    if (cartItems.size() > 0 ){
                        for (String item: cartItems) {
                            System.out.printf(item);
                        }
                    } else {
                        System.out.println("Your cart is empty!");
                    }
                    break;
                case "user":
                    break; 
                default:
                    System.out.println("Hello");
            }

            if (input.startsWith("add")){
                //account for multiple permutations of add 
                input = input.replace(","," ");
                //start from 4th character
                Scanner scanner = new Scanner(input.substring(4));

                //take out item with while loop

                while(scanner.hasNext()){
                    //scans through every complete token
                    strValue = scanner.next();
                    //adds item to cart
                    cartItems.add(strValue);
                }
            }
        }

        public static void displayMessage(String message){
            System.out.println(message);
        }
        
        

    }
}
