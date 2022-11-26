<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Chỉnh Sửa Sinh Viên</title>
</head>
<body>
<%--    ${sinhviens}--%>
<div class="container">
    <h1>Thêm Sinh Viên</h1>
    <form action="" method="post" onsubmit="return validateForm()" name="Form" required>
        <div class="">
            <div class="form-floating">
                <label for="soCCCD">Số CCCD</label>
                <input type="text" class="form-control" id="soCCCD" name="soCCCD" value="${sinhvien.soCCCD}"/>
            </div>
            <div class="form-floating">
                <label for="hoTen">Tên</label>
                <input type="text" class="form-control" id="hoTen" name="hoTen" value="${sinhvien.hoTen}"/>
            </div>
            <div class="form-floating">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="${sinhvien.email}"/>
            </div>
            <div class="form-floating">
                <label for="soDT">Số ĐT</label>
                <input type="text" class="form-control" id="soDT" name="soDT" value="${sinhvien.soDT}"/>
            </div>
            <div class="form-floating">
                <label for="diaChi">Địa chỉ</label>
                <input type="text" class="form-control" id="diaChi" name="diaChi" value="${sinhvien.diaChi}"/>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary mt-2" type="submit">Sửa</button>
        </div>
    </form>
</div>
</body>
</html>