import java.io.*;
import java.util.*;

public class Main {
	static int L,C;
	static String[] arr;
	static String[] b;
	static boolean[] visited;
	
	static String[] moem = new String[] {"a","e","i","o","u"};
	
	public static void subs(int cnt, int start) {
		if(cnt == L) {
			String tmp = "";
			int checkmoem = 0;
			int checkzaem = 0;
			for(int i = 0;i<L;i++) {
				if(Arrays.binarySearch(moem, b[i])>=0) {
					checkmoem++;
				}
				else {
					checkzaem++;
				}
				tmp+=b[i];
			}
			if(checkmoem>=1 && checkzaem>=2) {
				System.out.println(tmp);
			}
//			System.out.println(tmp + " " + checkmoem+ " "+checkzaem);
			return;
		}
		for(int i =start; i<C;i++) {
			if(visited[i] == true) continue;
			b[cnt] = arr[i];
			subs(cnt+1,i+1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		b = new String[L];
		visited = new boolean[C];
		
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.charAt(0)-'0', o2.charAt(0)-'0');
			}
		});
	
		//System.out.println(Arrays.toString(arr));
		subs(0,0);
	}

}
