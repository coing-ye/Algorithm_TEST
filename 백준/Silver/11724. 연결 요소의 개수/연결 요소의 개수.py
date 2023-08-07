import sys

sys.setrecursionlimit(5000)
N, M = map(int,sys.stdin.readline().split(" "))

global dmap
dmap = [[] for _ in range(N+1)]
global visited
visited = [0]*(N+1)
block = set()


global anset
anset = set()

global line 

def dfs(now):
    global dmap, visited, line
    visited[now] = 1
    for i in dmap[now]:
        if visited[i] == 0:
            if str(i) not in line:
                line.append(str(i))
                dfs(i)

    return

for _ in range(M):
    f,b = map(int,sys.stdin.readline().split(" "))
    if b not in dmap[f]:
        dmap[f].append(b)
        dmap[b].append(f)


for i in range(1,N+1):
    if sum(visited) == N:
        break

    if visited[i] == 1:
        continue
    line = [str(i)]
    dfs(i)
    hubo = "".join(sorted(line))
    if hubo not in anset:
        anset.add(hubo)

print(len(anset))