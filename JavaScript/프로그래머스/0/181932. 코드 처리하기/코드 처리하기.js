function solution(code) {
    let mode = false
    
    return [...code].map((v,i)=>{
        if(v === '1'){
            mode = !mode
        }
        else if(mode){
            if(i%2 === 1){
                return v
            }
        }else {
            if(i%2 === 0){
                return v
            }
        }
        return ''
    }).join('') || 'EMPTY'
    
}