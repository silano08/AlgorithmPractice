def solution(s):
    q = []
    for i in s:
        if i == "(":
            q.append(i)
        else:
            if len(q) == 0:
                return False
            q.pop()
      
    return len(q) == 0