function solution(num_list) {
    const last = num_list.at(-1)
    const before = num_list.at(-2)
    
    const val = before < last ? last-before : last*2;
    num_list.push(val)    
    return num_list;
}