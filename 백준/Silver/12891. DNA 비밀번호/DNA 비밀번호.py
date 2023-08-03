import sys
S, P = map(int,sys.stdin.readline().split(" "))
dna = sys.stdin.readline()
A,C,G,T = map(int,sys.stdin.readline().split(" "))

acgt = {}
acgt['A'] = 0
acgt['C'] = 0
acgt['G'] = 0
acgt['T'] = 0

anw = 0
for i in range(0,S-P+1):
    if (i == 0 ):
        for j in range(0,P):
            acgt[dna[j]]+=1
        last = dna[0]
    else:
        acgt[last] -=1
        last = dna[i]
        acgt[dna[i+P-1]] +=1
    if (acgt['A']>=A and acgt['C']>=C and acgt['G']>=G and acgt['T']>=T):
        anw+=1
print(anw)