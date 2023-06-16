import sys
N = int(sys.stdin.readline())

maxnum = 100001
mod = 1000000009
count = [[0]*3 for _ in range(maxnum)]

count[1] = [1,0,0]
count[2] = [0,1,0]
count[3] = [1,1,1]


for i in range(4,maxnum):
    count[i][0] = (count[i-1][1]+count[i-1][2])%mod
    count[i][1] = (count[i-2][0]+count[i-2][2])%mod
    count[i][2] = (count[i-3][0]+count[i-3][1])%mod



for i in range(N):
    eachcase = int(sys.stdin.readline())
    print(sum(count[eachcase])%mod)

