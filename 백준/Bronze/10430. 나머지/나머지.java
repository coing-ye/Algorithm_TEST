import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println((A+B)%C);
		System.out.println( ((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println( ((A%C) * (B%C))%C);
	}

}
