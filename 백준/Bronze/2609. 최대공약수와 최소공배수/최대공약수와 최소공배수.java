import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int bn = Math.max(N, M);
		int sn = Math.min(N, M);
		
		while(bn%sn != 0) {
			int md = bn%sn;
			bn = sn;
			sn = md;
		}
		
		System.out.println(sn);
		System.out.println(sn*(N/sn)*(M/sn));
		
	}

}
