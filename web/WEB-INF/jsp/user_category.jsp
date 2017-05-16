<%-- 
    Document   : user_category
    Created on : 02 May 2017, 3:56:57 PM
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

            width: 80%;
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

                                    <td style="vertical-align:bottom;text-align:right;"><span style="float: left;"><img src="images/new_logo.jpg"  width="100" height="100" style="float: right;" alt="Logo" /></span></td>
                                    <td>
                                        <center> </center></td>

                                    <td style="background-color: #004a8d; color: white;font-size:14px;"width="100%" valign="bottom">
                                        <center> <b> <h2 style="float: left;font-size:13px;"><strong>&nbsp;Equipment Readiness & Availability</strong></h2></b> </center></td>
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
                <ul class="nav navbar-top-links navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                             <i class="fa fa-user fa-fw"></i> <strong>${user.firstname}</strong> <i class="fa fa-caret-down"></i> 
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
                            <li >

                                <div class="panel panel-primary" style=" border-radius: 1px; ">
                                    <div class="panel-heading "><i class="fa fa-list"></i>  ERA Tool</i> </div>

                                </div>

                            </li>
                        </ul>
                        <div id="left" class="span3">
                            <ul id="menu-group-1" class="nav menu">  
                                <li class="item-8 deeper parent">
                                    <a class=""  >
                                        <span data-toggle="collapse" data-parent="#menu-group-1" href="#sub-item-8" class="sign"><i class="glyphicon glyphicon-plus icon-white"></i></span>
                                        <span class="lbl" ><strong>Stopping</strong></span>                      
                                    </a>
                                    <ul class="children nav-child unstyled small collapse" id="sub-item-8">
                                        <li class="item-9 deeper parent">
                                            <a class=""  href="<c:url value='/category/${7}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-1" href="#sub-item-9" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Drilling</span> 
                                            </a>
                                        </li>
                                        <li class="item-10 deeper parent">
                                            <a class=""  href="<c:url value='/category/${6}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-1" href="#sub-item-12" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Cleaning</span> 
                                            </a>
                                        </li>
                                        <li class="item-11 deeper parent">
                                            <a class=""  href="<c:url value='/category/${5}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-1" href="#sub-item-9" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Charging</span> 
                                            </a>
                                        </li>
                                        <li class="item-12 deeper parent">
                                            <a class=""  href="<c:url value='/category/${8}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-1" href="#sub-item-12" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Supporting</span> 
                                            </a>
                                        </li>

                                    </ul>
                                </li>    			
                            </ul> 
                            <ul id="menu-group-2" class="nav menu">  
                                <li class="item-13 deeper parent">
                                    <a class=""  >
                                        <span data-toggle="collapse" data-parent="#menu-group-2" href="#sub-item-13" class="sign"><i class="glyphicon glyphicon-plus icon-white"></i></span>
                                        <span class="lbl"><strong>Develoment</strong></span>                      
                                    </a>
                                    <ul class="children nav-child unstyled small collapse" id="sub-item-13">
                                        <li class="item-14 deeper parent">
                                            <a class="" href="<c:url value='/category/${3}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-2" href="#sub-item-14" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Drilling</span> 
                                            </a>
                                        </li>
                                        <li class="item-15 deeper parent">
                                            <a class=""  href="<c:url value='/category/${2}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-2" href="#sub-item-12" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Cleaning</span> 
                                            </a>
                                        </li>
                                        <li class="item-16 deeper parent">
                                            <a class=""  href="<c:url value='/category/${1}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-2" href="#sub-item-9" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Charging</span> 
                                            </a>
                                        </li>
                                        <li class="item-17 deeper parent">
                                            <a class=""  href="<c:url value='/category/${4}/${user.username}' />">
                                                <span data-toggle="collapse" data-parent="#menu-group-2" href="#sub-item-12" class="sign"><i class="icon-plus icon-white"></i></span>
                                                <span class="lbl">Supporting</span> 
                                            </a>
                                        </li>

                                    </ul>
                                </li>    			
                            </ul
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


                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <div class="btn-group pull-right">
                                            <a href="#" class="btn btn-info btn-sm" data-toggle="modal" data-target="#newToolModal"><span class="glyphicon glyphicon-plus"></span><strong>Add New Tool</strong></a>
                                        </div>
                                        <h6><strong> ERA Tools</strong></h6>
                                    </div>
                                </div>  

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

                                        <table class="equipmentTable">
                                            <tr>
                                                <th width="80">Tool#</th>
                                                <th width="120">Tool Name</th>
                                                <th width="120">TRL</th>
                                                <th width="120">Usage</th>
                                                <th width="120">Manufacturer</th>
                                                <th width="120">Specification</th>
                                                <th width="60">Edit</th>
                                                <th width="60">Delete</th>
                                            </tr>

                                            <c:forEach items="${equipmentList}" var="equipment" varStatus="theCount">
                                                <c:set var="getSpecification" value="${equipment.specification}" />
                                                <c:set var="equipmentId" value="${equipment.equipmentId}"/>


                                                <tr>
                                                    <td>${equipment.equipmentId}</td>
                                                    <td>${equipment.name}</td>
                                                    <td>${equipment.trl}</td>
                                                    <td>${equipment.category.subActivity.subActivityName}</td>
                                                    <td>${equipment.manufacturer.companyName}</td>


                                                    <c:if test="${empty getSpecification}">
                                                        <td><a style="color:#5bc0de;" data-id="${equipmentId}" class="open-AddSpecDialog" href="#newSpecificationModal"><span class="glyphicon glyphicon-plus" style="color:#5bc0de;" ></span>Add</a></td> 
                                                    </c:if>
                                                    <c:if test="${not empty getSpecification}">
                                                        <td > <a href="DownloadServlet?action=download&smId=<c:out value="${list.smId}"/>" >View</a></td>

                                                    </c:if>
                                                    <td><a href="<c:url value='/edit/${equipment.equipmentId}' />" >Edit</a></td>
                                                    <td><a href="<c:url value='equipment/${equipment.equipmentId}/delete' />" >Delete</a></td>

                                           </tr>
                                            </c:forEach>
                                        </table>

                                    </div>
                                </c:if>
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
            <div class="modal fade" id="newToolModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <form  class="form-horizontal"  action="equipment/add" method="POST">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h6 class="modal-title"><strong>Add New Tool</strong></h6>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="name">Name:</label>
                                    <div class="col-sm-5">
                                        <input type="text" path="name" class="form-control input-sm" id="name" name="name" placeholder="Enter Tool Name" required>

                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="trl">TRL:</label>
                                    <div class="col-sm-5">
                                        <input type="number" class="form-control input-sm" id="trl" name="trl" placeholder="Enter Tool TRL" required>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-4 " for="manufacturer">Manufacturer:</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control input-sm" id="manufacturer" name="manufacturer" placeholder="Enter Tool Manufacturer "  required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4" for="trl">Usage:</label>
                                    <div class="col-sm-5">
                                        <select class="form-control input-sm" id="category" name="category" >

                                            <optgroup label=" Development"> 
                                                <option value="select">Select Category</option>
                                                <option value="1">Charging</option>
                                                <option value="2">Cleaning</option>
                                                <option value="3">Drilling</option>
                                                <option value="4">Supporting</option>
                                            </optgroup>
                                            <optgroup label="Stopping">
                                                <option value="5">Charging</option>
                                                <option value="6">Cleaning</option>
                                                <option value="7">Drilling</option>
                                                <option value="8">Supporting</option>
                                            </optgroup>
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
            <div class="modal fade" id="newSpecificationModal" tabindex="-1"   aria-labelledby="myModalLabel" aria-hidden="true" role="dialog">
                <div class="modal-dialog modal-lg">


                    <!-- Modal content-->
                    <div class="modal-content">
                        <form  class="form-horizontal"  action="specification/add" enctype="multipart/form-data" method="POST">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h6 class="modal-title"><strong>Add Specification</strong></h6>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" name="equipmentId" id="equipmentId" value="" />
                                <div class="form-group">

                                    <label class="control-label col-sm-4" for="trl">Upload Picture:</label>
                                    <div class="col-sm-6">
                                        <input type="file" id ="image" name="image" class="file">
                                        <div class="input-group col-xs-12">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                                            <input type="text" class="form-control input-sm" disabled placeholder="Upload Image">
                                            <span class="input-group-btn">
                                                <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-folder-open"></i> Browse</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-4" for="trl">Upload Datasheet:</label>
                                    <div class="col-sm-6">
                                        <input type="file" id ="datasheet" name="datasheet" class="file">
                                        <div class="input-group col-xs-12">
                                            <span class="input-group-addon"><i class="glyphicon glyphicon-file"></i></span>
                                            <input type="text" class="form-control input-sm" disabled placeholder="Upload Datasheet">
                                            <span class="input-group-btn">
                                                <button class="browse btn btn-primary input-sm" type="button"><i class="glyphicon glyphicon-folder-open"></i> Browse</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <span class="col-sm-4 addField control-label glyphicon glyphicon-plus add_form_field">Add New Field</span>
                                    <div class="col-md-6 ">
                                        <div class="form-group row container1">

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
            <div class="footer">Copyright &copy; 2017. All Rights Reserved. <strong></strong></div>
            <!-- /#wrapper -->
            <!-- jQuery -->
             <script src="<c:url value="vendor/jquery/jquery.min.js" />"></script>

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
