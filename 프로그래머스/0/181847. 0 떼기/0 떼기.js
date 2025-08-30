function solution(n_str) {
    let answer = '';
    
    let first = 0
    for(const ch of n_str){
        if(ch !== '0'){
            break
        }
        first++;
    }
    
    return n_str.slice(first);
}