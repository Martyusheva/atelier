<%@ page import="com.example.atelier.model.Requests.Tailoring" %>
<%@ page import="java.util.ArrayList" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>
<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Tailoring</h2>
                </div>
                <a href="/AddTailoring" class="btn btn-primary tablinks">Add Tailoring</a>


                <form method="post">
  <label for="action2">Select request to close:</label>

  <select style="color:black" name="tailoring_id" id="action2">

              <%
                  ArrayList<Tailoring> utilsToClose = (ArrayList<Tailoring>) session.getAttribute("tailoringToCloseList");
                  for (Tailoring item : utilsToClose) {
              %>
    <option value=<%=item.getId()%>><%=item.getId()%> </option>
                      <%
                          }
                      %>
  </select>
  <button formaction="/CloseTailoring" style="color:black" type="submit" name="submit" value="submit">Close Tailoring request</button>
</form>

            </span>
    <span class="view-block">


    <table border="2">
        <tr>
            <td>Global Request ID</td>
            <td>Administrator</td>
            <td>Collection</td>
            <td>Model</td>
            <td>Comment</td>
            <td>Price</td>
            <td>User</td>
            <td>Status</td>
            <td>Tailor</td>
            <td>Tailoring Request ID</td>
        </tr>
        <%
            ArrayList<Tailoring> rows =  (ArrayList<Tailoring>) session.getAttribute("tailoringList");
            for (Tailoring item: rows)
            {
        %>
        <TR>
                    <td><%=item.getRequest().getId()%></td>
                    <td><%=item.getRequest().getAdminid()%></td>
                    <td><%=item.getRequest().getCollection()%></td>
                    <td><%=item.getRequest().getModel()%></td>
                    <td><%=item.getRequest().getComment()%></td>
                    <td><%=item.getRequest().getPrice()%></td>
                    <td><%=item.getRequest().getUserid()%></td>
                    <td><%=item.getRequest().getProgress()%></td>
                    <td><%=item.getTailorid()%></td>
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