const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';

const input = fs.readFileSync(filePath).toString().trim();

const lines = input.split('\n');

let a,b;
lines.forEach((line: string) => {
  [a, b] = line.split(' ').map(Number);

  if(!a || !b) return;

  if(a% b === 0){
    console.log('multiple');
  }else if(b% a === 0){
    console.log('factor');
  }else{
    console.log('neither');
  }
});
