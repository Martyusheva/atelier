<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
 <div class="center">
              <h2> Add user</h2>

              </div>

            </span>
    <span class="view-block">

              <form action="/AddUser" method="post">
                  Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" margin="20px" name="name"/><br/><br/>
                  Surname:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="surname"/><br/><br/>
                  Login:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="login"/><br/><br/>
                  Password:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="password"/><br/><br/>
                  Phone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="phone"/><br/><br/>

                  <input type="submit" value="submit"/>
</form>
                <div class="center">
                </div>

            </span>
</div>


</body>
</html>