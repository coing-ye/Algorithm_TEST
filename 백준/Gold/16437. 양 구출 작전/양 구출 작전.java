import java.io.*;
import java.util.*;


public class Main {
	static public int N;
	static long[] dpisland;
	static int[][] depth;
	static public ArrayList<Integer>[] island;
	static public char[] animal;

	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		dpisland = new long[N+1];
		depth = new int[N+1][2];
		island = new ArrayList[N+1];
		animal = new char[N+1];

		
		for(int i=1;i<=N;i++) {
			island[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine().trim());
			animal[i+2] = st.nextToken().charAt(0);
			dpisland[i+2] = Integer.parseInt(st.nextToken());
			island[Integer.parseInt(st.nextToken())].add(i+2);	
		}
		
		depth[1][0] = 1;
		depth[1][1] = 1;
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.offer(1);
		while(!dq.isEmpty()) {
			int now = dq.pollFirst();
			for(int i=0;i<island[now].size();i++) {
				depth[island[now].get(i)][0] = island[now].get(i);
				depth[island[now].get(i)][1] = depth[now][1]+1;
				dq.offer(island[now].get(i));
			}
		}
//		for(int i = 0;i <=N;i++) {
//			System.out.println(Arrays.toString(depth[i]));
//		}
//		for(int i=1;i<=N;i++) {
//			depth[i][0] =i;
//			for(int l=0;l<island[i].size();l++) {
//				depth[island[i].get(l)][1] = depth[i][1]+1;
//			}
//		}
		
		Arrays.sort(depth, (int[] o1, int[] o2) -> -Integer.compare(o1[1], o2[1]));
		//System.out.println(Arrays.toString(amount));
		
		//System.out.println(Arrays.toString(dpisland));
		
		for(int i= 0; i<N;i++) {
			int node = depth[i][0];
			long lowsheep = 0;

			for(int l=0;l<island[node].size();l++) {
				lowsheep += dpisland[island[node].get(l)];
			}
			if(animal[node] =='S') {
				dpisland[node] += lowsheep;
			}
			else if(animal[node] == 'W') {
				if(lowsheep > dpisland[node]) dpisland[node] = lowsheep - dpisland[node];
				else dpisland[node] = 0;
			}
			
			if(node==1) dpisland[node] += lowsheep;
			
			
			//System.out.println(node+" "+ Arrays.toString(dpisland));
			
		}
		//System.out.println(Arrays.toString(dpisland));
		System.out.println(dpisland[1]);
		
		
	}

}