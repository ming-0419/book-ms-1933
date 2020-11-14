<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<form action="UpdateBookServlet" method="post">
<input type="hidden" class="form-control" name="id" value="${book.id }">
                <div class="form-group">
                    <label>书名</label>
                    <input type="text" class="form-control" name="name" value="${book.name }">
                </div>
    
                <div class="form-group">
                    <label>作者</label>
                    <input type="text" class="form-control" name="author" value="${book.author }">
                </div>
    
                <div class="form-group">
                    <label>价格</label>
                    <input type="text" class="form-control" name="price" value="${book.price }">
                </div>
                <input type = "submit"  class="btn btn-primary" value="修改">
            </form>

</body>
</html>