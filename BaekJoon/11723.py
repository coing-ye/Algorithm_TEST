import sys
import copy
N = int(sys.stdin.readline())

dictlist = {}
alllist = {}
zerolist = {}
for i in range(1,21):
    alllist[str(i)] = 1
    dictlist[str(i)] = 0
    zerolist[str(i)] = 0

for i in range(N):
    tmp = sys.stdin.readline().split()
    command  = tmp[0]
    if command == "all":
        dictlist = alllist

    elif command == "empty":
        dictlist = zerolist
    else:
        num = tmp[1]
        if command =="add":
            if dictlist[num] == 0:
                dictlist[num]=1
        elif command =="check":
            if dictlist[num] == 1:
                print("1")
            else:
                print("0")
        elif command =="remove":
            if dictlist[num] == 1:
                dictlist[num] = 0
        elif command =="toggle":
            if dictlist[num]==1:
                dictlist[num] = 0
            elif dictlist[num] == 0:
                dictlist[num] = 1
