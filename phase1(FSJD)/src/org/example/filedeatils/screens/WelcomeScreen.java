package org.example.filedeatils.screens;
import java.util.*;

import org.example.filedeatils.services.*;
public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome to File details !";
    private String developerText = "Developer: Anegondi Narendra ";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("Main Menu");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("List of Files: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        Scanner i= new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = i.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }
}
