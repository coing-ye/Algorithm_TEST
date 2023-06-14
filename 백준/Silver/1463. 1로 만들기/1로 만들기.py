import sys

N = int(sys.stdin.readline())

now = 1
count = [0]*(N+1)

count[1] = 0


for i in range(2,N+1):
    tmp1 = 1e9
    tmp2 = 1e9
    tmp3 = 1e9
    if i%3 == 0:
        tmp1 = count[i//3]+1
    if i%2 ==0:
        tmp2 = count[i//2]+1
    tmp3 = count[i-1]+1
    count[i] = min(tmp1,tmp2,tmp3)
print(count[N])
