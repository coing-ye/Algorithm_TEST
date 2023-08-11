import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N;
		StringBuilder sb = new StringBuilder();
		while((N = br.readLine()) != null) {
			int n = Integer.parseInt(N);
			int cnt = 1;
			double goal = 1;
			while((goal =goal%n) !=0.0) {
				cnt+=1;
                goal = goal*10+1;
				
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}

