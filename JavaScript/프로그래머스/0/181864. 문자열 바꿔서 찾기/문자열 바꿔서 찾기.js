function solution(myString, pat) {
    myString = [...myString].map((ch) => ch === 'A' ? 'B' : 'A').join('')
    
    console.log(myString)
    return myString.includes(pat) ? 1 : 0;
}