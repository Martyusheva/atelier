<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Users.User" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Users</h2>
                </div>


                <form method="post">
  <label for="action">Select user:</label>
  <select style="color:black" name="id" id="action">

              <%

                  ArrayList<User> commonUser = (ArrayList<User>) request.getAttribute("commonUsersList");
                  if (commonUser != null) {
                      for (User item : commonUser) {
              %>
    <option value=<%=item.getId()%>><%=item.getId() + " " + item.getName() + " " + item.getSurname()%> </option>
                      <%
                          }
                      }  %>
       <option value=<%="-"%>> </option>
  </select>

  <button formaction="/AddTailor" style="color:black" type="submit" name="submit" value="submit">Add tailor</button>
  <button formaction="/AddAdministrator" style="color:black" type="submit" name="submit"
          value="submit">Add admin</button>
</form>

                <a href="/toAddUser" class="btn btn-primary tablinks">Add User</a>



            </span>
    <span class="view-block">
              <form method="post">

    <table border="2">
        <tr>
            <td>User ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>Phone</td>
        </tr>
        <%
            ArrayList<User> rows = (ArrayList<User>) request.getAttribute("usersList");
            if (rows != null) {
                for (User item : rows) {
        %>
        <TR>
                    <td><%=item.getId()%></td>
                    <td><%=item.getName()%></td>
                    <td><%=item.getSurname()%></td>
                    <td><%=item.getPhone()%></td>
        </TR>
                <%
                        }
                    }
                %>
    </table>
</form>

            </span></div>

</body>

</html>