def answer(l,x):

    s=0
    c=[]
    count=0
    q=[]
    b=0
    sot=[]
    for i in range(len(l)):
        s=0
        for j in range(len(l)):
            s+=l[i-j]
            if(s==x):
                b+=count
                while(s!=0):
                    s-=l[i-j]
                    c.append(l[i-j])
                    count+=1
                    j-=1
                if(b==count):
                    continue
                else:
                    
                    q.append(c[b:count+1])
                
    for i in q:
        i.sort()
        sot.append(i[0])
    
    sot.sort()
    
    for i in q:
        if(i[0]==sot[0]):
            q=i
    
    if(len(sot)==0):
        return ([-1,-1])
    
    a='['
    for i in range(len(l)):
        for j in range(len(q)):
            if(l[i]==q[j]):
                a+=str(l.index(l[i]))
                a+=','+' '
    
    a=a[:-2]+']'
    return (a)

print(answer([int(i) for i in input('list').split(' ')],int(input('number'))))
