import sys
rowcol = list(map(int,sys.stdin.readline().split()))
setting_board = []
for i in range(0,rowcol[0]):
    setting_board.append(list(map(int,sys.stdin.readline().split())))

tempboard = []
bignum = 0
#2*3 6칸차리 구하기
for i in range(0,rowcol[0]-1):
    for j in range(0,rowcol[1]-2):
        tempboard.append(setting_board[i][j:j+3])
        tempboard.append(setting_board[i+1][j:j+3])
        #print(tempboard)
        block1 = sum(tempboard[0])+tempboard[1][2]
        block2 = sum(tempboard[0])+tempboard[1][0]
        block3 = sum(tempboard[1])+tempboard[0][2]
        block4 = sum(tempboard[1])+tempboard[0][0]
        block5 = sum(tempboard[0][0:2])+sum(tempboard[1][1:])
        block6 = sum(tempboard[0][1:])+sum(tempboard[1][0:2])
        block7 = sum(tempboard[0])+tempboard[1][1]
        block8 = sum(tempboard[1])+tempboard[0][1]
        bignum = max(bignum,max(block1,block2,block3,block4,block5,block6,block7,block8))
        tempboard = []


#3*2 6칸차리 구하기
for i in range(0,rowcol[0]-2):
    for j in range(0,rowcol[1]-1):
        tempboard.append(setting_board[i][j:j+2])
        tempboard.append(setting_board[i+1][j:j+2])
        tempboard.append(setting_board[i+2][j:j+2])
        block1 = sum(tempboard[0])+tempboard[1][0]+tempboard[2][0]
        block2 = sum(tempboard[0])+tempboard[1][1]+tempboard[2][1]
        block3 = sum(tempboard[2])+tempboard[0][0]+tempboard[1][0]
        block4 = sum(tempboard[2])+tempboard[0][1]+tempboard[1][1]
        block5 = sum(tempboard[1])+tempboard[0][0]+tempboard[2][1]
        block6 = sum(tempboard[1])+tempboard[0][1]+tempboard[2][0]
        block7 = sum(tempboard[1])+tempboard[0][0]+tempboard[2][0]
        block8 = sum(tempboard[1])+tempboard[0][1]+tempboard[2][1]
        bignum = max(bignum,max(block1,block2,block3,block4,block5,block6,block7,block8))
        tempboard = []

#1*4 4칸차
for i in range(0,rowcol[0]-3):
    for j in range(0,rowcol[1]):
        tempboard.append(setting_board[i][j])
        tempboard.append(setting_board[i+1][j])
        tempboard.append(setting_board[i+2][j])
        tempboard.append(setting_board[i+3][j])
        bignum = max(bignum,sum(tempboard))
        tempboard = []
#4*1칸
for i in range(0,rowcol[0]):
    for j in range(0,rowcol[1]-3):
        tempboard.append(setting_board[i][j:j+4])
        bignum = max(bignum,sum(tempboard[0]))
        tempboard = []

#2*2칸
for i in range(0,rowcol[0]-1):
    for j in range(0,rowcol[1]-1):
        tempboard.append(setting_board[i][j:j+2])
        tempboard.append(setting_board[i+1][j:j+2])
        bignum = max(bignum,(sum(tempboard[0])+sum(tempboard[1])))
        tempboard = []

print(bignum)
