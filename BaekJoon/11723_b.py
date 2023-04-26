import sys
import copy
N = int(sys.stdin.readline())

listbit  = 0

for i in range(N):
    tmp = sys.stdin.readline().split()
    command  = tmp[0]
    if command == "all":
        listbit = (1<<21) -1

    elif command == "empty":
        listbit = 0
    else:
        num = int(tmp[1])
        if command =="add":
            listbit  = listbit | (1<<(num-1))
        elif command =="check":
            print((listbit >> (num-1))&1)
        elif command =="remove":
            listbit = listbit & ~(1<<(num-1))
        elif command =="toggle":
            listbit = listbit ^ (1<<(num-1))
