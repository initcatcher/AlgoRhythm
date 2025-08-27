function solution(my_string) {
    const answer = []
    const N = my_string.length
    for(let i=0; i<N; i++){
        answer.push(my_string)

        my_string=my_string.slice(1)
    }
    answer.sort()
    return answer
}