<html>
    
    <head>
        <link rel="stylesheet" href="restStyle.css">
        <style>
            body{
                background-image: url(loginBck.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                
            }
        </style>
    </head>
    <body>
        <div class="form">
            <h3 class="reg">Registration Form</h3>
       
        <form action="SaveUserInfo" method="get">
            <table >
                
            <tr>
                <td class="em"> Email</td><td><input class="text" type="text" name="email"/></td>
            </tr>
            <tr>
                <td class="em">Password</td><td><input class="text" type="password" name="password"/></td>
            </tr>
            <tr>
                <td class="em">Name</td><td><input class="text" type="text" name="name"/></td>
            </tr>
            <tr>
                <td class="em">Address</td><td><input class="text" type="text" name="address"/></td>
            </tr>
         
            <tr>
                <td class="em">Mobile</td><td><input class="text" type="text" name="mobile"/></td>
            </tr>
            <tr>
                <td><input class="button" type="submit" value="Register"/></td>
                <td><input class=" button" type="reset" value="Reset"/></td>
            </tr>
            </table>
        </form>
       
        </div>
    </body>
</html>
