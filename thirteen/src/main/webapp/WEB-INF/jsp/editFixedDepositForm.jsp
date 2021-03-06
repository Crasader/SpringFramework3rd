<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Edit a fixed deposit</title>
    <style type="text/css">
        .td {
            font-family: 'arial';
            font-size: 12px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<form:form commandName="editableFixedDepositDetails" name="editFixedDepositForm" method="POST"
           action="${pageContext.request.contextPath}/fixedDeposit?fdAction=edit">
    <table align="left" style="padding-left: 300px;">
        <tr>
            <td
                    style="font-family: 'arial'; font-size: 16px; font-weight: bold;"
                    align="left">Edit fixed deposit</td>
        </tr>
        <tr align="left">
            <td>
                <table class="border" cellpadding="10">
                    <tr>
                        <td class="td"><b>Id:</b></td>
                        <td class="td"><b><c:out value="${editableFixedDepositDetails.fixedDepositId}"/></b></td>
                    </tr>
                    <tr>
                        <td class="td"><b>Amount (in USD):</b></td>
                        <td class="td"><form:input path="fdAmount" /><font
                                style="color: #C11B17;"><form:errors path="fdAmount"/></font></td>
                    </tr>
                    <tr>
                        <td class="td"><b>Tenure:</b></td>
                        <td class="td"><form:input path="tenure" /><font
                                style="color: #C11B17;"><form:errors path="tenure"/></font></td>
                    </tr>
                    <tr>
                        <td class="td"><b>Email:</b></td>
                        <td class="td"><form:input path="email" /><font
                                style="color: #C11B17;"><form:errors path="email"/></font></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr align="left">
            <td>
                <table style="padding-left: 100px;">
                    <tr align="center">
                        <td class="td"><input type="submit" value="Save" /> &nbsp;
                            &nbsp;<a
                                    href="${pageContext.request.contextPath}/fixedDeposit/list"
                                    style="color: green"><b>Go Back</b></a></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>