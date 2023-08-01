import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		StringTokenizer ss = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(ss.nextToken());
		}
		ArrayList<Integer> al = new ArrayList<>(arr.length);
		for(int i:arr) {
			al.add(i);
		}
		Collections.sort(al);
		StringBuilder sb = new StringBuilder();
		int anw = 0;
		if(arr.length%2 ==0) {
			anw = al.get(0)*al.get(arr.length-1);
		}else {
			anw = al.get(arr.length/2)*al.get(arr.length/2);
		}
		System.out.println(anw);
	}	

}
