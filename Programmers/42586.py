#https://school.programmers.co.kr/learn/courses/30/lessons/42586
#스택/큐 > 기능개발

from collections import deque
def solution(progresses, speeds):
    answer = []
    pque = deque()
    sque = deque()
    for i in range(len(progresses)):
        pque.append(progresses[i])
        sque.append(speeds[i])
    while pque:
        for i in range(len(pque)):
            pque[i] += sque[i]

        if pque[0] >= 100:
            tmp = 0
            while pque and pque[0]>=100:
                tmp +=1
                pque.popleft()
                sque.popleft()
            answer.append(tmp)
    return answer
