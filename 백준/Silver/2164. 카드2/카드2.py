import sys
from collections import deque

N = int(sys.stdin.readline())

cardset = deque()

for i in range(1,N+1):
    cardset.append(i)

while(len(cardset)>1):
    cardset.popleft()
    changecard = cardset.popleft()
    cardset.append(changecard)
print(cardset[0])