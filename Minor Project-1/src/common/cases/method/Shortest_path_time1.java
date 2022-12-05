package common.cases.method;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import common.utlities.base1;
import common.utlities.common_method1;

public class Shortest_path_time1 extends Shortest_path_dist1 {

	public void shortest_path_time(BufferedReader inp) throws IOException {
		System.out.print("ENTER THE SOURCE STATION: ");
		String ss1 = inp.readLine();
		System.out.print("ENTER THE DESTINATION STATION: ");
		String ss2 = inp.readLine();
	
		HashMap<String, Boolean> processed3 = new HashMap<>();
		if(!base1.containsVertex(ss1,common_method1.vtces) || !base1.containsVertex(ss2,common_method1.vtces) || !this.hasPath(ss1, ss2, processed3))
			System.out.println("THE INPUTS ARE INVALID");
		else
		{
			ArrayList<String> str = this.get_Interchanges(this.Get_Minimum_Time(ss1, ss2));
			int len = str.size();
			System.out.println("SOURCE STATION : " + ss1);
			System.out.println("DESTINATION STATION : " + ss2);
			System.out.println("TIME : " + str.get(len-1)+" MINUTES");
			System.out.println("NUMBER OF INTERCHANGES : " + str.get(len-2));
			//System.out.println(str);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("START  ==>  " + str.get(0) + " ==>  ");
			for(int i=1; i<len-3; i++)
			{
				System.out.println(str.get(i));
			}
			System.out.print(str.get(len-3) + "   ==>    END");
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
        	        System.out.println("Please enter a valid option! ");
            	    System.out.println("The options you can choose are from 1 to 6. ");
                
	
	}
}

