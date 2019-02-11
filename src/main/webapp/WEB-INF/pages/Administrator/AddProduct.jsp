<html>
<%@ include file="../header.jsp" %>
<body>

<%@ include file="../administrator_tabHeadtext.jsp" %>

<%@ include file="../administrator_buttons.jsp" %>


<div>
            <span class="design-block">
 <div class="center">
              <h2> Add product</h2>

              </div>

            </span>
    <span class="view-block">

              <form action="/AddProduct" method="post">
                  Model:&nbsp;&nbsp;&nbsp;<input type="text" margin="20px" name="model"/><br/><br/>
                  Collection:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="collection"/><br/><br/>
                  Price:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="stringPrice"/><br/><br/>
                  Amount:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="stringAmount"/><br/><br/>

                  <input type="submit" value="submit"/>
</form>
                <div class="center">
                </div>

            </span>
</div>


</body>
</html>