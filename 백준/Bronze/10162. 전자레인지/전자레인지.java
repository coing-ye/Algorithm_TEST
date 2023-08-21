import java.util.*;
import java.io.*;
public class Main {

	public static int[] timeset;
	public static int T;
	public static int A = 300, B = 60, C = 10;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//BufferedReader로 입력값 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		//만약 T%C 가 0이 아니라면? 애시당초 맞출 수 없는 시간. 즉 -1 출력.
		if(T%C !=0) {
			System.out.println("-1");
			br.close();
			return;
		}
		
		//나눠지는 시간이라면 아래 과정 진행
		StringBuilder sb = new StringBuilder();
		
		//버튼당 클릭수 저장
		int[] answer = new int[3];
		
		
		//최소한의 버튼수를 입력해야하므로 가장 단위가 큰 A버튼부터 최대로 클릭
		//T를 A로 나눈 몫을 구하면 A를 최대 몇번 클릭해야하는지 확인 가능
		answer[0] = (int)T/A;
		//A버튼을 최대한 클릭했으니 이제 T%A를 통해 나머지 값을 B로 나눈다.
		//즉 다음엔 B를 최대 몇번 클릭 가능한지 확인
		T = T%A;
		answer[1] = (int)T/B;
		//위와 동일한 과정을 C버튼도 반복
		T = T%B;
		answer[2] = (int)T/C;

		//미리 저장해두었던 버튼당 클릭 수 출력
		sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
		System.out.println(sb);
		
		br.close();
	}

}
