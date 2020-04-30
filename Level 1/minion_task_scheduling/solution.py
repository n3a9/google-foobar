def answer(l,a):
    s=list(set(l))
    count=0
    proof=[]
    for i in range(len(s)):
        count=0
        for j in range(len(l)):
            if(s[i]==l[j]):
                count+=1
        proof.append(count)
    
    d=dict(zip(s,proof))        
    
    proof.clear()
    for i in range(len(l)):
        if(d[l[i]]<=a):
            proof.append(l[i])
    return proof

print(answer([int(i) for i in input('list').split(' ')],int(input('number'))))
