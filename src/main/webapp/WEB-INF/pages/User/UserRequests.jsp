<html xmlns:th="http://www.thymeleaf.org">
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Requests.Request" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<body>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>My requests</h2>
                </div>
            </span>
    <span class="view-block">
              <form method="post">

    <table border="2">
        <tr>
            <td>Global Request ID</td>
            <td>Collection</td>
            <td>Model</td>
            <td>Price</td>
            <td>Status</td>
        </tr>
        <%
            ArrayList<Request> rows =  (ArrayList<Request>) session.getAttribute("userRequests");
            for (Request item: rows)
            {
        %>
        <TR>
                    <td><%=item.getId()%></td>
                    <td><%=item.getCollection()%></td>
                    <td><%=item.getModel()%></td>
                    <td><%=item.getPrice()%></td>
                    <td><%=item.getProgress()%></td>
        </TR>
                <%
                    }
                %>
    </table>
</form>

            </span></div>

</body>
</html>