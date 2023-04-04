babbling = ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]

def solution(babbling):
    answer = 0
    pronounce  = ["aya","ye","woo","ma"]
    for i in babbling:
        k=0
        latest = ""
        while_flag = 0

        while(1):
            if k == len(i):
                answer+=1
                break

            if i[k]=="a":
                if latest=="a" or k+3 > len(i):
                    while_flag =1
                    break
                else:
                    if i[k:k+3] == "aya":
                        k = k+3
                        latest = "a"
                    else:
                        while_flag=1
                        break
            elif i[k]=="y":
                if latest=="y" or k+2 > len(i):
                    while_flag =1
                    break
                else:
                    if i[k:k+2] == "ye":
                        k = k+2
                        latest="y"
                    else:
                        while_flag=1
                        break
            elif i[k]=="w":
                if latest=="w" or k+3 > len(i):
                    while_flag =1
                    break
                else:
                    if i[k:k+3] == "woo":
                        k = k+3
                        latest="w"
                    else:
                        while_flag=1
                        break
            elif i[k]=="m":
                if latest=="m" or k+2 > len(i):
                    while_flag =1
                    break
                else:
                    if i[k:k+2] == "ma":
                        k = k+2
                        latest="m"
                    else:
                        while_flag=1
                        break
            else:
                while_flag = 1
                break

            if while_flag ==1:
                break

    return answer

print(solution(babbling))
