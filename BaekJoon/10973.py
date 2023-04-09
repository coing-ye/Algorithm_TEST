import sys

N = int(sys.stdin.readline())
targetlist = list(map(int,sys.stdin.readline().split()))
numlist= []
templist = []

for i in range(1,N+1):
    numlist.append(i)


def prevlist(targelist):
    for i in range(len(targetlist)):
        templist.append(targetlist[-1-i])
        templist.sort(reverse = True)
        if i> 0:
            if targetlist[-1-i] > templist[-1]:
                for j in range(len(templist)):
                    if targetlist[-1-i] > templist[j]:
                        tmpval = templist.pop(j)
                        targetlist[-1-i] = tmpval
                        break
                sol = targetlist[:-i]+templist
                return(sol)
    return([-1])

sollist = prevlist(targetlist)
solsen = ''
for i in range(len(sollist)):
    solsen += str(sollist[i])
    if i < len(sollist)-1:
        solsen += ' '
print(solsen)
