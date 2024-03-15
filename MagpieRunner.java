/*
* Append MagpieRunner with your last name in class and file
*/

import java.util.Scanner;
public class MagpieRunner
{

	public static void main(String[] args){
   
		//instantiate the Magpie class
      //change Magpie to Magpie plus your name (MagpieIlkenhons)
      MagpieBaseGo maggie = new MagpieBaseGo();
		
      //instantiate the Scanner class
		Scanner in = new Scanner (System.in);
      
      //call the method getGreeting() of the MagpieBase class using the variable we used in our Magpie instantiation
		System.out.println(maggie.getGreeting());
      
      //store the input in the variable we used in our Scanner instantiation
		String statement = in.nextLine();
		
      //if the user doesn't say "bye" then we continually call the method getResponse() of the Magpie class 
      //while sending over user's (statement) and awaiting the user's next statement
		while (!statement.equals("bye"))
		{
			//while sending over (statement) and awaiting the user's next statement
         System.out.println(maggie.getResponse(statement));
			statement = in.nextLine();
		}
	}

}
