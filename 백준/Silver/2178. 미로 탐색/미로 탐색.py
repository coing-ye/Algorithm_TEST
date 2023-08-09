import sys
from collections import deque

global di,dj
di = [-1,0,1,0] #상우하좌
dj = [0,1,0,-1]

def bfs(r,c):
    global di,dj,maze,visited,N,M
    visited[r][c] = 1
    deq = deque()
    deq.append([r,c])
    while(deq) :
        rc = deq.pop()
        r = rc[0]
        c = rc[1]
        # for l in range(N):
        #     print(visited[l])
        # print("**********************")
        # if r == N-1 and c == M-1:
        #     break
        for k in range(4):
            ni = r+di[k]
            nj = c+dj[k]
            if ni>=0 and ni< N and nj>=0 and nj < M and maze[ni][nj] == 1:
                if visited[ni][nj] == 0:
                    visited[ni][nj] = visited[r][c] +1
                    deq.append([ni,nj])
                else:
                    if visited[ni][nj] > visited[r][c] +1:
                        visited[ni][nj] = visited[r][c]+1
                        deq.append([ni,nj])

global N,M
N,M = map(int,sys.stdin.readline().strip().split(" "))
global maze
global visited
maze = []
visited = [[0]*M for _ in range(N)]
for i in range(N):

    t1 =list(sys.stdin.readline().strip())
    t2 = []
    for j in range(M):
        t2.append(int(t1[j]))
    maze.append(t2)


bfs(0,0)
# for i in range(N):
#     print(visited[i])
print(visited[N-1][M-1])