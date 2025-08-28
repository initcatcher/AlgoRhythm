function solution(arr, delete_list) {
    var answer = [];
    return arr.filter(num => !delete_list.some(del => del === num));
}