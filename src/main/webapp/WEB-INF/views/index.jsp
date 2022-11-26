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
    <style>
        li{
            list-style: none;
        }
    </style>
</head>
<body>
<div class="container">

    <h1>Danh sách sinh viên tốt nghiệp và việc làm</h1>
    <div style="text-align: center">
        <a class="btn btn-primary" href="/sinhvien">Danh sách sinh viên</a>
        <a class="btn btn-primary" href="/totnghiep">Danh sách tốt nghiệp</a>
        <a class="btn btn-primary" href="/congviec">Danh sách công việc</a>
    </div>
    <table class="table">
        <thead>
        <form action="" method="post" onsubmit="return validateForm()" name="Form" required>
            <div class="form-floating">
                <th colspan="9"><input type="text" class="form-control" id="timKiem" name="timKiem" placeholder="Tìm kiếm"/></th>
                <th><button class="btn btn-primary mt-2" type="submit">Tìm kiếm</button></th>
            </div>
        </form>
        <tr style="border-right: 2px gray;">
            <th colspan="2" style="text-align: center">Sinh Viên</th>
            <th colspan="3" style="text-align: center">Tốt nghiệp</th>
            <th colspan="3" style="text-align: center">Công việc</th>
        </tr>
        <tr>
            <th scope="col">Số CCCD</th>
            <th scope="col">Tên</th>
            <th scope="col">Mã trường</th>
            <th scope="col">Mã ngành</th>
            <th scope="col">Hệ tốt nghiệp</th>
            <th scope="col">Mã công ty</th>
            <th scope="col">Tên công ty</th>
            <th scope="col">Thời gian làm việc</th>
<%--            <th >&nbsp;</th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sinhVien" items="${sinhviens}">
            <tr>
                <th scope="row">${sinhVien.soCCCD}</th>
                <td>${sinhVien.hoTen}</td>
                <td>
                    <c:forEach var="totNghiep" items="${totnghieps}">
                        <c:if test="${sinhVien.soCCCD == totNghiep.soCCCD}">
                            <li>${totNghiep.maTruong}</li>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="totNghiep" items="${totnghieps}">
                        <c:if test="${sinhVien.soCCCD == totNghiep.soCCCD}">
                            <li>${totNghiep.maNganh}</li>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="totNghiep" items="${totnghieps}">
                        <c:if test="${sinhVien.soCCCD == totNghiep.soCCCD}">
                            <li>${totNghiep.heTN}</li>
                        </c:if>
                    </c:forEach>
                </td>

                <td>
                    <c:forEach var="congViec" items="${congviecs}">
                        <c:if test="${sinhVien.soCCCD == congViec.soCCCD}">
                            <li>${congViec.maNganh}</li>
                        </c:if>
                    </c:forEach>
                </td>

                <td>
                    <c:forEach var="congViec" items="${congviecs}">
                        <c:if test="${sinhVien.soCCCD == congViec.soCCCD}">
                            <li>${congViec.tenCongTy}</li>
                        </c:if>
                    </c:forEach>
                </td>

                <td>
                    <c:forEach var="congViec" items="${congviecs}">
                        <c:if test="${sinhVien.soCCCD == congViec.soCCCD}">
                            <li>${congViec.thoiGianLamViec}</li>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

</body>
</html>