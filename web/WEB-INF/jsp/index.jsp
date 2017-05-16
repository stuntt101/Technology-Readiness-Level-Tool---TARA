<%-- 
    Document   : index3
    Created on : 21 Apr 2017, 9:25:57 AM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon-32x32_logo.png" type="image/png" sizes="32x32">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>ERA Tool</title>

        <!-- Bootstrap Core CSS -->
<!--        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
        <link href="<c:url value="vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
       

        <!-- MetisMenu CSS -->
<!--        <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">-->
        <link href="<c:url value="vendor/metisMenu/metisMenu.min.css" />" rel="stylesheet">

        <!-- Custom CSS -->
<!--        <link href="dist/css/sb-admin-2.css" rel="stylesheet">-->
         <link href="<c:url value="dist/css/sb-admin-2.css" />" rel="stylesheet">

        <!-- Custom Fonts -->
<!--        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">-->
         <link href="<c:url value="vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    </head>
    <style>
        #map {
            height: 500px;
            width: 900px;
        }
        .file {
            visibility: hidden;
            position: absolute;
        }
        .modal-admin{

            width: 50%;
        }

        .footer {
            background-color: #004a8d;
            color: white;
            right: 0;
            height: 30px;
            bottom: 0;
            left: 0;
            padding: 1rem;
            /*            background-color: #efefef;*/
            text-align: center;
            z-index: -1;
        }
        label{
            color: #3c763d;
            font-weight: bold;
            font-size: 13px


        }
        .addField{
            color: #3c763d;
            font-weight: bold;
            font-size: 13px;
            font-family: 'Oxygen', sans-serif;

        }
        .container {
            width: 400px;
            margin: 50px auto;
            height: 100%;
            perspective: 600px;
        }

        .alert{
            width: 550px;

        }

        .box-shadow {
            box-shadow: 0 12px 30px darkgrey;
        }
        .equipmentTable td, th
        {
            border:1px solid green;
            font-family: Arial, Helvetica, sans-serif;
        }
        .equipmentTable th
        {
            background-color:green;
            color:white;
        }
        .centeredBody{

            width: 100%;
            align:center;margin-right: auto;
            margin-left: auto;border: 2px solid #a1a1a1;

            -webkit-box-shadow: rgba(0,0,0,0.8) 0px 0 10px;
            -moz-box-shadow: rgba(0,0,0,0.8) 0 0 10px;
            box-shadow: rgba(0,0,0,0.8) 0 0 10px;

            border-radius: 2px;


        }
        /* MENU-LEFT
-------------------------- */
        /* layout */
        #left ul.nav {
            margin-bottom: 2px;
            font-size: 12px; /* to change font-size, please change instead .lbl */
        }
        #left ul.nav ul,
        #left ul.nav ul li {
            list-style: none!important;
            list-style-type: none!important;
            margin-top: 1px;
            margin-bottom: 1px;
        }
        #left ul.nav ul {
            padding-left: 0;
            width: auto;
        }
        #left ul.nav ul.children {
            padding-left: 12px;
            width: auto;
        }
        #left ul.nav ul.children li{
            margin-left: 0px;
        }
        #left ul.nav li a:hover {
            text-decoration: none;
        }

        #left ul.nav li a:hover .lbl {
            color: #999!important;
        }

        #left ul.nav li.current>a .lbl {
            background-color: #999;
            color: #fff!important;
        }

        /* parent item */
        #left ul.nav li.parent a {
            padding: 0px;
            color: #ccc;
        }
        #left ul.nav>li.parent>a {
            border: solid 1px #999;
            text-transform: uppercase;
        }    
        #left ul.nav li.parent a:hover {
            background-color: #fff;
            -webkit-box-shadow:inset 0 3px 8px rgba(0,0,0,0.125);
            -moz-box-shadow:inset 0 3px 8px rgba(0,0,0,0.125);
            box-shadow:inset 0 3px 8px rgba(0,0,0,0.125);    
        }

        /* link tag (a)*/
        #left ul.nav li.parent ul li a {
            color: #222;
            border: none;
            display:block;
            padding-left: 5px;    
        }

        #left ul.nav li.parent ul li a:hover {
            background-color: #fff;
            -webkit-box-shadow:none;
            -moz-box-shadow:none;
            box-shadow:none;  
        }

        /* sign for parent item */
        #left ul.nav li .sign {
            display: inline-block;
            width: 14px;
            padding: 5px 8px;
            font-weight: bold;
            font-size: 13px;
            background-color: transparent;
            color: #fff;
        }
        #left ul.nav li.parent>a>.sign{
            margin-left: 0px;
            background-color: #999;
        }

        ::-webkit-input-placeholder { font-size: 13px;       }
        ::-moz-placeholder { font-size: 13px;      } /* firefox 19+ */
        :-ms-input-placeholder { font-size: 13px;       } /* ie */
        input:-moz-placeholder { font-size: 13px;       }

        /* label */
        #left ul.nav li .lbl {
            padding: 5px 12px;
            display: inline-block;
        }
        #left ul.nav li.current>a>.lbl {
            color: #fff;
        }
        #left ul.nav  li a .lbl{
            font-size: 12px;
        }

        /* THEMATIQUE
        ------------------------- */
        /* theme 1 */
        #left ul.nav>li.item-1.parent>a {
            border: solid 1px #ff6307;
        }
        #left ul.nav>li.item-1.parent>a>.sign,
        #left ul.nav>li.item-1 li.parent>a>.sign{
            margin-left: 0px;
            background-color: #ff6307;
        }
        #left ul.nav>li.item-1 .lbl {
            color: #ff6307;
        }
        #left ul.nav>li.item-1 li.current>a .lbl {
            background-color: #ff6307;
            color: #fff!important;
        }

        /* theme 2 */
        #left ul.nav>li.item-8.parent>a {
            border: solid 1px #51c3eb;
        }
        #left ul.nav>li.item-13.parent>a {
            border: solid 1px #51c3eb;
        }
        #left ul.nav>li.item-8.parent>a>.sign,
        #left ul.nav>li.item-8 li.parent>a>.sign{
            margin-left: 0px;
            width:25px;
            background-color: #51c3eb;
        }
        #left ul.nav>li.item-13.parent>a>.sign,
        #left ul.nav>li.item-13 li.parent>a>.sign{
            margin-left: 0px;
            width:25px;
            background-color: #51c3eb;
        }
        #left ul.nav>li.item-8 .lbl {
            color: #51c3eb;
        }
        #left ul.nav>li.item-13 .lbl {
            color: #51c3eb;
        }
        #left ul.nav>li.item-8 li.current>a .lbl {
            background-color: #51c3eb;
            color: #fff!important;
        }
        #left ul.nav>li.item-13 li.current>a .lbl {
            background-color: #51c3eb;
            color: #fff!important;
        }

        /* theme 3 */
        /*#left ul.nav>li.item-15.parent>a {
            border: solid 1px #94cf00;
        }
        #left ul.nav>li.item-15.parent>a>.sign,
        #left ul.nav>li.item-15 li.parent>a>.sign{
            margin-left: 0px;
            background-color: #94cf00;
        }
        #left ul.nav>li.item-15 .lbl {
            color: #94cf00;
        }
        #left ul.nav>li.item-15 li.current>a .lbl {
            background-color: #94cf00;
            color: #fff!important;
        }*/

        /* theme 4 */
        #left ul.nav>li.item-22.parent>a {
            border: solid 1px #ef409c;
        }
        #left ul.nav>li.item-22.parent>a>.sign,
        #left ul.nav>li.item-22 li.parent>a>.sign{
            margin-left: 0px;
            background-color: #ef409c;
        }
        #left ul.nav>li.item-22 .lbl {
            color: #ef409c;
        }
        #left ul.nav>li.item-22 li.current>a .lbl {
            background-color: #ef409c;
            color: #fff!important;
        }

        .container1 input[type=text] {
            padding:5px 0px;
            margin:5px 5px 5px 0px;
        }

        .add_form_field
        {
            /*            background-color: #1c97f3;
                        border: none;
                        color: white;
                        padding: 8px 32px;
                        text-align: center;
                        text-decoration: none;
                        display: inline-block;
                        font-size: 16px;
                        margin: 4px 2px;
                        cursor: pointer;
                        border:1px solid #186dad;*/
        }

        input{
            border: 1px solid #1c97f3;
            width: 260px;
            height: 40px;
            margin-bottom:14px;
        }



        .red{

            color: #fd1200;
            cursor: pointer;
        }

        .delete{
            /*            background-color: #fd1200;
                        border: none;
                        color: white;
                        padding: 5px 15px;
                        text-align: center;
                        text-decoration: none;
                        display: inline-block;
                        font-size: 14px;
                        margin: 4px 2px;
                        cursor: pointer;*/
        }
    </style>

    <body class="centeredBody">

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 5">
                <div class="navbar-header">

                    <div id="header">
                        <div id="header-wrap">
                            <table class="header_table"width="100%" height="20%" border="1" style="background-color:#004a8d;" >
                                <tr rowspan="3"> <td colspan="3"><center>  </center></td></tr>
                                <tr align=”left”>

                                    <td style="vertical-align:bottom;text-align:right;"><span style="float: left;"><img src="images/new_logo.jpg"  width="150" height="150" style="float: right;" alt="Logo" /></span></td>
                                    <td>
                                        <center> </center></td>

                                    <td style="background-color: #004a8d; color: white;font-size:14px;"width="100%" valign="bottom">
                                        <center> <b> <h2 style="float: left;font-size:16px;"><strong>&nbsp;Equipment Readiness & Availability</strong></h2></b> </center></td>
                                </tr>

                            </table>

                        </div>

                    </div>
                </div>
                <!-- /.navbar-header -->
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
        
                <!-- /.navbar-top-links -->
                <br>
                <!-- /.sidebar-collapse -->
                </nav>
                </div>
                <!-- /.navbar-static-side -->
                <br> <br> <br> <br>
                <c:if test="${not empty msg}">
                    <div class="alert center-block alert-${css} alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <strong>${msg}</strong>
                    </div>
                </c:if>

                <div class="container">
                    <form   action="login" autocomplete="off" method="POST">

                        <div class="panel panel-default box-shadow">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <strong>Login</strong>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group">
                                    <label for="email" class="control-label">Username</label>
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="username"
                                        name="username"
                                        placeholder="Username"
                                        required>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="control-label">Password</label>
                                    <input
                                        type="password"
                                        class="form-control"
                                        id="password"
                                        name="password"
                                        placeholder="Password"
                                        required>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block">Login</button>
                            </div>
                        </div>
                    </form>
                </div>

                <br>
                <br>
                <br><br><br><br><br><br><br><br><br><br><br><br>

                <!-- /#page-wrapper -->

                <div class="footer">Copyright &copy; 2017. All Rights Reserved. <strong></strong></div>
                <!-- /#wrapper -->
                <!-- jQuery -->
<!--                <script src="vendor/jquery/jquery.min.js"></script>-->
                <script src="<c:url value="vendor/jquery/jquery.min.js" />"></script>







                <!-- Bootstrap Core JavaScript -->
<!--                <script src="vendor/bootstrap/js/bootstrap.min.js"></script>-->
                 <script src="<c:url value="vendor/bootstrap/js/bootstrap.min.js" />"></script>

                <!-- Metis Menu Plugin JavaScript -->
<!--                <script src="vendor/metisMenu/metisMenu.min.js"></script>-->
                  <script src="<c:url value="vendor/metisMenu/metisMenu.min.js" />"></script>

                <!-- Custom Theme JavaScript -->
<!--                <script src="dist/js/sb-admin-2.js"></script>-->
                <script src="<c:url value="dist/js/sb-admin-2.js" />"></script>

                </body>

                </html>
