import sys

sys.setrecursionlimit(10**9)
K  = int(sys.stdin.readline())

global dmap
global colormap
global flag

answer = []

def dfs(now,color):
    global dmap, colormap, flag
    colormap[now] = color
    for i in dmap[now]:
        if colormap[i] != -1:
            if colormap[i] != color^1:
                flag = 1
                return
        elif colormap[i] == -1:
            dfs(i, color^1)
        if flag == 1:
            break
    if flag == 1:
        return


for t in range(K):
    V, E = map(int,sys.stdin.readline().split(" "))
    dmap = [[] for _ in range(V+1)]
    colormap = [-1]*(V+1)
    flag = 0
    for i in range(E):
        f, b = map(int,sys.stdin.readline().split(" "))
        dmap[f].append(b)
        dmap[b].append(f)
    
    for i in range(1,V+1):
        if colormap[i] == -1:
            dfs(i,0)
        # else:
        #     dfs(i,colormap[i])
        if flag == 1:
            answer.append("NO")
            break
        if -1 not in colormap[1:]:
            break
    if flag == 0:
        answer.append("YES")
    
for i in answer:
    print(i)