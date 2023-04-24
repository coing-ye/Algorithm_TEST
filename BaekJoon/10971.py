import sys
from itertools import permutations

global N
global pathmap
N = int(sys.stdin.readline())
pathmap = []
node = []
answer = int(1e9)

def dfs(stat,path,rest,score):
    if stat == N:
        if pathmap[path[-1]][path[0]] == 0:
            return
        else:
            global answer
            tmp = score+pathmap[path[-1]][path[0]]
            answer = min(answer,tmp)

            return
    for i in range(len(rest)):
        ss = pathmap[path[-1]][rest[i]]
        if ss > 0:
            dfs(stat+1,path+[rest[i]],rest[:i]+rest[i+1:],score+ss)


for i in range(N):
    tmp = list(map(int,sys.stdin.readline().split()))
    pathmap.append(tmp)
    node.append(i)

for i in range(N):
    dfs(1,[node[i]],node[:i]+node[i+1:],0)

print(answer)
