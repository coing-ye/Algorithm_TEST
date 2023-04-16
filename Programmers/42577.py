#https://school.programmers.co.kr/learn/courses/30/lessons/42577
#해시 > 전화번호 목록 문제
def solution(phone_book):
    answer = True
    book_num = {}
    book_len = {}

    for i in phone_book:
        book_num[i] = 1

    for i in phone_book:
        tmp = ''
        for j in i:
            tmp += j
            if tmp in book_num and tmp!= i:
                return False
    return answer
