<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Requests.Repair" %>
<%@ page import="com.example.atelier.model.Requests.Request" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Repair</h2>
                </div>
                <a href="/AddRepair" class="btn btn-primary tablinks">Add Repair</a>


                                             <form method="post">
  <label for="action2">Select request to close:</label>

  <select style="color:black" name="repair_id" id="action2">

              <%
                  ArrayList<Repair> repairsToClose = (ArrayList<Repair>) request.getAttribute("ToCloseRepairList");
                  for (Repair item : repairsToClose) {
              %>
    <option value=<%=item.getRequest().getId()%>><%=item.getId()%> </option>
                      <%
                          }
                      %>
  </select>
  <button formaction="/CloseRepair" style="color:black" type="submit" name="submit" value="submit">Close repair request</button>
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
            <td>Repair Request ID</td>
        </tr>
        <%
            ArrayList<Repair> rows = (ArrayList<Repair>) request.getAttribute("RepairList");
            for (Repair item: rows)
            {
        %>
        <TR>
                    <td><%=item.getRequest().getId()%></td>
                    <td><%=item.getAdministrator()%></td>
                    <td><%=item.getRequest().getCollection()%></td>
                    <td><%=item.getRequest().getModel()%></td>
                    <td><%=item.getRequest().getComment()%></td>
                    <td><%=item.getRequest().getPrice()%></td>
                    <td><%=item.getRequest().getUser()%></td>
                    <td><%=Request.progressToString(Request.intToProgress(item.getRequest().getProgress()))%></td>
                    <td><%=item.getTailor()%></td>
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