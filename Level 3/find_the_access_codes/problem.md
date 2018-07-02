## Find the Access Codes

Time to solve: 96 hours.

### Description

In order to destroy Commander Lambda's LAMBCHOP doomsday device, you'll need access to it. But the only door leading to the LAMBCHOP chamber is secured with a unique lock system whose number of passcodes changes daily. Commander Lambda gets a report every day that includes the locks' access codes, but only she knows how to figure out which of several lists contains the access codes. You need to find a way to determine which list contains the access codes once you're ready to go in.

Fortunately, now that you're Commander Lambda's personal assistant, she's confided to you that she made all the access codes "lucky triples" in order to help her better find them in the lists. A "lucky triple" is a tuple (x, y, z) where x divides y and y divides z, such as (1, 2, 4). With that information, you can figure out which list contains the number of access codes that matches the number of locks on the door when you're ready to go in (for example, if there's 5 passcodes, you'd need to find a list with 5 "lucky triple" access codes).

Write a function answer(l) that takes a list of positive integers l and counts the number of "lucky triples" of (lst[i], lst[j], lst[k]) where i < j < k.  The length of l is between 2 and 2000 inclusive.  The elements of l are between 1 and 999999 inclusive.  The answer fits within a signed 32-bit integer. Some of the lists are purposely generated without any access codes to throw off spies, so if no triples are found, return 0.

For example, [1, 2, 3, 4, 5, 6] has the triples: [1, 2, 4], [1, 2, 6], [1, 3, 6], making the answer 3 total.

### Languages

To provide a Python solution, edit solution.py

To provide a Java solution, edit solution.java

### Test Cases

#### Test Case 1

Inputs:
```
(int list) l = [1, 1, 1]
```
Output:
```
(int) 1
```

#### Test Case 2

Inputs:
```
(int list) l = [1, 2, 3, 4, 5, 6]
```
Output:
```
(int) 3
```

### Constraints

#### Java

Your code will be compiled using standard Java 7. It must implement the answer() method in the solution stub.

Execution time is limited. Some classes are restricted (e.g. java.lang.ClassLoader). You will see a notice if you use a restricted class when you verify your solution.

Third-party libraries, input/output operations, spawning threads or processes and changes to the execution environment are not allowed.

#### Python

Your code will run inside a Python 2.7.6 sandbox.

Standard libraries are supported except for bz2, crypt, fcntl, mmap, pwd, pyexpat, select, signal, termios, thread, time, unicodedata, zipimport, zlib.
