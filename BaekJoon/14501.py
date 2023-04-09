import sys

Day = int(sys.stdin.readline())
table = []

for i in range(Day):
    table.append(list(map(int,sys.stdin.readline().split())))

#print(table)
answer = 0

def recur(tab,day,sum,tmp):
    global Day
    if day >= Day+1:
        #print(day,sum)
        global answer
        if day > Day+1:
            sum = sum - tmp
        #print(sum)
        if answer < sum:
            answer = sum

        return

    for i in range(len(tab)):
        plusday = tab[i][0]
        recur(tab[i+plusday:],day+plusday+i,sum+tab[i][1],tab[i][1])

recur(table,1,0,0)
print(answer)
