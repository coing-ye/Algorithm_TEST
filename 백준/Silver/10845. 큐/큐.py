import sys
from collections import deque

T = int(sys.stdin.readline())
str_list = []
deq = deque()
for i in range(T):
    iline = sys.stdin.readline().split(" ")


    if len(iline)>1:
        command = iline[0]
        num = int(iline[1])
    else:
        command = iline[0][:-1]

    if command == "push":
        deq.append(num)

    elif command == "pop":
        if len(deq)>0:
            #print(deq.popleft())
            str_list.append(deq.popleft())
        else:
            #print(-1)
            str_list.append(-1)

    elif command == "size":
        #print(len(deq))
        str_list.append(len(deq))
    elif command == "empty":
        if(len(deq)==0):
            #print(1)
            str_list.append(1)
        else:
            #print(0)
            str_list.append(0)
    elif command == "front":
        if len(deq)>0:
            #print(deq[0])
            str_list.append(deq[0])
        else:
            #print(-1)
            str_list.append(-1)
    elif command == "back":
        if len(deq) > 0:
            #print(deq[-1])
            str_list.append(deq[-1])
        else:
            #print(-1)
            str_list.append(-1)
for i in str_list:
    print(i)
