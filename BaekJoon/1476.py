import sys
data = list(map(int,sys.stdin.readline().split()))

Year = 1
Ea = data[0]
Su = data[1]
Mo = data[2]

while 1:
    if (Year-Ea)%15 == 0 and (Year-Su)%28==0 and (Year-Mo)%19 ==0:
        print(Year)
        break
    else:
        Year+=1
