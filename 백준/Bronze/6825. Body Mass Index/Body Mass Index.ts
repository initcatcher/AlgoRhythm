const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const weight = parseFloat(input[0]);
const height = parseFloat(input[1]);

const bmi = weight / (height * height);

if (bmi < 18.5) {
    console.log("Underweight");
} else if (bmi <= 25.0) {
    console.log("Normal weight");
} else {
    console.log("Overweight");
}