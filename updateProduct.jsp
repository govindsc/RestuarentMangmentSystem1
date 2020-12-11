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
        <div class="update">
            <h3>Update product price</h3>
            <form class="form" action="UpdateProduct" method="post">
                <table>
                <div class="text_box">
            <td><h3 class="code">Product code</h3></td><td><input class="pcode" placeholder="Product code" name="pcode"/>   </td></tr>     
        <td><h3 class="pr">New price</h3></td><td><input class="price" placeholder="Ammount" name="price"/>   </td></tr>          

  <tr>
                <td><input class="button" type="submit" value="Update"/></td>
                <td><input class=" button" type="reset" value="Reset"/></td>
            </tr>
  
                </div>
                </table>            </form>
        </div>
    </body>
</html>
