import sys

L,C = map(int,sys.stdin.readline().split())
keyset = sorted(sys.stdin.readline().split())

aeiou = ['a','e','i','o','u']
ans = []

def recur(ks,l,moem,zaem,sol):
    if l==L:
        if moem>=1 and zaem>=2:
            ans.append(sol)
        return
    for i in range(len(ks)):
        if ks[i] in aeiou:
            recur(ks[i+1:],l+1,moem+1,zaem,sol+ks[i])
        elif ks[i] not in aeiou:
            recur(ks[i+1:],l+1,moem,zaem+1,sol+ks[i])
    return


recur(keyset,0,0,0,'')
ans = sorted(ans)
for i in ans:
    print(i)
