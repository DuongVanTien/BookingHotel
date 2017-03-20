<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<section class="wrapper">
    <div class="row mt">
        <div class="col-lg-12">
            <div class="form-panel">
                <h4>Add Service </h4>
                <form class="form-horizontal style-form" modelAttribute="serviceBeanForm"
                      action="${pageContext.request.contextPath}/new_service" method="post" id="formService">
                    <c:if test="${!empty errAddService}">
                        <p><h3  style="color: red"><c:out value="${errAddService}"/></h3></p>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Service name</label>
                        <div class="col-sm-10">
                            <p id="errName" style="color: red"></p>
                            <input class="form-control" name="name" type="text" path="name" placeholder=" service name..."
                                id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Price</label>
                        <div class="col-sm-10">
                            <p id="errPrice" style="color: red"></p>
                            <input class="form-control" name="price" type="text" path="price" placeholder=" price..."
                                   id="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <p id="errDescription" style="color: red"></p>
                            <input class="form-control" name="description" type="text"
                                   path="description" placeholder="description..." id="description">
                        </div>
                    </div>
                    <div style="text-align: left;">
                        <button type="submit" class="btn btn-theme" id="btnSubmit">Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
