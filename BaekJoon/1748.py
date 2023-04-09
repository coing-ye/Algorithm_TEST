import sys
N = int(sys.stdin.readline())

setnum = 9
sol = 0

while 1:
    if N <= setnum:
        sol = sol + N*len(str(setnum))
        break
    else:
        sol = sol + setnum*len(str(setnum))
        N = N - setnum
        setnum = setnum*10

print(sol)
