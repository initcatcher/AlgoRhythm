function solution(arr, queries) {
    const res = []
    for (const [s,e,k] of queries) {
        let tmp = -1
        for (let i = s; i<=e; i++){
            if(arr[i] > k){
                if(tmp === -1 || tmp > arr[i]){
                    tmp = arr[i]
                }
            }
        }
        res.push(tmp)
    }
    return res
}