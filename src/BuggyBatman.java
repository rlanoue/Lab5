import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * 
 * @author MoSho
 * @version 2018-09-20
 * Lab 5 Demo
 * 
 * Demo to illustrate use of the debugger and simple try/catch
 * 
 * FIRST, Students may download buggy code from canvas.
 * SECOND, run the code. Did it run properly? If not what went wrong.
 * THRID, fix the immediate error, and re-run. Did it run properly 
 * 		this time? If not what went wrong?
 * FOURTH, if there was another error, fix it. Re-run. Repeat this 
 * 		process until the code runs as desired.
 */

public class BuggyBatman {

    /**
     * @param args Not used
     * @throws IOException If there is an IO error
     */
    public static void main(String[] args) throws IOException 
    {
    	///////////////////////////////////////////////////////////////////
    	// EXAMPLE 1:
        // Open file for input
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        // Read each line of file
        String input = br.readLine();
        while(input != null)
        {
        	
            String[] words = input.split("\\s");
            System.out.println(input);
            input = br.readLine();
            // In debugger: observe the contents of the words array
        }
        // Close out the buffered reader
        br.close();
        System.out.println("\n\n\n");
        

    	///////////////////////////////////////////////////////////////////
    	// EXAMPLE 2:
        // Print out teams and corresponding members
        // Very briefly describe the concepts of queues and hash maps.
        // These are not too important to explain, just want to start 
        // exposing them to other data structures.
        // Students, see API for more dets
        Queue<GenericHero> HeroesQ = new LinkedList<GenericHero>();
        HashMap<String, String> Heroes = new HashMap<String, String>(); // place break point
        // In debugger: watch line by line as entries are added into the HashMap
        Heroes.put("Batman", "Justice League");
        Heroes.put("Captain America", "Avengers");
        Heroes.put("Superman", "Justice League");
        Heroes.put("Ironman", "Avengers");
        Heroes.put("Wonder Woman", "Justice League");
        Heroes.put("Thor", "Avengers");
        
        // In debugger: Watch as JL and Avengers update. Notice anything wrong?
        String JL = "Justice League Roster:\n";
        String Avengers = "Avengers Roster:\n";
        for (Entry<String, String> hero : Heroes.entrySet())
        {
        	String name = hero.getKey();
        	String team = hero.getValue();
        	// In debugger: Take a look at the name and team variables, expand to see that strings are actually arrays

        	if (team.equalsIgnoreCase("Justice League")) JL += String.format("\t%s,\n ", name);
        	else Avengers += String.format("\t%s,\n ", name);
        	
        	System.out.println("** curr hero name: " + name);
        	System.out.println("** curr hero team: " + team);
        	System.out.println("** JL after: " + JL);
        	
        	// In debugger: Step inside GenericHero Constructor
        				// then Step Out
        	HeroesQ.add(new GenericHero(name, team)); 
        }
        System.out.format("%s\n", JL);
        System.out.format("%s\n", Avengers);
        

    	///////////////////////////////////////////////////////////////////
    	// EXAMPLE 3: Exception Handling
        // Read from standard in
		System.out.print("\nEnter an integer \n>> ");
		String input2; 
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        input2 = br2.readLine();
        // Try entering a non-integer as input. 
        // How can we handle these use cases?
        // Can we continually prompt the user until they give us valid input, or quit?
        try{
        	int someNumber = Integer.parseInt(input2);
        	someNumber *= 2;
        	System.out.format("Your final integer be %d", someNumber);
        	}
        catch (NumberFormatException nfe)
        {
        	System.out.println("Hey bro, that ain't a number!");
        }
        
        /* 	Throws Exception vs Try Catch ^ k
        int someNumber3 = Integer.parseInt(input2);
        if (someNumber3 < 0) throw new NumberFormatException(); 
        someNumber3 *= 3; 
        System.out.format("Your final number is %d", someNumber3);
        */
    }
}
