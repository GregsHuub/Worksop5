<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="invitationCSS.css" type="text/css">
    <style>
        body {
            background-color: rosybrown;

        }

        h1 ol {
            color: yellow;
        }
    </style>

</head>
<body>
<h1>Welcome to library by Greg</h1>
<ol>
    <li><a href="http://localhost:8080/books/listOfBooks">Show all</a></li>
    <br>
    <li><a href="http://localhost:8080/books/id/1">Select single position by ID</a></li>
    <br>
    <li><a href="http://localhost:8080/books/listOfBooks">Update position</a></li>
    <p>{id}  {isbn}  {title}  {author}  {publisher}  {type} - type like that</p>
    <br>
    <li><a href="http://localhost:8080/books/addBook">Add book</a></li>
    <p>{id}  {isbn}  {title}  {author}  {publisher}  {type} - type like that</p>
    <br>
    <li><a href="http://localhost:8080/books/delete/">Delete Books</a></li>
    <p>default value is 1</p>
</ol>


</body>
</html>
