<%@ page import="com.example.atelier.model.Users.User" %>
<%@ page import="java.util.ArrayList" %>
<html>
<%@ include file="../header.jsp" %>
<body>
<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
 <div class="center">
              <h2> Add tailoring</h2>

              </div>

            </span>
    <span class="view-block">

                                <form method="post">
  <label for="action">Select user:</label>

  <select style="color:black" name="id" id="action">

              <%
                  ArrayList<User> users = (ArrayList<User>) request.getAttribute("UserList");
                  for (User item : users) {
              %>
    <option value=<%=item.getId()%>><%=item.getId()+" "+item.getName()+" "+item.getSurname()%></option>
                      <%
                          }
                      %>
  </select>
  <br/><br/>Model:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" margin="20px" name="model"/><br/>
                  Collection:&nbsp;<input type="text" name="collection"/><br/>
                  Comment:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="comment"/><br/>
                                    Price: <input type="text" name="price"/><br/><br/>
  <button formaction="/AddTailoringCheck" style="color:black" type="submit" name="submit" value="submit">Add tailoring</button>
</form>




            </span>
</div>


</body>
</html>