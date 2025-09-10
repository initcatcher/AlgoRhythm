function solution(a, d, included) {
    return Array.from({length:included.length}, (_,i) => {
        return included[i] ? a + d*i : 0
    }).reduce((acc, v) => acc + v)
}