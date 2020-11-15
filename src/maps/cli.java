package maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class cli {
    
        Map<Integer, Person> people = new HashMap<>();

	public cli() {
		
		int option = -1;
		
		do {
			do {
				displayOptions();
				option = readingIntFromUser();
				
			} while (!validMenuOption(option));
			
			if(option == 1) {
				addPerson();
			}
                        else if (option == 2){
                                retrievePerson();
                        }

		} while (option != 0);
                
                System.out.println("Bye");
                System.exit(0);
		
	}
	
	public void displayOptions() {
		System.out.println("What do you want to do?");
		System.out.println("Press 1 to store a new record");
                System.out.println("Press 2 to retrieve a record");
		System.out.println("Press 0 to exit");
	}
	
	public int readingIntFromUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String optionString = null;
		int option = -1; 
		
		try {
			optionString = br.readLine();
			option = Integer.parseInt(optionString); 
			 
		} catch (IOException | NumberFormatException e) {
			System.out.println("That's not a valid option, please an integer number");
		}

		return option;
	}
        
        public String readingStringFromUser() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = ""; 
		
		try {
			input = br.readLine();			 
		} catch (IOException e) {
			System.out.println("Oops! Something went wrong");
		}

		return input;
	}
	
	public boolean validMenuOption(int option) {
		return option >= 0 && option <= 2;
	}
	
	public void addPerson() {
		
            	String name = "";
                int age = -1;
		
		do {
        		System.out.println("Type in the name");
        		name = readingStringFromUser();
		} while (name.equals(""));
                
                do {
        		System.out.println("Type in the age");
        		age = readingIntFromUser();
		} while (age == -1);
                
                Person p = new Person(name, age);
                int id = p.getId();
                
                people.put(id, p);
                System.out.println("The ID of the new person is: " + id);
                
	}
        
        public void retrievePerson(){
            
                int id = -1;
                
                do {
        		System.out.println("Type in the ID of the person");
        		id = readingIntFromUser();
		} while (id == -1);
                
                Person p = people.get(id);
                
                if(p == null){
                    System.out.println("There is no record with that ID");
                    return;
                }
                System.out.println(p);
                
        }
	
}
