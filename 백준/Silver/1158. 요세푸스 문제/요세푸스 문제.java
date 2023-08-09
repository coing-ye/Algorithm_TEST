import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		ArrayDeque<Integer> ans = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			deq.offer(i);
		}
		

		sb.append("<");
		while(deq.size()>1) {
			for(int i=0;i<K-1;i++) {
				int tmp = deq.pollFirst();
				deq.offer(tmp);
			}
			int tmp = deq.pollFirst();
			sb.append(tmp).append(", ");
		}
		int tmp = deq.pollFirst();
		sb.append(tmp).append(">");
		System.out.println(sb);
	}

}