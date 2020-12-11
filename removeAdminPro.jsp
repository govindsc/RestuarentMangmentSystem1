<%-- 
    Document   : UpdateProduct
    Created on : 17 Oct, 2019, 11:10:36 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="remove">
            <h3>Remove product</h3>
            <form class="form" action="RemoveAdminProduct" method="post">
                <table>
                <div class="text_box">
            <td><h3 class="code">Product code</h3></td><td><input class="pcode" placeholder="Product code" name="pcode"/>   </td></tr>     

  <tr>
                <td><input class="button" type="submit" value="Remove"/></td>
                <td><input class=" button" type="reset" value="Reset"/></td>
            </tr>
  
                </div>
                </table>            </form>
        </div>
    </body>
</html>
