<%-- 
    Document   : admin
    Created on : 25 Apr 2017, 2:42:39 PM
    Author     : LQwabe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        .btn-glyphicon { padding:8px; background:#ffffff; margin-right:4px; }
        .icon-btn { padding: 1px 15px 3px 2px; border-radius:50px;}

        html{

            font-size: 16px;
        }
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
        .equipmentTable{overflow: scroll;}
        .equipmentTable td, th
        {
            /*            border:1px solid green;*/
            font-family: Arial, Helvetica, sans-serif;
            white-space: nowrap;

        }
        .equipmentTable tfoot input
        {
            border:2px solid green;
            width: 150px;
            /*            background-color:green;
                        color:white;*/
        }
        .box-shadow--2dp {
            box-shadow: 0 2px 2px 0 rgba(0, 0, 0, .14), 0 3px 1px -2px rgba(0, 0, 0, .2), 0 1px 5px 0 rgba(0, 0, 0, .12)
        }
        .box-shadow--3dp {
            box-shadow: 0 3px 4px 0 rgba(0, 0, 0, .14), 0 3px 3px -2px rgba(0, 0, 0, .2), 0 1px 8px 0 rgba(0, 0, 0, .12)
        }
        .box-shadow--4dp {
            box-shadow: 0 4px 5px 0 rgba(0, 0, 0, .14), 0 1px 10px 0 rgba(0, 0, 0, .12), 0 2px 4px -1px rgba(0, 0, 0, .2)
        }
        .box-shadow--6dp {
            box-shadow: 0 6px 10px 0 rgba(0, 0, 0, .14), 0 1px 18px 0 rgba(0, 0, 0, .12), 0 3px 5px -1px rgba(0, 0, 0, .2)
        }
        .box-shadow--8dp {
            box-shadow: 0 8px 10px 1px rgba(0, 0, 0, .14), 0 3px 14px 2px rgba(0, 0, 0, .12), 0 5px 5px -3px rgba(0, 0, 0, .2)
        }
        .box-shadow--16dp {
            box-shadow: 0 16px 24px 2px rgba(0, 0, 0, .14), 0 6px 30px 5px rgba(0, 0, 0, .12), 0 8px 10px -5px rgba(0, 0, 0, .2)
        }
        .centeredBody{

            /*            width: 100%;
                        align:center;margin-right: auto;
                        margin-left: auto;border: 2px solid #a1a1a1;
            
                        -webkit-box-shadow: rgba(0,0,0,0.8) 0px 0 10px;
                        -moz-box-shadow: rgba(0,0,0,0.8) 0 0 10px;
                        box-shadow: rgba(0,0,0,0.8) 0 0 10px;
            
                        border-radius: 2px;*/


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
        .yadcf-filter-reset-button{

            background-color: #fff;
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

        /* USER PROFILE PAGE */
        .card {
            margin-top: 20px;
            padding: 30px;
            background-color: rgba(214, 224, 226, 0.2);
            -webkit-border-top-left-radius:5px;
            -moz-border-top-left-radius:5px;
            border-top-left-radius:5px;
            -webkit-border-top-right-radius:5px;
            -moz-border-top-right-radius:5px;
            border-top-right-radius:5px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        .card.hovercard {
            position: relative;
            padding-top: 0;
            overflow: hidden;
            text-align: center;
            background-color: #fff;
            background-color: rgba(255, 255, 255, 1);
        }
        .card.hovercard .card-background {
            height: 130px;
        }
        .card-background img {
            -webkit-filter: blur(25px);
            -moz-filter: blur(25px);
            -o-filter: blur(25px);
            -ms-filter: blur(25px);
            filter: blur(25px);
            margin-left: -100px;
            margin-top: -200px;
            min-width: 130%;
        }
        .card.hovercard .useravatar {
            position: absolute;
            top: 15px;
            left: 0;
            right: 0;
        }
        .card.hovercard .useravatar img {
            width: 100px;
            height: 100px;
            max-width: 100px;
            max-height: 100px;
            -webkit-border-radius: 50%;
            -moz-border-radius: 50%;
            border-radius: 50%;
            border: 5px solid rgba(255, 255, 255, 0.5);
        }
        .card.hovercard .card-info {
            position: absolute;
            bottom: 14px;
            left: 0;
            right: 0;
        }
        .card.hovercard .card-info .card-title {
            padding:0 5px;
            font-size: 20px;
            line-height: 1;
            color: #262626;
            background-color: rgba(255, 255, 255, 0.1);
            -webkit-border-radius: 4px;
            -moz-border-radius: 4px;
            border-radius: 4px;
        }
        .card.hovercard .card-info {
            overflow: hidden;
            font-size: 12px;
            line-height: 20px;
            color: #737373;
            text-overflow: ellipsis;
        }
        .card.hovercard .bottom {
            padding: 0 20px;
            margin-bottom: 17px;
        }
        .btn-pref .btn {
            -webkit-border-radius:0 !important;
        }


        /*        .users {
          table-layout: fixed;
          width: 100%;
          white-space: nowrap;
        }
        .users td {
          white-space: nowrap;
          overflow: scroll;
          text-overflow: ellipsis;
        }
        
         Column widths are based on these cells 
        .row-username {
          width: 100%;
        }
        .row-password {
          width: 100%;
        }
        .row-firstname {
          width: 100%;
        }
        .row-lastname {
          width: 100%;
        }
        .row-email {
          width: 100%;
        }
        .row-oem {
          width: 100%;
        }
        .row-contact {
          width: 50%;
        }
        .row-action {
          width: 50%;
        }*/


        #sidebar a{

            font-weight: bold;
            font-size: 16px;


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
                <br>
                <br>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> <strong>${admin.firstname}</strong> <i class="fa fa-caret-down"></i> 
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<c:url value='/logout' />"</i> Logout</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->
                <br>
                <div class="navbar-header sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li class="sidebar-search">
                                <div class="input-group custom-search-form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-addon">
                                        <i class="fa fa-search"></i>
                                    </span>
                                </div>
                            </li>
                        </ul>
                        <div id="left" class="span3">

                            <div id="left" class="span3">


                                <ul id="sidebar" class="nav nav-pills nav-stacked " style="max-width: 300px;">
                                    <li class="active"><a href="#"><span class="glyphicon glyphicon-off"></span>  Overview</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-user"></span>  About Us</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-lock"></span>  Our Vision</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-signal"></span>  Our Partners</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-comment"></span> FAQs</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-envelope"></span>  Message</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-list"></span>  Schedule</a></li>
                                    <li><a href="#"><span class="glyphicon glyphicon-earphone"></span>  Contacts</a></li>
                                </ul>


                            </div>
                        </div>
                    </div>
                    <!-- /.nav-second-level -->



                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header"></h1>
                        </div>
                        <!-- /.col-lg-12 -->
                        <div class="panel panel-primary">
                            <div class="panel-heading"></div>
                            <div class="panel-body">


                                <div class="panel panel-default box-shadow--16dp"  >
                                    <div class="panel-heading">
                                        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
                                            <div class="btn-group" role="group">
                                                <button type="button" id="stars" class="btn btn-primary" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
                                                    <div class="hidden-xs"><strong>Avaliable Tools</strong></div>
                                                </button>  
                                            </div>
                                            <div class="btn-group" role="group">
                                                <button type="button" id="favorites" class="btn btn-default" href="#tab2" data-toggle="tab"><span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
                                                    <div class="hidden-xs"><strong>OEM Management</strong></div>
                                                </button>
                                            </div>
                                            <div class="btn-group" role="group">
                                                <button type="button" id="following" class="btn btn-default" href="#tab3" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                                    <div class="hidden-xs"><strong>User Management</strong></div>
                                                </button>
                                            </div>
                                        </div>

                                        <div class="well">
                                            <div class="tab-content">
                                                <div class="tab-pane fade in active" id="tab1">

                                                    <c:if test="${not empty msg}">
                                                        <div class="alert alert-${css} alert-dismissible" role="alert">
                                                            <button type="button" class="close" data-dismiss="alert"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                            <strong>${msg}</strong>
                                                        </div>
                                                    </c:if>

                                                    <c:if test="${not empty equipmentList}">
                                                        <div>

                                                            <table cellpadding="0"class="box-shadow--6dp equipmentTable table table-striped table-condensed" id="tools" width="100%">
                                                                <thead>
                                                                    <tr>
                                                                        <th >Tool#</th>
                                                                        <th >Tool Name</th>
                                                                        <th >TRL</th>
                                                                        <th >Usage</th>
                                                                        <th >Manufacturer</th>
                                                                        <th >Specification</th>


                                                                    </tr>
                                                                </thead>
                                                                <tfoot>
                                                                    <tr>
                                                                        <th id="name">name</th>
                                                                        <th  id="trl">trl</th>
                                                                        <th  id="usage">usage</th>
                                                                        <th  id="manufacturer">manufacturer</th>

                                                                    </tr>
                                                                </tfoot>

                                                                <c:forEach items="${equipmentList}" var="equipment" varStatus="theCount">
                                                                    <c:set var="getSpecification" value="${equipment.specification}" />
                                                                    <c:set var="equipmentId" value="${equipment.equipmentId}"/>
                                                                    <c:set var="specificationDetails" value="${equipment.specification.specificationDetails}" />


                                                                    <tr>
                                                                        <td width="10px">${theCount.count}</td>
                                                                        <td>${equipment.name}</td>
                                                                        <td>${equipment.trl}</td>
                                                                        <td>${equipment.category.subActivity.subActivityName}</td>
                                                                        <td>${equipment.manufacturer.companyName}</td>


                                                                        <c:if test="${empty getSpecification}">
                                                                            <td>

                                                                                <a style="color:#5cb85c;"  ><span style="color:#5cb85c;" ></span><strong>No Spec Added Yet</strong></a></td> 
                                                                                    </c:if>
                                                                                    <c:if test="${not empty getSpecification}">
                                                                            <td ><a data-id="${equipmentId}@${specificationDetails}" class="downloadSpecDialog" href="#viewSpecificationModal" >View</a></td>
                                                                        </c:if>

                                                                    </tr>
                                                                </c:forEach>
                                                            </table>

                                                        </div>
                                                    </c:if>          
                                                </div>
                                                <div class="tab-pane fade in" id="tab2">

                                                    <div class="btn-group pull-right">
                                                        <a href="#" class="btn btn-info btn-sm box-shadow--4dp" data-toggle="modal" data-target="#newOEMModal"><span class="glyphicon glyphicon-plus"></span><strong>Add New OEM</strong></a>
                                                    </div>

                                                    <br/>
                                                    <br/>
                                                    <c:if test="${not empty msg}">
                                                        <div class="alert alert-${css} alert-dismissible" role="alert">
                                                            <button type="button" class="close" data-dismiss="alert"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                            <strong>${msg}</strong>
                                                        </div>
                                                    </c:if>

                                                    <c:if test="${not empty OEMs}">
                                                        <div>

                                                            <table cellpadding="0"class=" box-shadow--6dp equipmentTable table table-striped table-condensed" id="manufacturers" width="100%">
                                                                <thead>
                                                                    <tr>
                                                                        <th >#</th>
                                                                        <th >OEM Name</th>
                                                                        <th >Logo</th>
                                                                        <th >Action</th>

                                                                    </tr>
                                                                </thead>
                                                                <tfoot>
                                                                    <tr>
                                                                        <th id="oem_number">Index</th>
                                                                        <th  id="oem_name">OEM Name</th>
                                                                    </tr>
                                                                </tfoot>
                                                                <c:forEach items="${OEMs}" var="OEM" varStatus="theCount">
                                                                    <c:set var="logo" value="${OEM.companyLogo}"/>
                                                                    <tr>
                                                                        <td width="10px">${theCount.count}</td>
                                                                        <td>${OEM.companyName}</td>
                                                                        <c:if test="${empty logo}">
                                                                            <td>No logo added yet</td>
                                                                        </c:if>
                                                                        <c:if test="${not empty logo}">
                                                                            <td ><img src="getLogo/<c:out value="${OEM.companyId}"/>" width="100" height="50"></td>
                                                                            </c:if>
                                                                        <td><a data-id="${OEM.companyId},${OEM.companyName}" class="editOEMDialog" href="#editOEMModal" ><span style="color:green;"class="glyphicon glyphicon-edit"></span></a>
                                                                            <a href="<c:url value='oem/${OEM.companyId}/delete' />" ><span style="color:red;" class="glyphicon glyphicon-trash"></span></a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </div>
                                                    </c:if> 
                                                </div>
                                                <div class="tab-pane fade in" id="tab3">


                                                    <div class="btn-group pull-right">
                                                        <a href="#" class="btn btn-info btn-sm box-shadow--4dp" data-toggle="modal" data-target="#newUserModal"><span class="glyphicon glyphicon-plus"></span><strong>Add New User</strong></a>
                                                    </div>
                                                    <br/>
                                                    <br/>

                                                    <c:if test="${not empty msg}">
                                                        <div class="alert alert-${css} alert-dismissible" role="alert">
                                                            <button type="button" class="close" data-dismiss="alert"
                                                                    aria-label="Close">
                                                                <span aria-hidden="true">×</span>
                                                            </button>
                                                            <strong>${msg}</strong>
                                                        </div>
                                                    </c:if>

                                                    <c:if test="${not empty Users}">
                                                        <div>

                                                            <table cellpadding="0"class="users box-shadow--6dp equipmentTable table table-striped table-condensed" id="Users" width="100%">
                                                                <thead>
                                                                    <tr>

                                                                        <th  class="row-username">Username</th>
                                                                        <th class="row-password">Password</th>
                                                                        <th class="row-firstname">Firstname</th>
                                                                        <th class="row-lastname" >LastName</th>
                                                                        <th class="row-email">E-Mail</th>
                                                                        <th class="row-oem">OEM Name</th>
                                                                        <th class="row-contact">Contact</th>
                                                                        <th class="row-action" >Action</th>
                                                                    </tr>
                                                                </thead>
                                                                <tfoot>
                                                                    <tr>
                                                                        <th id="username">Username</th>
                                                                        <th id="firstname">Firstname</th>
                                                                        <th id="lastname">Lastname</th>
                                                                        <th id="email">E-Mail</th>
                                                                        <th id="oem">OEM Name</th>
                                                                    </tr>
                                                                </tfoot>
                                                                <c:forEach items="${Users}" var="user" varStatus="theCount">
                                                                    <tr>
                                                                        <td>${user.username}</td>
                                                                        <td>${user.password}</td>
                                                                        <td>${user.firstname}</td>
                                                                        <td>${user.lastname}</td>
                                                                        <td>${user.email}</td>
                                                                        <td>${user.company.companyName}</td>
                                                                        <td>${user.contact}</td>
                                                                        <td><a data-id="${user.username},${user.password},${user.firstname},${user.lastname},${user.email},${user.contact},${user.company.companyName}" class="editUserDialog" href="#editUserModal" ><span style="color:green;"class="glyphicon glyphicon-edit"></span></a>
                                                                            <a href="<c:url value='user/${user.username}/delete' />" ><span style="color:red;" class="glyphicon glyphicon-trash"></span></a></td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </table>
                                                        </div>
                                                    </c:if> 

                                                </div>
                                            </div>
                                        </div>  


                                    </div>
                                    <div class="panel-footer"></div>
                                </div>
                                <!-- /.row -->
                            </div>
                            <!-- /.container-fluid -->
                        </div>
                    </div>
                    <!-- /#page-wrapper -->
                    <!-- Modal -->
                    <div class="modal fade" id="newOEMModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <form  class="form-horizontal"  action="oem/add" enctype="multipart/form-data"  method="POST">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h6 class="modal-title"><strong>Add New OEM</strong></h6>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="name">OEM Name:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="name" class="form-control input-sm" id="name" name="name" placeholder="Enter OEM Name" required>

                                            </div>
                                        </div>

                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="logo">Upload Logo:</label>
                                            <div class="col-sm-6">
                                                <input type="file" id ="logo" name="logo" class="file">
                                                <div class="input-group col-xs-12">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                                                    <input type="text" class="form-control input-sm" disabled placeholder="Upload Logo">
                                                    <span class="input-group-btn">
                                                        <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-folder-open"></i> Browse</button>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-info btn-sm" >Add</button>

                                        <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Modal End --> 
                    <!-- Modal -->
                    <div class="modal fade" id="newUserModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <form  class="form-horizontal"  action="user/add" method="POST">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h6 class="modal-title"><strong>Add New User</strong></h6>
                                    </div>
                                    <div class="modal-body">
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="username">Username:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="username" class="form-control input-sm" id="username" name="username" placeholder="Enter username" required>

                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="password">Password:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="password" class="form-control input-sm" id="password" name="password" placeholder="Enter Password" required>
                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="firstname">First Name:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="firstname" class="form-control input-sm" id="firstname" name="firstname" placeholder="Enter Firstname" required>

                                            </div>
                                        </div>

                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="lastname">Last Name:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="lastname" class="form-control input-sm" id="lastname" name="lastname" placeholder="Enter Lastname" required>

                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="email">E-Mail:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="email" class="form-control input-sm" id="email" name="email" placeholder="Enter E-Mail" required>

                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="contact">Contact No:</label>
                                            <div class="col-sm-5">
                                                <input type="text" path="contact" class="form-control input-sm" id="contact" name="contact" placeholder="Enter Contact No" required>

                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="company">OEM Name:</label>
                                            <div class="col-sm-5">
                                                <select class="form-control input-sm" id="company" name="company" >

                                                    <option value="select">Select</option>
                                                    <c:forEach items="${OEMs}" var="OEM" varStatus="theCount">
                                                        <option value="${OEM.companyName}">${OEM.companyName}</option>
                                                    </c:forEach>     
                                                </select>        

                                            </div>
                                        </div>
                                        <div class="form-group">

                                            <label class="control-label col-sm-4" for="contact">Role:</label>
                                            <div class="col-sm-5">

                                                <select class="form-control input-sm" id="role" name="role" >

                                                    <option value="select">Select</option>
                                                    <option value="1">Admin</option>
                                                    <option value="0">Other</option>

                                                </select>        
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-info btn-sm" >Add</button>

                                        <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Modal End --> 
                    <!-- Modal -->
                    <div class="modal fade" id="viewSpecificationModal" tabindex="-1"   aria-labelledby="myModalLabel" aria-hidden="true" role="dialog">
                        <div class="modal-dialog ">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <form  class="form-horizontal"  action="download"  method="GET">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h6 class="modal-title"><strong>Specification</strong></h6>
                                    </div>
                                    <div class="modal-body">
                                        <input type="hidden" name="equipmentId" id="equipmentId2" />
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="image">Image:</label>
                                            <div class="col-sm-10">
                                                <button class="btn icon-btn btn-default box-shadow--6dp" id="image" name="action"value="image" ><span class="glyphicon btn-glyphicon glyphicon-save img-circle text-muted"></span>Download</button>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2" for="email">Datasheet:</label>
                                            <div class="col-sm-10">
                                                <button class="btn icon-btn btn-default box-shadow--6dp" id="datasheet" name="action" value="datasheet" ><span class="glyphicon btn-glyphicon glyphicon-save img-circle text-muted"></span>Download</button>
                                            </div>
                                        </div>
                                    </div>

                                </form>

                                <table align="center"id="params" class="table table-striped table-condensed box-shadow--16dp" style=" padding-left: 10px;padding-right: 10px;">
                                    <tr>
                                        <th>Measurements</th>
                                        <th>Units</th> 

                                    </tr>

                                </table>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                                </div>
                                <textarea rows="4" cols="40" name="specDetails" id="specDetails"style="display:none;" ></textarea>
                                <input type="hidden" name="1st" id="1st"/>
                                <input type="hidden" name="2nd" id="2nd"/>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal End -->



            <!-- Modal -->
            <div class="modal fade" id="editOEMModal" tabindex="-1"   aria-labelledby="ModalLabel2" aria-hidden="true" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <form  class="form-horizontal"  action="oem/edit" enctype="multipart/form-data"  method="POST">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h6 class="modal-title"><strong>Edit OEM</strong></h6>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" path="companyId1" class="form-control input-sm" id="companyId1" name="companyId1">

                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="name1">OEM Name:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="name1" class="form-control input-sm" id="name1" name="name1" placeholder="Enter OEM Name" required>

                                    </div>
                                </div>

                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="logo">Upload Logo:</label>
                                    <div class="col-sm-6">
                                        <input type="file" id ="logo1" name="logo1" class="file">
                                        <div class="input-group col-xs-12">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                                            <input type="text" class="form-control input-sm" disabled placeholder="Upload Logo">
                                            <span class="input-group-btn">
                                                <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-folder-open"></i> Browse</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-info btn-sm" >Save</button>

                                <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Modal End --> 


            <!-- start here>
            <!-- Modal -->
            <div class="modal fade" id="editUserModal" tabindex="-1"   aria-labelledby="ModalLabel" aria-hidden="true" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <form  class="form-horizontal"  action="user/edit" method="POST">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h6 class="modal-title"><strong>Edit User</strong></h6>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="username1">Username:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="username1" class="form-control input-sm" id="username1" name="username1" readonly required>

                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="password1">Password:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="password1" class="form-control input-sm" id="password1" name="password1" placeholder="Enter Password" required>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="firstname1">First Name:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="firstname1" class="form-control input-sm" id="firstname1" name="firstname1" placeholder="Enter Firstname" required>

                                    </div>
                                </div>

                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="lastname">Last Name:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="lastname1" class="form-control input-sm" id="lastname1" name="lastname1" placeholder="Enter Lastname" required>

                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="email1">E-Mail:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="email1" class="form-control input-sm" id="email1" name="email1" placeholder="Enter E-Mail" required>

                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="contact1">Contact No:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="contact1" class="form-control input-sm" id="contact1" name="contact1" placeholder="Enter Contact No" required>

                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="company">OEM Name:</label>
                                    <div class="col-sm-5">
                                        <select class="form-control input-sm" id="company1" name="company1" >

                                            <option value="select">Select</option>
                                            <c:forEach items="${OEMs}" var="OEM" varStatus="theCount">
                                                <option value="${OEM.companyName}">${OEM.companyName}</option>
                                            </c:forEach>     
                                        </select>        

                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-info btn-sm" >Save</button>

                                <button type="button" class="btn btn-info btn-sm" data-dismiss="modal">Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!-- Modal End --> 





            <!-- ends here -->

        </div>
    </div>

    <div class="footer">Copyright &copy; 2017. All Rights Reserved. <strong></strong></div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <!--                         <script src="vendor/jquery/jquery.min.js"></script>-->
    <script src="<c:url value="vendor/jquery/jquery.min.js" />"></script>
     <script src="<c:url value="js/bootstrap-modal-clear.js" />"></script>

    <script type="text/javascript">
        $(document).ready(function () {
        $("#tablediv").hide();
                $("#test1").click(function (event) {
        $.get('PopulateTable', function (responseJson) {
        if (responseJson != null) {
        $("#countrytable").find("tr:gt(0)").remove();
                var table1 = $("#countrytable");
                $.each(responseJson, function (key, value) {
                var rowNew = $("<tr><td nowrap ></td ><td nowrap></td><td nowrap></td><td nowrap></td><td nowrap></td><td nowrap></td></tr>");
                        rowNew.children().eq(0).text(value['offshoreTerminalId']);
                        rowNew.children().eq(1).text(value['country']);
                        rowNew.children().eq(2).text(value['operatorName']);
                        rowNew.children().eq(3).text(value['product']);
                        rowNew.children().eq(4).text(value['yearInstalled']);
                        rowNew.children().eq(5).text(value['status']);
                        rowNew.appendTo(table1);
                });
        }
        });
                $("#tablediv").show();
        });
    </script>
    <script>
                !function ($) {

                // Le left-menu sign
                /* for older jquery version
                 $('#left ul.nav li.parent > a > span.sign').click(function () {
                 $(this).find('i:first').toggleClass("icon-minus");
                 }); */

                $(document).on("click", "#left ul.nav li.parent > a > span.sign", function(){
                $(this).find('i:first').toggleClass("glyphicon glyphicon-minus");
                });
                        // Open Le current menu
                        $("#left ul.nav li.parent.active > a > span.sign").find('i:first').addClass("glyphicon glyphicon-minus");
                        $("#left ul.nav li.current").parents('ul.children').addClass("in");
                }(window.jQuery);
    </script>
    <script>
                $(document).on("click", ".open-AddSpecDialog", function (e) {

        e.preventDefault();
                var _self = $(this);
                var equipmentId = _self.data('id');
                $("#equipmentId").val(equipmentId);
                $(_self.attr('href')).modal('show');
        });
    </script>



    <script>
                $(document).on("click", ".downloadSpecDialog", function (e) {

        e.preventDefault();
                var _self = $(this);
                var list = _self.data('id');
                var fields = list.split("@");
                $("#equipmentId2").val(fields[0]);
                $("#specDetails").val(fields[1]);
                var parameters = fields[1]
                var splitting = parameters.split(":");
                var first = splitting[0];
                var second = splitting[1];
                $("#1st").val(first);
                $("#2nd").val(second);
                var array1 = first.split(",");
                var array2 = second.split(",");
                var arrayLength = array1.length;
                var table;
                for (i = 0; i < arrayLength; i++) {
        table = '<tbody  class="tableBody">'
                table = table + "<tr>"
                table = table + "<td>"
                table = table + array1[i]
                table = table + "</td>"
                table = table + "<td>"
                table = table + array2[i]
                table = table + "</td>"
                table = table + "</tr>"
                table = table + "</tbody>"

                $("#params").append(table);
        }

        $(_self.attr('href')).modal('show');
        });
    </script>

    <script>
                $(document).on("click", ".editUserDialog", function (e) {

        e.preventDefault();
                var _self = $(this);
                var list = _self.data('id');
                var fields = list.split(",");
                $("#username1").val(fields[0]);
                $("#password1").val(fields[1]);
                $("#firstname1").val(fields[2]);
                $("#lastname1").val(fields[3]);
                $("#email1").val(fields[4]);
                $("#contact1").val(fields[5]);
                $("#company1").val(fields[6]);
                $(_self.attr('href')).modal('show');
        });
    </script>
    <script>
                $(document).on("click", ".editOEMDialog", function (e) {
        e.preventDefault();
                var _self = $(this);
                var list = _self.data('id');
                var fields = list.split(",");
                $("#companyId1").val(fields[0]);
                $("#name1").val(fields[1]);
                $(_self.attr('href')).modal('show');
        });
    </script>
    <script>
                $(document).ready(function() {
        $(".btn-pref .btn").click(function () {
        $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
                // $(".tab").addClass("active"); // instead of this do the below 
                $(this).removeClass("btn-default").addClass("btn-primary");
        });
        });
    </script>
    <script>
                function doAjaxPost() {
                // get the form values
                var name = $('#name').val();
                        var name = $('#name').val();
                        var trl = $('#trl').val();
                        var manufacturer = $('#manufacturer').val();
                        var category = $('#category').val();
                        $.ajax({
                        type: "POST",
                                url: "/equipment/add",
                                data: "name=" + name + "&trl=" + trl + "&manufacturer=" + manufacturer + "&category=" + category,
                                success: function(response){
                                // we have the response

                                },
                                error: function(e){
                                alert('Error: ' + name + trl + manufacturer + category);
                                }
                        });
                }
    </script>
    <script>
        $(document).on('click', '.browse', function(){
        var file = $(this).parent().parent().parent().find('.file');
                file.trigger('click');
        });
                $(document).on('change', '.file', function(){
        $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
        });
    </script>
    <script>
                $(document).ready(function() {
        var max_fields = 10;
                var wrapper = $(".container1");
                var add_button = $(".add_form_field");
                var x = 0;
                $(add_button).click(function(e){
        e.preventDefault();
                if (x < max_fields){

        x++;
                var html = '<div>';
                html = '<a href="#" class="delete col-md-2 control-label"><span  class="glyphicon glyphicon-trash red"></span></a>';
                html = html + '<div class="col-md-5">';
                html = html + '<input type="text"  name="specParameter" class="form-control" id="specParameter" placeholder="Parameter">';
                html = html + '</div>';
                html = html + '<div class="col-md-5">';
                html = html + '<input type="text"  name="specValue" class="form-control" id="specValue" placeholder="Value with units"> ';
                html = html + '</div>';
                html = html + '</div>';
                $(wrapper).append(html); //add input box
        }
        else
        {
        alert('You Reached the limits')
        }
        });
                $(wrapper).on("click", ".delete", function(e){
        e.preventDefault(); $(this).parent('div').remove(); x--;
        })
        });</script>

    <script type="text/javascript" src="js/bundle-yadcf.js" charset="utf-8"></script>

    <!-- BOOTSTRAP -->
    <script>
                $(document).ready(function () {
        var datepickerDefaults = {
        showTodayButton: true,
                showClear: true,
                format: "YYYY/MM/DD"
        };
                var table = $('#tools').DataTable(); // or whatever you want

                yadcf.init(table, [{
                column_number: 1,
                        filter_type: 'auto_complete',
                        filter_container_id: "name",
                        filter_default_label: "--keyword--",
                        "width": "20px%"

                }, {
                column_number: 2,
                        filter_type: 'auto_complete',
                        filter_container_id: "trl",
                        filter_default_label: "--keyword--"
                }, {
                column_number: 3,
                        filter_type: 'auto_complete',
                        filter_container_id: "usage",
                        filter_default_label: "--keyword--"
                }, {
                column_number: 4,
                        filter_type: 'auto_complete',
                        filter_container_id: "manufacturer",
                        filter_default_label: "--keyword--"
                }]);
        });
    </script>

    <script>
                $(document).ready(function () {
        var datepickerDefaults = {
        showTodayButton: true,
                showClear: true,
                format: "YYYY/MM/DD"
        };
                var table = $('#Users').DataTable(); // or whatever you want

                yadcf.init(table, [{
                column_number: 0,
                        filter_type: 'auto_complete',
                        filter_container_id: "username",
                        filter_default_label: "--keyword--",
                        "width": "20px%"

                }, {
                column_number: 2,
                        filter_type: 'auto_complete',
                        filter_container_id: "firstname",
                        filter_default_label: "--keyword--"
                },
                {
                column_number: 4,
                        filter_type: 'auto_complete',
                        filter_container_id: "email",
                        filter_default_label: "--keyword--"
                },
                {
                column_number: 5,
                        filter_type: 'auto_complete',
                        filter_container_id: "oem",
                        filter_default_label: "--keyword--"
                }, {
                column_number: 3,
                        filter_type: 'auto_complete',
                        filter_container_id: "lastname",
                        filter_default_label: "--keyword--"
                }]);
        });
    </script>
    <script>
                $(document).ready(function () {
        var datepickerDefaults = {
        showTodayButton: true,
                showClear: true,
                format: "YYYY/MM/DD"
        };
                var table = $('#manufacturers ').DataTable(); // or whatever you want

                yadcf.init(table, [{
                column_number: 0,
                        filter_type: "range_number",
                        filter_container_id: "oem_number",
                        filter_default_label: "--keyword--",
                        "width": "20px%"

                }, {
                column_number: 1,
                        filter_type: 'auto_complete',
                        filter_container_id: "oem_name",
                        filter_default_label: "--keyword--"
                }]);
        });
    </script>
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
