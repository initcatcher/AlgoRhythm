const fs = require("fs");
const raw = fs.readFileSync(0, "utf8").trim();
const lines = raw.split(/\r?\n/);

const N = parseInt(lines[0]);

for (let i = 1; i <= N; i++) {
  let answer = [];
  const num = parseInt(lines[i]);

  let x = 1,
    y = num - x;
  while (x < y) {
    answer.push(`${x} ${y}`);
    x++;
    y--;
  }
  answer = answer.join(", ");
  console.log(`Pairs for ${num}: ${answer}`);
}
