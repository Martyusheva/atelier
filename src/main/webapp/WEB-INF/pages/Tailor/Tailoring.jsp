<%@ page import="com.example.atelier.model.Requests.Tailoring" %>
<%@ page import="java.util.ArrayList" %>
<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../master_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Tailoring requests</h2>
                </div>


                                <form method="post">
  <label for="action">Set as "Done" request id:</label>
  <select style="color:black" name="tailoring_id" id="action">

              <%
                  ArrayList<Tailoring> tailoringList = (ArrayList<Tailoring>) session.getAttribute("tailoringToDoneList");
                  for (Tailoring item : tailoringList) {
              %>
    <option value=<%=item.getId()%>><%=item.getId()%> </option>
                      <%
                          }
                      %>
  </select>
  <button formaction="/DoneTailoring" style="color:black" type="submit" name="submit" value="submit">Ok</button>
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
            <td>Util Request ID</td>
            <td>Status</td>
        </tr>
        <%
            ArrayList<Tailoring> rows = (ArrayList<Tailoring>) session.getAttribute("tailoringToDoneList");
            for (Tailoring item: rows)
            {
        %>
        <TR>
                    <td><%=item.getId()%></td>
                    <td><%=item.getRequest().getAdminid()%></td>
                    <td><%=item.getRequest().getCollection()%></td>
                    <td><%=item.getRequest().getModel()%></td>
                    <td><%=item.getRequest().getComment()%></td>
                    <td><%=item.getId()%></td>
                    <td><%=item.getRequest().getProgress()%></td>
        </TR>
                <%
                    }
                %>
    </table>
            </span></div>

</body>
</html>