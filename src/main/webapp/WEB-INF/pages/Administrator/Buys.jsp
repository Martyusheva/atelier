<%@ page import="com.example.atelier.model.Requests.Buy" %>
<%@ page import="java.util.ArrayList" %>
<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Buy</h2>
                </div>
                <a href="/AddBuy" class="btn btn-primary tablinks">Add Buy</a>

                                <form method="post">
  <label for="action">Select request to add orderlines:</label>
  <select style="color:black" name="buy_id" id="action">

              <%
                  ArrayList<Buy> buys = (ArrayList<Buy>) request.getAttribute("buysList");
                  for (Buy item : buys) {
              %>
    <option value=<%=item.getId()%>><%=item.getId()%> </option>
                      <%
                          }
                      %>
  </select>
  <button formaction="/GetOrderLines" style="color:black" type="submit" name="submit"
          value="submit">Get order lines</button>
</form>

  <form method="post">
  <label for="action">Select request to close:</label>

  <select style="color:black" name="buy_id" id="action2">

              <%
                  ArrayList<Buy> buysToClose = (ArrayList<Buy>) request.getAttribute("buysToCloseList");
                  for (Buy item : buysToClose) {
              %>
    <option value=<%=item.getId()%>><%=item.getId()%> </option>
                      <%
                          }
                          //session.setAttribute("buy_id", item.getId());
                      %>
      <%--<option value=<%="-"%>> </option>--%>
  </select>
  <button formaction="/CloseBuy" style="color:black" type="submit" name="submit"
          value="submit">Close buy request</button>
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
            <td>Price</td>
            <td>User</td>
            <td>Status</td>
            <td>Buy Request ID</td>
        </tr>
        <%
            ArrayList<Buy> rows = (ArrayList<Buy>) request.getAttribute("buysList");
            for (Buy item : rows) {
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