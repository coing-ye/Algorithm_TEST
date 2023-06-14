import sys
N = int(sys.stdin.readline())
count = [0]*(N+1)
cost = list(map(int,sys.stdin.readline().split()))
cost = [0]+cost


for i in range(1,N+1):
    money = 1e9
    for j in range(i):
        if j ==0:
            tmp = cost[i]
        else:
            tmp = count[i-j]+count[j]
        money = min(money,tmp)
    count[i] = money

print(count[N])
