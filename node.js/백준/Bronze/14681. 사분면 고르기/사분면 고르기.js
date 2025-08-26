const fs = require("fs");
const raw = fs.readFileSync(0, "utf8").trim();
const lines = raw.split(/\r?\n/);

const a = parseInt(lines[0]);
const b = parseInt(lines[1]);

if (a > 0 && b > 0) {
  console.log(1);
} else if (a < 0 && b > 0) {
  console.log(2);
} else if (a < 0 && b < 0) {
  console.log(3);
} else {
  console.log(4);
}
