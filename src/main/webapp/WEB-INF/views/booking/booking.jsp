<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css"/>
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css"/>
<style>
    .bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
    .bootstrap-iso form {
        font-family: Arial, Helvetica, sans-serif;
        color: black
    }

    .bootstrap-iso form button,
    .bootstrap-iso form button:hover {
        color: white !important;
    }

    .asteriskField {
        color: red;
    }
</style>

<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>--%>
<!-- Bootstrap core CSS -->
<%--<link href="./checkbox_files/bootstrap.css" rel="stylesheet">--%>
<%--<link href="./checkbox_files/font-awesome.css" rel="stylesheet">--%>

<%--<!-- Custom styles for this template -->--%>
<%--<link href="./checkbox_files/style.css" rel="stylesheet">--%>
<%--<link href="./checkbox_files/style-responsive.css" rel="stylesheet">--%>
<%--<link rel="stylesheet" href="./checkbox_files/to-do.css">--%>
<script>
    $(document).ready(function () {
        var date_input = $('input[name="birthday"]');
        var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'yyyy/mm/dd',
            container: container,
            todayHighlight: true,
            autoclose: true
        })
    });
</script>
<div class="col-lg-9">
    <form class="form-horizontal style-form" modelattribute="bookingBeanForm"
          action="${pageContext.request.contextPath}/update" method="post">
        <div>
            <aside class="col-lg-4 mt">
                <form:form class="form-horizontal style-form" modelAttribute="clientBeanForm"
                           action="${pageContext.request.contextPath}/update" method="post">
                    <section class="panel">
                        <div class="panel-body">
                            <h4><i style="color: #843534">Client infomation</i></h4>
                            <hr>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Fullname</label>
                                <div class="col-sm-9">
                                        <%--<p id="errFullname" style="color: red"></p>--%>
                                    <input class="form-control" name="fullname" type="text" path="fullname"
                                           placeholder=" fullname..." id="fullname">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Card number</label>
                                <div class="col-sm-9">
                                        <%--<p id="errCardNumber" style="color: red"></p>--%>
                                    <input class="form-control" name="cardNumber" type="text" path="cardNumber"
                                           placeholder=" card number..." id="cardNumber">
                                </div>
                            </div>
                            <div class="form-group ">
                                <label class="col-sm-3 control-label">Birthday</label>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input class="form-control" path="birthday" id="birthday" name="birthday"
                                               placeholder="yyyy/mm/dd" type="text"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Address</label>
                                <div class="col-sm-9">
                                        <%--<p id="errAddress" style="color: red"></p>--%>
                                    <input class="form-control" name="address" type="text" path="address"
                                           placeholder=" address..." id="address">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Phone</label>
                                <div class="col-sm-9">
                                        <%--<p id="errPhone" style="color: red"></p>--%>
                                    <input class="form-control" name="phone" type="text" path="phone"
                                           placeholder=" phone..."
                                           id="phone">
                                </div>
                            </div>
                        </div>
                    </section>
                </form:form>
            </aside>

            <aside class="col-lg-8 mt">
                <form:form class="form-horizontal style-form" modelAttribute="roomBeanForm" method="post">
                    <section class="panel">
                        <div class="panel-body">
                            <h4><i class="fa fa-tasks" style="color: green"> Booking room infomation</i></h4>
                            <hr>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Hotel</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.getHotel().getName()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Star level</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.getHotel().getStarLevel()}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Room name</label>
                                <div class="col-sm-9">
                                    <label class="control-label"> ${roomBeanForm.name} </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Price per night</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.price}</label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Description</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${roomBeanForm.description}</label>
                                </div>
                            </div>
                            <form:form class="form-horizontal style-form" modelAttribute="conditionBookingBeanForm" method="post">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">Time booking</label>
                                <div class="col-sm-9">
                                    <label class="control-label">${conditionBookingBeanForm.startDate}
                                    - ${conditionBookingBeanForm.endDate}</label>
                                </div>
                            </div>
                            </form:form>
                        </div>
                    </section>
                </form:form>
            </aside>
        </div>

        <div>
            <aside class="col-lg-12">
                <form:form class="form-horizontal style-form" modelAttribute="bookingBeanForm"
                    action="${pageContext.request.contextPath}/booking" method="post">
                    <div>
                        <div class="panel-heading">
                            <div class="pull-left"><h4><i class="fa fa-tasks" style="color: #843534"> Service List</i></h4>
                            </div>
                            <br>
                        </div>
                        <div class="custom-check goleft mt" class="col-sm-6">
                            <table id="todo" class="table table-hover custom-check">
                                <tbody>
                                <tr>
                                    <td class="col-sm-5" style="text-align: center">Service name</td>
                                    <td class="col-sm-2" style="text-align: center">Price</td>
                                    <td class="col-sm-5" style="text-align: center">Description</td>
                                </tr>
                                <c:forEach items="${listServicesBeanForm}" var="service">
                                    <tr>
                                        <td class="col-sm-5">
                                            <form:checkbox path="services" name="services" value="${service.id}"
                                                           label="  ${service.name}"/>
                                        </td>
                                        <td class="col-sm-2" style="text-align: center">${service.price}</td>
                                        <td class="col-sm-5">${service.description}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div style="text-align: left">
                        <button type="submit" class="btn btn-theme">Booking</button>
                    </div>
                </form:form>
            </aside>
        </div>
    </form>
</div>

<!-- RIGHT SIDEBAR CONTENT -->
<div class="col-lg-3 ds">
    <h3>NOTIFICATIONS</h3>
    <!-- First Action -->
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>2 Minutes Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">James Brown</a> subscribed to your newsletter.<br>
            </p>
        </div>
    </div>
    <!-- Second Action -->
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>3 Hours Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">Diana Kennedy</a> purchased a year
                subscription.<br>
            </p>
        </div>
    </div>
    <!-- Third Action -->
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>7 Hours Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">Brandon Page</a> purchased a year
                subscription.<br>
            </p>
        </div>
    </div>
    <!-- Fourth Action -->
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>11 Hours Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">Mark Twain</a> commented your post.<br>
            </p>
        </div>
    </div>
    <!-- Fifth Action -->
    <div class="desc">
        <div class="thumb">
            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
        </div>
        <div class="details">
            <p>
                <muted>18 Hours Ago</muted>
                <br>
                <a href="http://www.blacktie.co/demo/dashgum/index.html#">Daniel Pratt</a> purchased a wallet in your
                store.<br>
            </p>
        </div>
    </div>
    <!-- end NOTIFICATION ----------->


    <h3>NOTIFICATIONS</h3>
    <!-- 1 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-divya.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DIVYA MANIAN</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 2 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-sherman.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DJ SHERMAN</a><br>
                <muted>I am Busy</muted>
            </p>
        </div>
    </div>
    <!-- 3 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-danro.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">DAN ROGERS</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 4 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-zac.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">Zac Sniders</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
    <!-- 5 -->
    <div class="desc">
        <div class="thumb">
            <img class="img-circle" src="./DASHGUM - form booking 2_files/ui-sam.jpg" width="35px" height="35px"
                 align="">
        </div>
        <div class="details">
            <p><a href="http://www.blacktie.co/demo/dashgum/index.html#">Marcel Newman</a><br>
                <muted>Available</muted>
            </p>
        </div>
    </div>
</div>

