import sys
input = sys.stdin.readline

while True:
    word = input().strip()
    if word == '#':
        break

    postfix=''
    prefix=''
    find=False
    for ch in word:
        if find:
            prefix+=ch
            continue

        if ch in ['a','e','i','o','u']:
            postfix+='ay'
            prefix+=ch
            find=True
        else:
            postfix+=ch
    if not find:
        print(word + 'ay')
    else:
        print(prefix + postfix)