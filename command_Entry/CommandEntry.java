package command_Entry;

import make_spending_item.makeSpendingItem;
import java.util.Scanner;

public class CommandEntry{
    public static void CommandEntrance(){
        Scanner s = new Scanner(System.in);
        String command,argumet;
        
        final String quit = "quit";
        final String makeItem = "makeItem";
        final String writeFile = "writeFile";
        final String deleteItem = "deleteItem";
        final String showAllFile = "showAllFile";
        do{
            command = s.nextLine();

            switch(command){
                case (quit):{
                    System.out.println("exit");
                    break;
                }
                case(makeItem):{
                    System.out.println("Enter name of item");
                    argumet = s.nextLine();
                    makeSpendingItem.makeItem(argumet);
                    break;
                }
                case(writeFile):{
                    System.out.println("Choose name of file");
                    argumet = s.nextLine();
                    makeSpendingItem.writeToFile(argumet);
                    break;
                }
                case(deleteItem):{
                    System.out.println("Enter name of item, which u want to delete");
                    argumet = s.nextLine();
                    makeSpendingItem.deleteItem(argumet);
                    break;
                }
                case(showAllFile):{
                    makeSpendingItem.showAllFile();
                    break;
                }
                default:{
                    System.out.println("Wrong Command");
                    return;
                }
            }
        }while(!command.equals(quit));

    }
}