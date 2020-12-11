<html>
    <body>
        <i><h3>Restuarent Managment System</h3></i>
        <hr>
                <h3>Product Entry Form</h3>

        <form action="SaveProduct" method="post" enctype="multipart/form-data">
            <table >
            <tr>
                <td>Product Code</td><td><input type="text" name="pcode"/></td>
            </tr>
            <tr>
                <td>Product Name</td><td><input type="text" name="pname"/></td>
            </tr>
            <tr>
                <td>PDesc</td><td><input type="text" name="pdesc"/></td>
            </tr>
            <tr>
                   <tr>
                <td>Product category</td><td><select name="pcat">
                        <option>North_Indian</option>
                        <option>South_Indian</option>
                        <option>Chinese</option>
                        <option>Desserts</option>
                        <option>Indian_breads</option>
                        <option>Beverage</option></td></tr>


            <tr>
                <td>Price</td><td><input type="text" name="price"/></td>
            </tr>
            <tr>
                <td>
                    Photo </td>
                <td><input type="file" name="photo"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            </table>
        </form>
        <hr>
        <a href="index.jsp">Home</a>
    </body>
</html>

                            
                            
                            
                            
            