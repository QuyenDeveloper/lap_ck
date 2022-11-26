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
                <input type="text" class="form-control" id="soCCCD" name="soCCCD" value="${congviec.soCCCD}"/>
            </div>
            <div class="form-floating">
                <label for="ngayVaoCongTy">Ngày vào công ty</label>
                <input type="Date" class="form-control" id="ngayVaoCongTy" name="ngayVaoCongTy" value="${congviec.ngayVaoCongTy}"/>
            </div>
            <div class="form-floating">
                <label for="maNganh">Mã ngành</label>
                <select class="form-control" id="maNganh" name="maNganh">
                    <c:forEach var="nganh" items="${nganhs}">
                        <c:choose>
                            <c:when test="${nganh.maNganh == congviec.maNganh}">
                                <option value="${nganh.maNganh}" selected>${congviec.maNganh}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${nganh.maNganh}">${nganh.maNganh}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>

<%--                <input type="text" class="form-control" id="maNganh" name="maNganh" value="${congviec.maNganh}"/>--%>
            </div>
            <div class="form-floating">
                <label for="tenCongViec">Tên công việc</label>
                <input type="text" class="form-control" id="tenCongViec" name="tenCongViec" value="${congviec.tenCongViec}"/>
            </div>
            <div class="form-floating">
                <label for="tenCongTy">Tên công ty</label>
                <input type="text" class="form-control" id="tenCongTy" name="tenCongTy" value="${congviec.tenCongTy}"/>
            </div>
            <div class="form-floating">
                <label for="diaChiCongTy">Địa chỉ công ty</label>
                <input type="text" class="form-control" id="diaChiCongTy" name="diaChiCongTy" value="${congviec.diaChiCongTy}"/>
            </div>
            <div class="form-floating">
                <label for="thoiGianLamViec">Thời gian làm việc</label>
                <input type="text" class="form-control" id="thoiGianLamViec" name="thoiGianLamViec" value="${congviec.thoiGianLamViec}"/>
            </div>
        </div>
        <div class="text-center">
            <button class="btn btn-primary mt-2" type="submit">Sửa</button>
        </div>
    </form>
</div>
</body>
</html>