package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import common.cases.method.Shortest_path_time1;

public class m1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//common_method1 g=new common_method1();
		Shortest_path_time1 g1=new Shortest_path_time1();
		System.out.println("\n\t\t\t****WELCOME TO THE METRO APP*****");
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("\t\t\t\t~~LIST OF ACTIONS~~\n\n");
			System.out.println("1. LIST ALL THE STATIONS IN THE MAP");
			System.out.println("2. SHOW THE METRO MAP");
			System.out.println("3. GET SHORTEST DISTANCE FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
			System.out.println("4. GET SHORTEST TIME TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
			System.out.println("5. GET SHORTEST PATH (DISTANCE WISE) TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
			System.out.println("6. GET SHORTEST PATH (TIME WISE) TO REACH FROM A 'SOURCE' STATION TO 'DESTINATION' STATION");
			System.out.println("7. EXIT THE MENU");
			System.out.print("\nENTER YOUR CHOICE FROM THE ABOVE LIST (1 to 7) : ");
			int choice = -1;
			try {
				choice = Integer.parseInt(inp.readLine());
			} catch(Exception e) {
				// default will handle
			}
			System.out.print("\n***********************************************************\n");
			if(choice == 7)
			{
				System.exit(0);
			}
			switch(choice)
			{
			case 1:
				g1.display_Stat();
				break;
		
			case 2:
				g1.display_Map();
				break;
			
			case 3:
				g1.Shortest_distance(inp);
				break;
			case 4:
				g1.shortest_time(inp);
				break;
			case 5:
				g1.shortest_path_distance(inp);
				break;
			case 6:
				g1.shortest_path_time(inp);
				break;
			    default: 
			}
			}
		
	}

}
