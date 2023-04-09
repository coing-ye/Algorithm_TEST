import sys
N = int(sys.stdin.readline())
pathmap = []

for i in range(N):
    tmp = list(map(int,sys.stdin.readline().split()))
    pathmap.append(tmp)

sol = 1000000*N

def recurload(road,m,proc,costsum):
    global sol
    if m == N-1:
        sol = min(sol,costsum)
    for i in range(len(road)):
        if pathmap[proc[-1]][road[i]] > 0 and costsum+pathmap[proc[-1]][road[i]] < sol:
            recurload(road[:i]+road[i+1:],m+1,proc+str(road[i]),costsum+pathmap[proc[-1]][road[i]])

numlist = []
for i in range(N):
    numlist.append(i)

for i in range(len(numlist)):
    recurload(numlist[:i]+numlist[i+1:],1,)
