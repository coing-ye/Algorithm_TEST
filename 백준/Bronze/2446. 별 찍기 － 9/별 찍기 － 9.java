import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		for(int i = N;i>0;i--) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N-i;j++) {
				sb.append(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
		for(int i = 2;i<=N;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<N-i;j++) {
				sb.append(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
		
	}

}
