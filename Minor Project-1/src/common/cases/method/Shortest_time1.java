package common.cases.method;

import java.io.BufferedReader;
import java.io.IOException;

public class Shortest_time1 extends Shortest_dist1{
	public void shortest_time(BufferedReader inp) throws IOException {
		System.out.print("ENTER THE SOURCE STATION: ");
		String sat1 = inp.readLine();
		System.out.print("ENTER THE DESTINATION STATION: ");
		String sat2 = inp.readLine();
	
		//HashMap<String, Boolean> processed1= new HashMap<>();				
		System.out.println("SHORTEST TIME FROM ("+sat1+") TO ("+sat2+") IS "+this.dijkstra(sat1, sat2, true)/60+" MINUTES\n\n");
		
	}
}
