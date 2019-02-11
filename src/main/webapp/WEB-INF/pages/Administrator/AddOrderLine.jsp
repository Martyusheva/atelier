
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.atelier.model.Product.Product" %>
<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
 <div class="center">
              <h2> Add order line</h2>

              </div>


    <form action="/CheckLine" method="post">
        <label for="action">Select product:</label>
        <select style="color:black" name="product_id" id="action">
            <%
              ArrayList<Product> productArrayList = (ArrayList<Product>) request.getAttribute("productsList");
              for (Product item : productArrayList) {
            %>
        <option value=<%=item.getId()%>><%=item.getId()%> </option>
                      <% session.setAttribute("product_id",item.getId());
                          }
                      %>
        </select>
 Count:<input style="color:black" type="text" name="count"/><br/><br/>

        <button type="submit" name="buy_id" class="btn btn-primary tablinks" value=<%=request.getAttribute("buy_id")%> > Add Order Line</button>
</form>

  <%--<button form action="/CheckLine" style="color:black" type="submit" name="buy_id" value=<%=request.getAttribute("buy_id")%>>Add OrderLine</button>--%>

<%--<form action="/authorization" method="post">--%>
    <%--Login:<input type="text" name="login"/><br/><br/>--%>
    <%--Password:<input type="password" name="password"/><br/><br/>--%>
    <%--<input type="submit" value="login"/>--%>
<%--</form>--%>

                                            <%--<form action="/CheckLine" method="post">--%>
  <%--<button type="submit" name="buy_id" class="btn btn-primary tablinks" value=<%=request.getAttribute("buy_id")%> > Add Order Line</button>--%>
<%--</form>--%>
<%--</form>--%>



              <%--<form action="/AddOrderLine" method="post">--%>
                  <%--Product id:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" margin="20px" name="product_id"/><br/><br/>--%>
                  <%----%>
                  <%--<input type="submit" value="submit"/>--%>
<%--</form>--%>

            </span>
    <span class="view-block">

    <table border="2">
        <tr>
            <td>Product ID</td>
            <td>Model</td>
            <td>Collection</td>
            <td>Price</td>
            <td>Amount</td>
        </tr>
        <%
            ArrayList<Product> rows = (ArrayList<Product>) request.getAttribute("productsList");
            for (Product item: rows)
            {
        %>
        <TR>
                    <td><%=item.getId()%></td>
                    <td><%=item.getModel()%></td>
                    <td><%=item.getCollection()%></td>
                    <td><%=item.getPrice()%></td>
                    <td><%=item.getAmount()%></td>
        </TR>
                <%
                    }
                %>
    </table>

            </span>
</div>


</body>
</html>