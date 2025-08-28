function solution(myString) {
    let res = ''
    for(const ch of myString){
        res += ch < 'l' ? 'l' : ch;
    }
    return res;
}