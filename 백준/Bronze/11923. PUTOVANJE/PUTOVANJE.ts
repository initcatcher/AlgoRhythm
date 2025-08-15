import * as fs from "fs";

const data = fs.readFileSync(0, "utf8").trim().split(/\s+/).map(Number);
const n = data[0], c = data[1];
const w = data.slice(2);

let maxCount = 0;

for (let i = 0; i < n; i++) {
  let sum = 0;
  let count = 0;
  for (let j = i; j < n; j++) {
    if (sum + w[j] <= c) {   // 가능하면 먹기
      sum += w[j];
      count++;
    }
    if(count + (n-j-1) < maxCount) break;
  }
  if (count > maxCount) maxCount = count;

}

console.log(String(maxCount));
