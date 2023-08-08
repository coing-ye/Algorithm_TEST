import sys
from collections import deque
N = int(sys.stdin.readline())

tower  = list(map(int,sys.stdin.readline().strip("\n").split(" ")))

stack = [[1e9+1,0]]
ans = deque()
checkans = deque()
max = 0
maxidx = 0


for i in range(N):
    while(stack):
        if stack[-1][0] < tower[i]:
            stack.pop()
        elif stack[-1][0] == tower[i]:
            stack[-1][1] = i
            break
        else:
            break

    ans.append(str(stack[-1][1]))
    checkans.append(stack[-1][1])

    stack.append([tower[i],i+1])


if sum(checkans) == 0:
    print(0)
else:
    print(" ".join(list(ans)))
