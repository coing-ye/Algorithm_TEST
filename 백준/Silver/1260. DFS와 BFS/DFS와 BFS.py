import sys
from collections import deque

sys.setrecursionlimit(10**9)

def dfs(now):
    global visited
    global line
    line = line + str(now) + " "
    visited[now] = 1
    for i in range(len(dmap[now])):
        next = dmap[now][i]
        if visited[next] == 0:
            visited[next] = 1
            dfs(next)

def bfs(now,line):
    deq = deque()
    visited[now] = 1
    deq.append(now)
    while(deq):
        p = deq.popleft()
        line = line + str(p) + " "
        visited[p] = 1
        for i in range(len(dmap[p])):
            if visited[dmap[p][i]]==0:
                visited[dmap[p][i]] = 1
                deq.append(dmap[p][i])

    print(line)
          

N, M, V = map(int,sys.stdin.readline().split(" "))
global dmap
global visited
global flag
global bmap
global line
line = ""
flag = 0
dmap = [[]for _ in range(N+1)]

visited = [0]*(N+1)
for _ in range(M):
    f ,b = map(int,sys.stdin.readline().split(" "))
    if b not in dmap[f] and f not in dmap[b]:
        dmap[f].append(b)
        dmap[b].append(f)

for i in range(N+1):
    dmap[i].sort()

#print(bmap)

dfs(V)
print(line)
visited = [0]*(N+1)
bfs(V,"")
