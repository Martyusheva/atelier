<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Users.Administrator" %>

<html>
    <%@ include file="../header.jsp" %>
    <body>

    <%@ include file="../administrator_tabHeadtext.jsp" %>

        <%@ include file="../administrator_buttons.jsp" %>


        <div>
            <span class="design-block">
                <div class="center">
                    <h2>Administrators</h2>
                </div>
            </span>

            <span class="view-block">

                <table border="2">
                    <tr>
                        <td>User ID</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td>Phone</td>
                        <td>Admin Id</td>
                    </tr>
                    <%
                        ArrayList<Administrator> rows = (ArrayList<Administrator>) request.getAttribute("adminsList");
                        for (Administrator item : rows) {
                    %>
                    <TR>
                                <td><%=item.getUser().getId()%></td>
                                <td><%=item.getUser().getName()%></td>
                                <td><%=item.getUser().getSurname()%></td>
                                <td><%=item.getUser().getPhone()%></td>
                                <td><%=item.getId()%></td>
                    </TR>
                    <%
                        }
                    %>
                </table>
            </span>
        </div>

</body>

</html>