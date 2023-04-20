while True:
    try:
        x = int(input())
    except:
        break

    digi = len(str(x))
    onenum = 1

    if x == 1:
        print(x)
    else:
        n = 1
        while 1:
            onenum = (pow(10,n+1)-1)//9
            n = n+1
            if int(onenum%x) == 0:
                print(n)
                break
