package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import common.cases.method.Shortest_path_time1;

public class m1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//common_method1 g=new common_method1();
		Shortest_path_time1 g1=new Shortest_path_time1();
		System.out.println("\n\t\t\t------- WELCOME TO THE METRO TRAVEL SOLUTIONS -------");
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("\t\t\t\t Please Select Your Choice From The Following Tasks Given Below: \n\n");
			System.out.println("1. List All The Metro Stations In The Metro Map");
			System.out.println("2. Display The Designed Metro Map");
			System.out.println("3. Obtain the Shortest Distance From a 'Source'  To 'Destination'");
			System.out.println("4. Obtain the Shortest Time To Reach From a 'Source' To 'Destination'");
			System.out.println("5. Obtain the Shortest Path (Distance Wise) To Reach From a 'Source' To 'Destination'");
			System.out.println("6. Obtain the Shortest Path (Time Wise) To Reach From a 'Source' To 'Destination'");
			System.out.println("7. Exit from Metro Travel Solutions");
			System.out.print("\nEnter Your Choice From The Above List [1 to 7] : ");
			int choice = -1;
			try {
				choice = Integer.parseInt(inp.readLine());
			} catch(Exception e) {
				// default will handle
			}
			System.out.print("\n----------------------------------------------------------\n");
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
