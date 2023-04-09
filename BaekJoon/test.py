import sys
N = sys.stdin.readline()

ans = 0


for i in range(1,int(N)+1):
    tmp = str(i)
    for j in tmp:
        if j =='0':
            ans+=1
print(ans)
