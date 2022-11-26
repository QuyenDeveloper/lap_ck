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
    <h1>Danh sách Công Việc</h1>
    <a class="btn btn-primary" href="/">Home</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Số CCCD</th>
            <th scope="col">Ngày vào công ty</th>
            <th scope="col">Mã ngành công ty</th>
            <th scope="col">Tên công việc</th>
            <th scope="col">Tên công ty</th>
            <th scope="col">Địa chỉ công ty</th>
            <th scope="col">Thời gian làm việc</th>
            <th><a class="btn btn-primary" href="/congviec/create">Thêm công việc</a></th>
            <th>&nbsp;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="congViec" items="${congviecs}">
            <tr>
                <td scope="row">${congViec.soCCCD}</td>
                <td>${congViec.ngayVaoCongTy}</td>
                <td>${congViec.maNganh}</td>
                <td>${congViec.tenCongViec}</td>
                <td>${congViec.tenCongTy}</td>
                <td>${congViec.diaChiCongTy}</td>
                <td>${congViec.thoiGianLamViec}</td>
                <td colspan="12" style="text-align: right">
                    <a class="btn btn-warning" href="/congviec/edit/${congViec.soCCCD},${congViec.ngayVaoCongTy},${congViec.maNganh}">Edit</a>
                    <a class="btn btn-danger" href="/congviec/delete/${congViec.soCCCD},${congViec.ngayVaoCongTy},${congViec.maNganh}">Delete</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>