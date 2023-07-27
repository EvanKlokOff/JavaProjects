package make_spending_item;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.lang.NullPointerException;


public class makeSpendingItem{
    private final static String FolderForFiles = "FolderForFiles";
    private final static String fourTabulation = "             ";
    
    private static boolean makeDirForFile(){
        File f = new File(FolderForFiles);
        return f.mkdir();
    }

    public static void showAllFile(){
        System.out.println();
        File[] files = (new File(FolderForFiles)).listFiles();
        for(int i = 0; i < files.length; ++i){
            System.out.println(" " + files[i].getName() + " ");
        }
    }
    public static boolean makeItem(String nameOfItem){
        makeDirForFile();
        String nameOfItem_ = FolderForFiles + "/" + nameOfItem + ".txt";
        File f = new File(nameOfItem_);
        
        try(FileWriter fw = new FileWriter(f, false)){
            fw.write(nameOfItem + '\n');
            fw.flush();
        }catch(IOException e){
            e.getStackTrace();
        }
        
        boolean isCreateFile = false;
        try{isCreateFile = f.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Item was made successfully !!!");
        return isCreateFile;
    }

    private static File findDerectory(String nameOfDerectory){
        nameOfDerectory += ".txt";
        File[] files = (new File(FolderForFiles)).listFiles();
        
        for(int i = 0; i < files.length; ++i){
            //System.out.print(files[i].getName() + " ");
            if(nameOfDerectory.equals(files[i].getName())){
                //System.out.println("File is exist");
                return files[i];
            }   
        }
        System.out.println("File isn't exist");
        return null;
    }

    public static void openFile(String nameOfFile){
        
    }

    public static void deleteItem(String nameOfFile){
        File f = findDerectory(nameOfFile);
        boolean isDeleted;
        try{isDeleted = f.delete();
        }catch(NullPointerException e){
            isDeleted = false;  
        }
        String message = (isDeleted)?"file was deleted successefully":"Error while deleting"; 
        System.out.println(message);
    } 

    public static boolean writeToFile(String nameOfFile){
        boolean fileIsWriten = false;
        File f = findDerectory(nameOfFile);
        if(f == null){
            return fileIsWriten;
        }

        Scanner s = new Scanner(System.in);
        String line;
        
        try(FileWriter FW = new FileWriter(f, true)){
            System.out.println("Enter name of waste");
            line = s.nextLine();
            FW.write(line + fourTabulation);

            System.out.println("Enter amout of money");
            line = s.nextLine();
            FW.write(line + fourTabulation);
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            LocalDate ld = LocalDate.now();
            line = dtf.format(ld);
            FW.write(line + '\n');

            fileIsWriten = true;
            System.out.println("info was writen in file");
        }catch(IOException e){
            e.getStackTrace();
            System.out.println("Error while writing");
            fileIsWriten = false;
        }
        return fileIsWriten;
    }
}