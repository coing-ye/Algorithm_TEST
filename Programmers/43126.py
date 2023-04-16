#https://school.programmers.co.kr/learn/courses/30/lessons/43162
# DFS/BFS > 네트워크
from collections import deque
def solution(n, computers):
    answer = 0
    checknode  = set()
    connect = []*n
    for i in range(len(computers)):
        tmp  = []
        for j in range(len(computers[i])):
            if j!=i and computers[i][j]==1:
                tmp.append(j)
        connect.append(tmp)

    for i in range(len(connect)):
        if i not in checknode:
            checknode.add(i)
            if len(connect[i])<1:
                answer+=1
            else:
                tset = deque()
                for j in connect[i]:
                    tset.append(j)
                while tset:
                    nn = tset.popleft()

                    checknode.add(nn)
                    for j in connect[nn]:
                        if j not in checknode:
                            tset.append(j)
                answer+=1

    return answer
