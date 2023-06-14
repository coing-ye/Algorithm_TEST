import sys
import heapq

N = int(sys.stdin.readline())
cardlist = []

for i in range(N):
    cardlist.append(int(sys.stdin.readline()))

heapq.heapify(cardlist)

answer = 0
tmp = 0

while(len(cardlist) >=2 ):
    tmp += heapq.heappop(cardlist)
    tmp += heapq.heappop(cardlist)
    answer += tmp
    heapq.heappush(cardlist,tmp)
    tmp = 0

print(answer)

