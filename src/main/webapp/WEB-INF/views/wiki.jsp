<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Wiki</title>
    <link rel="stylesheet" href="../../resources/main.css">
</head>
<body>
    <h1>${courseTitle}</h1>

    <div>
        ${wikiContent}
    </div>

    <button id="edit-btn">Edit Wiki</button>

    <textarea id="wiki-content-textarea"></textarea>

    <button id="submit-btn">Submit</button>

    <script>
        var editBtn = document.getElementById('edit-btn');
        editBtn.addEventListener('click', function() {
            document.getElementById('wiki-content-textarea').style.display = 'block';
        });

        var submitBtn = document.getElementById('submit-btn');
        submitBtn.addEventListener('click', function() {
            var html = document.getElementById('wiki-content-textarea').innerText;

            var xhr = new XMLHttpRequest();
            xhr.open("POST", '/wiki/' + ${wikiContent}, true);
            xhr.setRequestHeader('Content-Type', 'application/json');
            xhr.send(JSON.stringify({
                content: html
            }));
            // TODO: invoke update wiki
        })
    </script>
</body>
</html>