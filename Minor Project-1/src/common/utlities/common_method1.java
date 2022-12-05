package common.utlities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class common_method1 extends base1 {
	protected static HashMap<String, Vertex> vtces;
	static base1 g=new base1();
	public common_method1() {
		vtces=new HashMap<>();
		common_method1.Create_Metro_Map();
	}
	
	public static void Create_Metro_Map()
	{
		g.addVertex("PCMC~V",vtces);
		g.addVertex("Nashik Phata~V",vtces);
		g.addVertex("Phugewadi~V",vtces);
		g.addVertex("Khadki~V",vtces);
		g.addVertex("Civil Court~VB",vtces);
		g.addVertex("Swargate~V",vtces);
		g.addVertex("Infosys Phase 2~R",vtces);
		g.addVertex("Wakad~R",vtces);
		g.addVertex("Baner~R",vtces);
		g.addVertex("Shivaji Nagar~RV",vtces);
		g.addVertex("Camp~R",vtces);
		g.addVertex("Hadapsar~R",vtces);
		g.addVertex("Kothrud~B",vtces);
		g.addVertex("Deccan~B",vtces);
		g.addVertex("Pune City~B",vtces);
		g.addVertex("Yerawada~B",vtces);
		g.addVertex("Kalyani Nagar~B",vtces);
		g.addVertex("Phoenix Mall",vtces);
		
		
		g.addEdge("PCMC~V", "Nashik Phata~V", 8,vtces);
		g.addEdge("Nashik Phata~V", "Phugewadi~V", 6,vtces);
		g.addEdge("Phugewadi~V", "Khadki~V", 4,vtces);
		g.addEdge("Khadki~V", "Shivaji Nagar~RV", 6,vtces);
		g.addEdge("Shivaji Nagar~RV", "Civil Court~VB", 2,vtces);
		g.addEdge("Civil Court~VB", "Swargate~V", 7,vtces);
		g.addEdge("Infosys Phase 2~R", "Wakad~R",10 ,vtces);
		g.addEdge("Wakad~R", "Baner~R", 6,vtces);
		g.addEdge("Baner~R", "Shivaji Nagar~RV", 12,vtces);
		g.addEdge("Shivaji Nagar~RV", "Camp~R", 6,vtces);
		g.addEdge("Camp~R", "Hadapsar~R", 7,vtces);
		g.addEdge("Kothrud~B", "Deccan~B", 6,vtces);
		g.addEdge("Deccan~B", "Civil Court~VB", 3,vtces);
		g.addEdge("Civil Court~VB", "Pune City~B", 5,vtces);
		g.addEdge("Pune City~B", "Yerwada~B", 6,vtces);
		g.addEdge("Yerawada~B", "Kalyani Nagar~B", 5,vtces);
		g.addEdge("Kalyani Nagar~B", "Phoenix Mall~B", 7,vtces);
		
	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) 
	{
		// DIR EDGE
		if (g.containsEdge(vname1, vname2,vtces)) {
			return true;
		}

		//MARK AS DONE
		processed.put(vname1, true);

		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());

		//TRAVERSE THE NBRS OF THE VERTEX
		for (String nbr : nbrs) 
		{

			if (!processed.containsKey(nbr))
				if (hasPath(nbr, vname2, processed))
					return true;
		}

		return false;
	}
	
	
	private class DijkstraPair implements Comparable<DijkstraPair> 
	{
		String vname;
		String psf;
		int cost;

		/*
		The compareTo method is defined in Java.lang.Comparable.
		Here, we override the method because the conventional compareTo method
		is used to compare strings,integers and other primitive data types. But
		here in this case, we intend to compare two objects of DijkstraPair class.
		*/ 

		/*
		Removing the overriden method gives us this errror:
		The type Graph_M.DijkstraPair must implement the inherited abstract method Comparable<Graph_M.DijkstraPair>.compareTo(Graph_M.DijkstraPair)

		This is because DijkstraPair is not an abstract class and implements Comparable interface which has an abstract 
		method compareTo. In order to make our class concrete(a class which provides implementation for all its methods)
		we have to override the method compareTo
		 */
		@Override
		public int compareTo(DijkstraPair o) 
		{
			return o.cost - this.cost;
		}
	}
	
	public int dijkstra(String src, String des, boolean nan) 
	{
		int val = 0;
		ArrayList<String> ans = new ArrayList<>();
		HashMap<String, DijkstraPair> map = new HashMap<>();

		Heap<DijkstraPair> heap = new Heap<>();

		for (String key : vtces.keySet()) 
		{
			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			//np.psf = "";
			np.cost = Integer.MAX_VALUE;

			if (key.equals(src)) 
			{
				np.cost = 0;
				np.psf = key;
			}

			heap.add(np);
			map.put(key, np);
		}

		//keep removing the pairs while heap is not empty
		while (!heap.isEmpty()) 
		{
			DijkstraPair rp = heap.remove();
			
			if(rp.vname.equals(des))
			{
				val = rp.cost;
				break;
			}
			
			map.remove(rp.vname);

			ans.add(rp.vname);
			
			Vertex v = vtces.get(rp.vname);
			for (String nbr : v.nbrs.keySet()) 
			{
				if (map.containsKey(nbr)) 
				{
					int oc = map.get(nbr).cost;
					Vertex k = vtces.get(rp.vname);
					int nc;
					if(nan)
						nc = rp.cost + 120 + 40*k.nbrs.get(nbr);
					else
						nc = rp.cost + k.nbrs.get(nbr);

					if (nc < oc) 
					{
						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + nbr;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}
			}
		}
		return val;
	}
	
	private class Pair 
	{
		String vname;
		String psf;
		int min_dis;
		int min_time;
	}
	
	public String Get_Minimum_Distance(String src, String dst) 
	{
		int min = Integer.MAX_VALUE;
		//int time = 0;
		String ans = "";
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "  ";
		sp.min_dis = 0;
		sp.min_time = 0;
		
		// put the new pair in stack
		stack.addFirst(sp);

		// while stack is not empty keep on doing the work
		while (!stack.isEmpty()) 
		{
			// remove a pair from stack
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) 
			{
				continue;
			}

			// processed put
			processed.put(rp.vname, true);
			
			//if there exists a direct edge b/w removed pair and destination vertex
			if (rp.vname.equals(dst)) 
			{
				int temp = rp.min_dis;
				if(temp<min) {
					ans = rp.psf;
					min = temp;
				}
				continue;
			}

			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for(String nbr : nbrs) 
			{
				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr + "  ";
					np.min_dis = rp.min_dis + rpvtx.nbrs.get(nbr); 
					//np.min_time = rp.min_time + 120 + 40*rpvtx.nbrs.get(nbr); 
					stack.addFirst(np);
				}
			}
		}
		ans = ans + Integer.toString(min);
		return ans;
	}
	
	
	public String Get_Minimum_Time(String src, String dst) 
	{
		int min = Integer.MAX_VALUE;
		String ans = "";
		HashMap<String, Boolean> processed = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();

		// create a new pair
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src + "  ";
		sp.min_dis = 0;
		sp.min_time = 0;
		
		// put the new pair in queue
		stack.addFirst(sp);

		// while queue is not empty keep on doing the work
		while (!stack.isEmpty()) {

			// remove a pair from queue
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) 
			{
				continue;
			}

			// processed put
			processed.put(rp.vname, true);

			//if there exists a direct edge b/w removed pair and destination vertex
			if (rp.vname.equals(dst)) 
			{
				int temp = rp.min_time;
				if(temp<min) {
					ans = rp.psf;
					min = temp;
				}
				continue;
			}

			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());

			for (String nbr : nbrs) 
			{
				// process only unprocessed nbrs
				if (!processed.containsKey(nbr)) {

					// make a new pair of nbr and put in queue
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr + "  ";
					//np.min_dis = rp.min_dis + rpvtx.nbrs.get(nbr);
					np.min_time = rp.min_time + 120 + 40*rpvtx.nbrs.get(nbr); 
					stack.addFirst(np);
				}
			}
		}
		Double minutes = Math.ceil((double)min / 60);
		ans = ans + Double.toString(minutes);
		return ans;
	}
	
	public ArrayList<String> get_Interchanges(String str)
	{
		ArrayList<String> arr = new ArrayList<>();
		String res[] = str.split("  ");
		arr.add(res[0]);
		int count = 0;
		for(int i=1;i<res.length-1;i++)
		{
			int index = res[i].indexOf('~');
			String s = res[i].substring(index+1);
			
			if(s.length()==2)
			{
				String prev = res[i-1].substring(res[i-1].indexOf('~')+1);
				String next = res[i+1].substring(res[i+1].indexOf('~')+1);
				
				if(prev.equals(next)) 
				{
					arr.add(res[i]);
				}
				else
				{
					arr.add(res[i]+" ==> "+res[i+1]);
					i++;
					count++;
				}
			}
			else
			{
				arr.add(res[i]);
			}
		}
		arr.add(Integer.toString(count));
		arr.add(res[res.length-1]);
		return arr;
	}
	
	
	
	
}
