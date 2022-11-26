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
    <title>Danh Sách Sinh Viên</title>
</head>
<body>
<div class="container">
    <h1>Danh sách sinh viên tốt nghiệp</h1>
    <a class="btn btn-primary" href="/">Home</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Số CCCD</th>
            <th scope="col">Tên</th>
            <th scope="col">Mã trường</th>
            <th scope="col">Mã ngành</th>
            <th scope="col">Hệ tốt nghiệp</th>
            <th scope="col">Ngày tốt nghiệp</th>
            <th scope="col">Loại tốt nghiệp</th>
            <th><a class="btn btn-primary" href="/totnghiep/create">Thêm sinh viên tốt nghiệp</a></th>
            <th >&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="totNghiep" items="${totnghieps}">
            <tr>
                <th scope="row">${totNghiep.soCCCD}</th>
                <c:forEach var="sinhVien" items="${sinhviens}">
                    <c:if test="${totNghiep.soCCCD == sinhVien.soCCCD}">
                        <td>${sinhVien.hoTen}</td>
                    </c:if>
                </c:forEach>
                <td>${totNghiep.maTruong}</td>
                <td>${totNghiep.maNganh}</td>
                <td>${totNghiep.heTN}</td>
                <td>${totNghiep.ngayTN}</td>
                <td>${totNghiep.loaiTN}</td>
                <td colspan="12" style="text-align: right">
                    <a class="btn btn-warning" href="/totnghiep/edit/${totNghiep.soCCCD},${totNghiep.maTruong},${totNghiep.maNganh}">Edit</a>
                    <a class="btn btn-danger" href="/totnghiep/delete/${totNghiep.soCCCD},${totNghiep.maTruong},${totNghiep.maNganh}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>