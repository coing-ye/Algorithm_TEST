import sys
from collections import deque

global di,dj
#상우하좌
di = [-1,0,1,0]
dj = [0,1,0,-1]

def bfs(i,j):
    global deq,N
    if visit[i][j] ==1 or apart[i][j] == 0:
        return 0
    cnt = 0
    visit[i][j] = 1
    deq.append([i,j])
    while(deq):
        nn = deq.popleft()
        cnt+=1
        for i in range(4):
            ni = nn[0] +di[i]
            nj = nn[1] +dj[i]
            if ni>=0 and ni<N and nj>=0 and nj<N and visit[ni][nj] ==0 and apart[ni][nj] == 1:
                visit[ni][nj] = 1
                deq.append([ni,nj])
    return cnt

    
global N
N =  int(sys.stdin.readline())
global apart
global visit
apart = []
visit = [[0]*N for _ in range(N)]
for i in range(N):
    apart.append(list(map(int,sys.stdin.readline().strip("\n"))))

global deq
deq = deque()

ans = []

for i in range(N):
    for j in range(N):
        cn = bfs(i,j)
        if cn>0:
            ans.append(cn)

ans.sort()
print(len(ans))
for i in ans:
    print(i)