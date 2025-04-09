<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Animal List</title>
</head>
<body>
<h1>Animal List</h1>

<a href="/animals/new">Create New Animal</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Species</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <#list animalList as animal>
        <tr>
            <td><a href="/animals/${animal.id}">${animal.id}</a></td>
            <td>${animal.name}</td>
            <td>${animal.species}</td>
            <td>${animal.age}</td>
            <td>
                <a href="/animals/update/${animal.id}">Update</a> |
                <a href="/animals/delete/${animal.id}">Delete</a>
            </td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
