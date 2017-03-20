<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<section class="wrapper">
    <h3>List services</h3>
    <div class="row">
        <div class="col-md-12">
            <div class="content-panel">
                <hr>
                <c:if test="${! empty errAddService}">
                    <h3  style="color: red"><c:out value="${listServicesBeanEmpty}"/></h3>
                </c:if>
                <c:if test="${!empty listServicesBeanEmpty}">
                    <h3  style="color: red"><c:out value="${listServicesBeanEmpty}"/></h3>
                </c:if>
                <c:if test="${!empty listServicesBean}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Room name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Permision</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listServicesBean}" var="service">
                    <tr>
                        <td><a href=""><c:out value="${service.id}"/></a></td>
                        <td><c:out value="${service.name}"/></td>
                        <td><c:out value="${service.price}"/></td>
                        <td><c:out value="${service.description}"/></td>
                        <td>
                            <button class="btn btn-primary btn-xs"><a href="/edit_service?id=${service.id}">Edit</a></button>
                            <button class="btn btn-danger btn-xs"><a href="/delete_service?id=${service.id}">Delete</a></button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>

                <div class="btn">
                    <a href="${pageContext.request.contextPath}/new_service">Add New Service</a>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
