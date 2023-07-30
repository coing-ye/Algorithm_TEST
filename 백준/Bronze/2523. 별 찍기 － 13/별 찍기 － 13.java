import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			StringBuilder sb = new StringBuilder();

			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			System.out.println(sb);
		}
		for(int i=N-1;i>0;i--) {
			StringBuilder sb = new StringBuilder();

			for(int j=0;j<i;j++) {
				sb.append("*");
			}
			System.out.println(sb);
		}
	}

}