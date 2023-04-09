import sys

targetnum = int(sys.stdin.readline())
bn = int(sys.stdin.readline())
if bn >0:
    brokennum = list(map(int,sys.stdin.readline().split()))
else:
    brokennum = []



if targetnum >=97 and targetnum <=103:
    print(abs(100-targetnum))
else:
    minnum = abs(targetnum-100)

    usable_channel = []
    for i in range(0,1000000+1):
        flag = 0
        if len(str(targetnum))-1 <= len(str(i)) and len(str(i)) <= len(str(targetnum))+1:
            for j in str(i):
                if int(j) in brokennum:
                    flag = 1
                    break
            if flag == 0:
                usable_channel.append(i)

    for i in usable_channel:
        minnum = min(minnum,abs(targetnum-i)+len(str(i)))
    print(minnum)
