<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Users.Tailor" %>

<html>
<%@ include file="../header.jsp" %>
<body>
<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Tailors</h2>
                </div>
                </form>
            </span>
    <span class="view-block">
              <form method="post">

    <table border="2">
        <tr>
            <td>User ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Login</td>
            <td>Password</td>
            <td>Phone</td>
            <td>Tailor Id</td>
        </tr>
        <%
            ArrayList<Tailor> rows = (ArrayList<Tailor>) request.getAttribute("tailorList");
            for (Tailor item: rows)
            {
        %>
        <TR>
                    <td><%=item.getUser().getId()%></td>
                    <td><%=item.getUser().getName()%></td>
                    <td><%=item.getUser().getSurname()%></td>
                    <td><%=item.getUser().getLogin()%></td>
                    <td><%=item.getUser().getPassword()%></td>
                    <td><%=item.getUser().getPhone()%></td>
                    <td><%=item.getId()%></td>
        </TR>
                <%
                    }
                %>
    </table>
</form>

            </span></div>

</body>

</html>