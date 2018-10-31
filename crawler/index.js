const rp = require('request-promise');
const cheerio = require('cheerio');
const urls = require('./unitsDescriptionUrls.json');
const fs = require('fs');

const promises = urls.slice(1100, urls.length).map(url=> {
  return new Promise((resolve, reject) => {
    rp({ url, transform: body => cheerio.load(body) })
      .then($ => {
        let content = $('.b-box').length === 0 ? "no specific description" : $($('.b-box')[0]).html();

        let data = {
          content,
          code: url.slice(url.length - 13, url.length - 5)
        };

        return resolve(data);
      })
      .catch(err => { 
        return resolve({ 
          content: "No official course description found", 
          code: err.options.url.slice(err.options.url.length - 13, err.options.url.length - 5) 
        });
      });
  })
});

Promise.all(promises).then(res => {
  const file = fs.createWriteStream('./wikiDescription12.json');
  file.write(JSON.stringify(res));
  file.end();
}).catch(err => {
  console.log(Object.keys(err));
  console.log(err.options);
  // console.log(err.message);
});