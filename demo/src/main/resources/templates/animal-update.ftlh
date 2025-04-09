<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
  <title>Update Animal</title>
</head>
<body>
<h1>Update Animal</h1>

<form action="/animals/update" method="post">
    <input type="hidden" name="id" value="${animal.id}"/>

    <label>Name:</label>
    <input type="text" name="name" value="${animal.name}" /><br/>

    <label>Species:</label>
    <input type="text" name="species" value="${animal.species}" /><br/>

    <label>Age:</label>
    <input type="number" name="age" value="${animal.age}" /><br/>

    <button type="submit">Update</button>
</form>

</body>
</html>
