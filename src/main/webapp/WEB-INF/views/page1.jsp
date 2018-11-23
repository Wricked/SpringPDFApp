<!DOCTYPE HTML>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>${name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>

<p>Hello, ${name}</p>

Form
<form:form method="post" modelAttribute="sampleDetails" enctype="multipart/form-data">
    <input type="file" name="uploadedFileName" id="fileToUpload" required="" >
    <input type="submit" name="import_file" value="Import File" id="" />
</form:form>
</body>
</html>