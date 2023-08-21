import java.util.*;
import java.io.*;
public class Main {

	public static int N;
	public static ArrayDeque<int[]> que = new ArrayDeque<>();
	public static int ans;
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//입출력 처리 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(br.readLine().trim()," ");
			int ifwork = Integer.parseInt(st.nextToken());
			//업무가 주어진다면
			if(ifwork ==1) {
				//주어지는 점수와 걸리는 시간을 nowwork 배열에 저장
				int[] nowwork = new int[2];
				nowwork[0] = Integer.parseInt(st.nextToken());
				nowwork[1] = Integer.parseInt(st.nextToken());
				
				//해당 초도 업무를 한것으로 계산하기 때문에 남은시간 1분 감소
				nowwork[1] = nowwork[1]-1;
				//바로 완료 했다면 점수 합산 & 큐에 삽입하지 않음
				if(nowwork[1] ==0) {
					ans += nowwork[0];
				}
				else {
					//업무 큐에 가장 우선순위로 삽입
					que.offerFirst(Arrays.copyOf(nowwork, 2));
				}
			}
			else if(ifwork ==0){
				//만약 업무가 존재한다면
				if(!que.isEmpty()) {
					//가장 우선순위의 업무를 선택
					int[] nowwork = que.pollFirst();
					nowwork[1] = nowwork[1] -1;
					//만약 이번 분으로 일이 끝났다면 점수를 합산
					if(nowwork[1] == 0) {
						ans += nowwork[0];
					}
					//아니라면 다시 가장 앞 순서로 삽입
					else {
						que.offerFirst(Arrays.copyOf(nowwork, 2));
					}
				}
			}
		}
		System.out.println(ans);
		
		
		br.close();
		
	}

}
