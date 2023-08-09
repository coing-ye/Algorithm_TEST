import sys
from collections import deque
import math

global tmap,visited,N,M,di,dj,already

di = [-1,0,1,0]
dj = [0,1,0,-1]

def bfs():

    deq = deque()

    while(already):
        rc = already.pop()
        r = rc[0]
        c = rc[1]
        deq.append([r,c])

    while(deq):
        # for l in range(N):
        #     print(visited[l])
        # print("####################")
        rc = deq.pop()
        i = rc[0]
        j = rc[1]
        for k in range(4):
            ni = i+di[k]
            nj = j+dj[k]
            if ni>=0 and ni<N and nj>=0 and nj<M and tmap[ni][nj] != -1:
                if visited[ni][nj] == 0:
                    visited[ni][nj] = visited[i][j]+1
                    deq.appendleft([ni,nj])
                else:
                    if visited[ni][nj] > visited[i][j] +1:
                        visited[ni][nj] = visited[i][j]+1
                        deq.appendleft([ni,nj])
    
M,N = map(int,sys.stdin.readline().split(" "))
tmap = []
visited = [[0]*M for _ in range(N)]

for i in range(N):
    tmap.append(list(map(int,sys.stdin.readline().strip().split(" "))))




tsum = 0
already = deque()

for i in range(N):
    for j in range(M):
        tsum += tmap[i][j]
        if tmap[i][j] == 1:
            visited[i][j] = 1
            already.append([i,j])
        elif tmap[i][j] == -1:
            visited[i][j] = -1


if sum == N+M:
    print(0)
elif sum == 0:
    print(-1)
else:
    bfs()

    ans = 0

    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0:
                ans = -1
                break
            ans = max(ans,visited[i][j]-1)
        if ans == -1:
            break
    print(ans)