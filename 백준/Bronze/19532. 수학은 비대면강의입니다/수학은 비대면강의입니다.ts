const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim();
const [a, b, c, d, e, f] = input.split(' ').map(Number);

// 크래머의 법칙: ax + by = c, dx + ey = f
const det = a * e - b * d;
const x = (c * e - b * f) / det;
const y = (a * f - c * d) / det;

console.log(Math.floor(x + 0.5), Math.floor(y + 0.5));