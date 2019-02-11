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
              <h2> Add Buy</h2>

              </div>

            </span>
    <span class="view-block">

                        <form method="post">
  <label for="action">Select user:</label>

  <select style="color:black" name="id" id="action">

              <%
                  ArrayList<User> commonUser = (ArrayList<User>) request.getAttribute("UserList");
                  for (User item : commonUser) {
              %>
    <option value=<%=item.getId()%>><%=item.getName()%></option>
                      <%
                          }
                      %>
  </select>
  <br/><br/>Model:<input type="text" margin="20px" name="model"/><br/>
                  Collection:<input type="text" name="collection"/><br/>
                  Comment:<input type="text" name="comment"/><br/>
  <button formaction="/AddBuyCheck" style="color:black" type="submit" name="submit" value="submit">Add buy</button>
</form>




                <div class="center">
                </div>

            </span>
</div>


</body>
</html>