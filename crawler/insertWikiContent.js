const fs = require('fs');

const indices = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
const wikis = JSON.parse(fs.readFileSync('./courseNameCode.json').toString());
const WIKI_NUM = wikis.length;

indices.forEach((num) => {
  const filename = `wikiDescription${num}.json`;
  const descs = JSON.parse(fs.readFileSync(filename).toString());

  for (let index = (num - 1) * 100, i = 0; i < descs.length; index++, i++) {
    if (index < WIKI_NUM) {
      wikis[index].wiki = descs[i].content;
    }
  }
});

fs.writeFileSync('./course.json', JSON.stringify(wikis));
