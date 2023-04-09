def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        tmp1 = format(int(arr1[i]),'b').zfill(n)
        tmp2 = format(int(arr2[i]),'b').zfill(n)
        tmp3= ""
        print(tmp1)
        print(tmp2)
        for j in range(n):
            if tmp1[j] =='1' or tmp2[j] =='1':
                tmp3 += "#"
            else:
                tmp3 += " "
        answer.append(tmp3)

    return answer
