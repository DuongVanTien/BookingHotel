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
    <div class="row mt">
        <div class="col-lg-12">
            <div class="form-panel">
                <h4><i class="fa fa-angle-right"></i> Update Room infomation </h4>
                <form class="form-horizontal style-form" modelAttribute="roomBeanForm"
                      action="${pageContext.request.contextPath}/update_room" method="post">
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Room name</label>
                        <div class="col-sm-10">
                            <input hidden="true" class="form-control" name="id" type="text" path="id" value="${roomBeanForm.id}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Room name</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="name" type="text" path="name" value="${roomBeanForm.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Price</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="price" type="text" path="price" value="${roomBeanForm.price}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="description" type="text"
                                   path="description" value="${roomBeanForm.description}">
                        </div>
                    </div>

                    <div style="text-align: left">
                        <button type="submit" class="btn btn-theme">Edit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
