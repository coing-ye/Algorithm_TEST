import sys
import heapq

T = int(sys.stdin.readline().strip());
ll = []
ans = []
flag = 1
for _ in range(T):
    
    innum = int(sys.stdin.readline().strip())
    if innum !=0:
        if flag == 0:
            flag = 1
        absnum = abs(innum)
        heapq.heappush(ll,(absnum,innum))
        #ll.append([innum,absnum])
    else:
        if ll:
            if flag == 1:
                #ll = sorted(ll, key = lambda x:x[1])
                flag = 0
            ans.append(str(heapq.heappop(ll)[1]))
        else:
            ans.append("0")

print("\n".join(ans))