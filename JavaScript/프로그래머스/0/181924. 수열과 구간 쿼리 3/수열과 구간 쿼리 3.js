function solution(arr, queries) {
    for (const q of queries){
        let temp = arr[q[0]]
        arr[q[0]] = arr[q[1]]
        arr[q[1]] = temp
    }
    return arr
}