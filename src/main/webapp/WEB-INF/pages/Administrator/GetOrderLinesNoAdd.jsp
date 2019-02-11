<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Requests.Orderline" %>

<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
                <div class="center">
                    <h2>Order lines for <%=session.getAttribute("buy_id")%> buy request</h2>
                </div>


            </span>
    <span class="view-block">
              <form method="post">

    <table border="2">
        <tr>
            <td>Product ID</td>
            <td>Product Count</td>
            <td>Model</td>
            <td>Collection</td>
            <td>Price</td>
        </tr>
        <%
            ArrayList<Orderline> rows = (ArrayList<Orderline>) session.getAttribute("OrderLines");
            for (Orderline item: rows)
            {
        %>
        <TR>
                    <td><%=item.getProduct().getId()%></td>
                    <td><%=item.getProductcount()%></td>
                    <td><%=item.getProduct().getModel()%></td>
                    <td><%=(item).getProduct().getCollection()%></td>
                    <td><%=(item).getProduct().getPrice()%></td>
        </TR>
                <%
                    }
                %>
    </table>
</form>

            </span></div>

</body>

</html>