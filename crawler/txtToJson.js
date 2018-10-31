const fs = require('fs');
const courses = JSON.parse(fs.readFileSync('./CourseCode.txt'));

const results = [];

courses.forEach(course => {
  const code = course.slice(0, 8);
  const name = course.slice(9, course.length);

  results.push({ code, name });
});

fs.writeFileSync('./courseNameCode.json', JSON.stringify(results));