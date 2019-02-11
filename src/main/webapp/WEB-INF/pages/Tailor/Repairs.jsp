<%@ page import="java.util.ArrayList" %>
<%@ page import="Requests.Request" %>
<%@ page import="Requests.RequestRepair" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>
<%@ include file="../master_buttons.jsp" %>




<div>
            <span class="design-block">
                <div class="center">
                    <h2>Repair requests</h2>
                </div>





                <form method="post">
  <label for="action">Set as "Done" request id:</label>
  <select style="color:black" name="repair_id" id="action">

              <%
                  ArrayList<RequestRepair> repairs = (ArrayList<RequestRepair>) request.getAttribute("MyRepair");
                  for (RequestRepair item : repairs) {
              %>
    <option value=<%=item.getOrderNumber()%>><%=item.getOrderNumber()%> </option>
                      <%
                          }
                      %>
  </select>
  <button formaction="/DoneRepair" style="color:black" type="submit" name="submit" value="submit">Ok</button>
</form>

            </span>
    <span class="view-block">
              <form method="post">

    <table border="2">
        <tr>
            <td>Global Request ID</td>
            <td>Administrator</td>
            <td>Collection</td>
            <td>Model</td>
            <td>Comment</td>
            <td>Status</td>
            <td>Repair Request ID</td>
        </tr>
        <%
            ArrayList<RequestRepair> rows = (ArrayList<RequestRepair>) request.getAttribute("MyRepair");
            for (RequestRepair item: rows)
            {
        %>
        <TR>
                    <td><%=(item).getOrderNumber()%></td>
                    <td><%=(item).getAdministrator()%></td>
                    <td><%=(item).getCollection()%></td>
                    <td><%=(item).getModel()%></td>
                    <td><%=(item).getComment()%></td>
                    <td><%=Request.progressToString((item).getProgress())%></td>
                    <td><%=(item).getRepairId()%></td>

        </TR>
                <%
                    }
                %>
    </table>
</form>

            </span></div>

</body>
</html>