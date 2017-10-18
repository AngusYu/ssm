<%--
  Created by IntelliJ IDEA.
  User: AngusYu
  Date: 2017/10/17
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>detail Page</title>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">
    <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#ajax_post").click(function () {
                var book_id=$("#book_id").text();
                var link='/book/'+book_id+'/appoint_by_ajax';
                var studentId=$("input[name='studentId']").val();
                var data={"studentId":studentId};
                $.ajax({
                    type: "POST",
                    url: link,
                    contentType: "application/json",
                    data: JSON.stringify(data),
                    success: function (jsonResult) {
                        processJsonResult(jsonResult);
                    }
                });
            });
            $("#submit_post").click(function () {
                $("#appoint_form").submit();
            })
        });

        function processJsonResult(jsonResult) {
            $("#json_data").text(JSON.stringify(jsonResult));
            $("#success").text(jsonResult.success);
            $("#error").text(jsonResult.error);
            $("#response_data").text(JSON.stringify(jsonResult.data));
        }
    </script>
</head>
<body>
<form id="appoint_form" action="/book/${book.id}/appoint" method="post">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th colspan="5" style="text-align:center;">Book Detail</th>
        </tr>
        <tr>
            <th>Book Id</th>
            <th>Book Name</th>
            <th>Book Amount</th>
            <th>Student ID</th>
            <th>Operation</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><span id="book_id">${book.id}</span></td>
            <td>${book.name}</td>
            <td>${book.amount}</td>
            <td><input type="text" name="studentId" class="form-control" value="12345678910"></td>
            <td><input class="btn btn-info" value="Appoint By Ajax" id="ajax_post"><input class="btn btn-info" value="Appoint By Submit" id="submit_post"></td>
        </tr>
        </tbody>
    </table>
</form>

<div style="margin-top: 100px;">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th colspan="2" style="text-align:center;">Ajax Content</th>
        </tr>
        <tr>
            <th style="width: 200px;">Property</th>
            <th>Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Response Json</td>
            <td><span id="json_data"></span></td>
        </tr>
        <tr>
            <td>Request Accept Success</td>
            <td><span id="success"></span></td>
        </tr>
        <tr>
            <td>Request Accept Error Info</td>
            <td><span id="error"></span></td>
        </tr>
        <tr>
            <td>Response Data Info</td>
            <td><div id="response_data"></div></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
