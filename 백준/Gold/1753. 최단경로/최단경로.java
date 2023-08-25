import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		boolean[] v = new boolean[V+1];
		int[] dist = new int[V+1];
        for(int i=1;i<V+1;i++) dist[i] = Integer.MAX_VALUE;
        ArrayList<int[]>[] g = new ArrayList[V+1];
		for(int i=0;i<V+1;i++) g[i] = new ArrayList<int[]>();
        
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
				return 0;
			}
		});
        
		int start = Integer.parseInt(br.readLine().trim());
		for(int i =0; i<E;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,cost});
		}
		
		pq.offer(new int[] {start,0});
		dist[start] = 0;
        
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(v[now[0]]==true) continue;
			v[now[0]] = true;
			for(int i=0;i< g[now[0]].size();i++) {
				int[] next= g[now[0]].get(i);
				if(dist[next[0]]>=( next[1]+dist[now[0]])) {
					dist[next[0]] = next[1]+dist[now[0]];
					pq.offer(new int[] {next[0], dist[next[0]]});
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}