import sys
N = int(sys.stdin.readline())

count = [0]*(N+1)
count[1] = 1

if N>1:
    count[2] = 2

for i in range(3,N+1):
    count[i] = count[i-1]+count[i-2]
print(count[N]%10007)