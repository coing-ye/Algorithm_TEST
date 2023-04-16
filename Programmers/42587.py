#https://school.programmers.co.kr/learn/courses/30/lessons/42587
#스택/큐 > 프린터
from collections import deque
import heapq

def solution(priorities, location):
    answer = 0
    hq = []
    dq = deque()
    for i in range(len(priorities)):
        heapq.heappush(hq, -priorities[i])
        dq.append((priorities[i],i))

    while dq:
        if dq[0][0] == -hq[0]:
            tmp = dq.popleft()
            heapq.heappop(hq)
            answer +=1
            if tmp[1] == location:
                return answer
        else:
            dq.rotate(-1)

    return answer
