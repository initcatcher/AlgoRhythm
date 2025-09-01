function solution(my_string, overwrite_string, s) {
    const answer = [...my_string]
    
    for(let i=0; i<overwrite_string.length&& s+i<my_string.length; i++){
        answer[i+s]=overwrite_string[i]
    }
    return answer.join('');
}