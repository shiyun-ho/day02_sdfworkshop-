package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.io.IOException;
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
    

    public static void main(String[] args) throws IOException {
        //specify directory
        //create a folder
        String dirPath = ".\\";
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
            input = con.readLine("What do you want to perform? Type 'quit' to exit program.");
            
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
                    listCart(cartItems);
                case "user":
                    break; 
                default:
            }

            
            if (input.startsWith("login")){
                input = input.replace(",", " ");
                
                String strLogin = " ";
                
                Scanner scanner = new Scanner(input.substring(6));

                while (scanner.hasNext()){
                    fileName = scanner.next();}
                
                File loginFile = new File(dirPath + File.separator + fileName);

                boolean isCreated = loginFile.createNewFile(); 

                if (isCreated){
                    displayMessage("New file created successfully" + loginFile.getCanonicalPath());
                } else {
                    displayMessage("File already created!");
                }
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

            if (input.startsWith("delete")){
                cartItems = deleteCartItem(cartItems, input);
            }
        }

        public static List<String> deleteCartItem(List<String> cartItems, String input){
            String strValue = "";
            Scanner scanner = new Scanner(input.substring(6));

                while (scanner.hasNext()){
                    strValue = scanner.next();
                    int listItemIndex = Integer.parseInt(strValue);

                    if (listItemIndex < cartItems.size()){
                        cartItems.remove(listItemIndex);
                    } else {
                        displayMessage("Incorrect item index.");
                    }
                }
            return cartItems;
        }
        public static void listCart(List<String> cartItems){
            if (cartItems.size()>0){
                // for (String item: cartItems){
                //     System.out.println(item);
                // }
                for (int i =0; i < cartItems.size(), i++){
                    System.out.printf("%d: %s\n", i, cartItems.get(i));
                } 
            } else {
                    System.out.println("Your cart is empty.");
                }
        }
        
        
        

    }
    
    public static void displayMessage(String message){
                System.out.println(message);
            }

    
}
