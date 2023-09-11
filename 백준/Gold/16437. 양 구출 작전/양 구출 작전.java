import java.io.*;
import java.util.*;


public class Main {
	static public int N;
	static long[] dpisland;
	static int[][] depth;
	static public ArrayList<Integer>[] island;
	static public char[] animal;

	
	//기본적으로 BFS와 DP를 조합해서 풀었습니다.
    //결국 가장 bottom부터 top까지 자식의 양의 수를 더해가면 되는, 전형적인 bottom-top 문제였습니다.
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
        //주어지는 입력에 따라 각 섬의 동물, 숫자, 그리고 연결된 섬들을 "부모노드" 기준으로 저장합니다.
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine().trim());
			animal[i+2] = st.nextToken().charAt(0);
			dpisland[i+2] = Integer.parseInt(st.nextToken());
			island[Integer.parseInt(st.nextToken())].add(i+2);	
		}
		
		depth[1][0] = 1;
		depth[1][1] = 1;
        
        //BFS 부분. 1번 섬부터 각 섬에 연결된 자식 섬들의 depth를 저장합니다.
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
		
        //각 섬의 번호와 depth를 depth 기준으로 정렬합니다.
		Arrays.sort(depth, (int[] o1, int[] o2) -> -Integer.compare(o1[1], o2[1]));
	
        //정렬 후 가장 깊은 depth의 노드부터 bottom-top으로 dp를 진행시킵니다.
		for(int i= 0; i<N;i++) {
			int node = depth[i][0];
			long lowsheep = 0;

			for(int l=0;l<island[node].size();l++) {
				lowsheep += dpisland[island[node].get(l)];
			}
            //현재 노드가 양이라면 자식 노드의 양을 모두 더해서 저장
			if(animal[node] =='S') {
				dpisland[node] += lowsheep;
			}
            //늑대라면 자식노드의 양 - 현재 늑대수(현재 늑대수가 많다면 0)를 저장
			else if(animal[node] == 'W') {
				if(lowsheep > dpisland[node]) dpisland[node] = lowsheep - dpisland[node];
				else dpisland[node] = 0;
			}
            //만약 1번 섬에 도달했다면, 단순히 자식노드들의 양의 수 합산
			if(node==1) dpisland[node] += lowsheep;
		}
		System.out.println(dpisland[1]);
	}

}