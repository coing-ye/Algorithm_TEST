import sys

MAX = 1000000
savechartTemp = [1]*(MAX+1)
for i in range(2,MAX+1):
    for j in range(1,(MAX//i)+1):
        savechartTemp[j*i] = savechartTemp[j*i] + i

while 1:
    x = int(sys.stdin.readline())
    print(x)
    if x==0:
        break

    for i in range(3,(x//2)+1):
        if savechartTemp[i] == i+1:
            if savechartTemp[x-i] == (x-i)+1:
                print(x,"=",i,"+",x-i)
                break

        if i == (x//2):
            print("Goldbach's conjecture is wrong.")
