import java.io.*;
import java.util.*;
public class Main {
	static int N,d,k,c;
	static int[] container;
	static int[] duple;
	static int ans = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		container = new int[N];
		duple = new int[d+1];
		for(int i=0;i<N;i++) {
			container[i] = Integer.parseInt(br.readLine().trim());
		}
		int tmp = 0;
		for(int i=0;i<k;i++) {
			if(duple[container[i]] ==0 ) {
				tmp +=1;
			}
			duple[container[i]]+=1;
		}
		if(duple[c]==0) {
			tmp+=1;
			ans = Math.max(ans, tmp);
			tmp-=1;
			duple[c] = 0;
		}
		else {
			ans = Math.max(ans, tmp);
		}
		
		//System.out.println(tmp);
		//System.out.println("------");
		for(int i=1;i<N;i++) {
			if(duple[container[i-1]]==1) {
				tmp--;
			}
			duple[container[i-1]]--;
			int next = i+k-1;
			if(next>=N) {
				next -= N;
			}
			duple[container[next]]++;
			if(duple[container[next]]==1) {
				tmp+=1;
			}
			if(duple[c]==0) {
				tmp+=1;
				ans = Math.max(ans, tmp);
				tmp-=1;
				duple[c] = 0;
			}
			else {
				ans = Math.max(ans, tmp);
			}
			//System.out.println(tmp);
		}
		System.out.println(ans);
	}
}