function solution(arr) {
    const N = arr.length
    for(let i =0; i<N; ++i){
        for(let j=i+1; j<N; ++j){
            if(arr[i][j] !== arr[j][i]){
                return 0;
            }
        }
    }
    return 1;
}