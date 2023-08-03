import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int nc = 0;
		int mc = 0;
		

		int gcd = 0;
		int BN = Math.min(N, M);
		for(int i=1;i<=BN;i++) {
			if(M%i==0 && N%i==0) {
				gcd = i;
			}
		}
		System.out.println(gcd);
		System.out.println(gcd*(N/gcd)*(M/gcd));
		
	}

}
