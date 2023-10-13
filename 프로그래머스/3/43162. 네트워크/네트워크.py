from collections import deque

def find(x):
    if x == parent[x]:
        return x
    return find(parent[x])

def union(x,y):
    x = find(x)
    y = find(y)
    if x == y:
        return False
    if x < y:
        parent[y] = x
    else:
        parent[x] = y
    return True

def solution(n, computers):
    global parent
    parent = [0 for _ in range(n)]
    answer = 0
    
    for i in range(n):
        parent[i] = i
    
    print(computers)
    
    for i in range(n):
        now = i
        for j in range(n):
            if computers[i][j] == 1:
                union(i,j)
                
    for i in range(n):
        parent[i] = find(i)

    network = set()
    for i in parent:
        network.add(i)
    
    answer = len(network)
    
#     checknode  = set()
#     connect = []*n
#     for i in range(len(computers)):
#         tmp  = []
#         for j in range(len(computers[i])):
#             if j!=i and computers[i][j]==1:
#                 tmp.append(j)
#         connect.append(tmp)
    
#     for i in range(len(connect)):
#         if i not in checknode:
#             checknode.add(i)
#             if len(connect[i])<1:
#                 answer+=1
#             else:
#                 tset = deque()
#                 for j in connect[i]:
#                     tset.append(j)
#                 while tset:
#                     nn = tset.popleft()

#                     checknode.add(nn)
#                     for j in connect[nn]:
#                         if j not in checknode:
#                             tset.append(j)
#                 answer+=1

    return answer