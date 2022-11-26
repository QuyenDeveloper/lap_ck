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
<%--    ${sinhviens}--%>
<div class="container">
    <h1>Thêm Sinh Viên</h1>
    <form action="" method="post" onsubmit="return validateForm()" name="Form" required>
        <div class="">
            <div class="form-floating">
                <label for="soCCCD">Số CCCD</label>
                <select name="soCCCD" id="soCCCD" class="form-control">
                    <c:forEach var="sinhVien" items="${sinhviens}">
                        <option value="${sinhVien.soCCCD}">${sinhVien.hoTen}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating">
                <label for="maTruong">Mã trường</label>
                <select name="maTruong" id="maTruong" class="form-control">
                    <c:forEach var="truong" items="${truongs}">
                        <option value="${truong.maTruong}">${truong.tenTruong}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating">
                <label for="maNganh">Mã nghành</label>
                <select name="maNganh" id="maNganh" class="form-control">
                    <c:forEach var="nganh" items="${nganhs}">
                        <option value="${nganh.maNganh}">${nganh.tenNganh}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-floating">
                <label for="heTN">Hệ tốt nghiệp</label>
                <input type="text" class="form-control" id="heTN" name="heTN" placeholder="he tot nghiep"/>
            </div>
            <div class="form-floating">
                <label for="ngayTN">Ngày tốt nghiệp</label>
                <input type="date" class="form-control" id="ngayTN" name="ngayTN" placeholder="Ngay tot nghiep"/>
            </div>
            <div class="form-floating">
                <label for="loaiTN">Loại tốt nghiệp</label>
                <input type="text" class="form-control" id="loaiTN" name="loaiTN" placeholder="Loai tot nghiep"/>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary mt-2" type="submit">Thêm</button>
        </div>
    </form>
</div>
</body>
</html>