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
                    <h2>Products</h2>
                </div>

                <a href="/toAddProduct" class="btn btn-primary tablinks">Add Product</a>

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


            </span></div>

</body>

</html>