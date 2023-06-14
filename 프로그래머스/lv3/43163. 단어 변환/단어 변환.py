def countdiff(ori,nxt):
    diff = 0
    for i in range(len(ori)):
        if ori[i] != nxt[i]:
            diff+=1
    return diff
def dfs(now,restset,cnt):
    if now == tg:
        global ac
        ac = min(ac,cnt)
        return
    for i in range(len(restset)):
        ct= countdiff(now,restset[i])
        if ct == 1:
            dfs(restset[i],restset[:i]+restset[i+1:],cnt+1)
    return
    

def solution(begin, target, words):
    answer = 0
    maxcount = len(words)
    
    global tg
    global ac
    
    tg = target
    ac = 1e9
    
    if target not in words:
        return 0
    
    for i in range(maxcount):
        ct= countdiff(begin,words[i])
        if ct == 1:
            dfs(words[i],words[:i]+words[i+1:],1)
    
    answer = ac
    return answer