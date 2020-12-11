<%
    
// steps to read a cookies 
    String v1="",v2="";
    //two steps for reading cookies
    //step 1- fetch all the cookies coming along with request
    Cookie ck[]=request.getCookies();
    // seach for desired one 
    if(ck!=null){
        for(int i=0;i<ck.length;i++){
            String name =ck[i].getName();
            if(name.equals("id")){
                v1=ck[i].getValue();
            }else if(name.equals("pw")){
            v2=ck[i].getValue();
            }
            
        }
    }
%>

<html>
    <head>
        <link rel="stylesheet" href="loginStyle.css">
        <style>
            body{
                background-image: url(loginBck.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                
            }
        </style>
    </head>
      
    <body>
        <i>    <h1 class="sub1">Apna Sweets</h1></i>
   
    </i>            <form class="login" action="CustomerLoginverification"method="post">
    <table>
        <div  class="sub1">        <tr><td><h1 class="sub2">Login</h1></td></tr>
        </div>
      <div class="textbox">

          <td><h1 class="em">Email</h1></td><td><input class="email" placeholder="Email" name="email" value="<%=v1%>"/>   </td></tr>          

      
      </div> <div class="textbox">
              <td><h1 class="ps">Password </h1></td><td><input class="pass" type="password" name="password" value="<%=v2%>"/>             
      </div>
      
          </td>      </tr> 
<td><h3 class="sv">Save</h3></td><td><input  class="chk"type="checkbox" name="c1" value="yes" checked="checked"></td>
                
            </tr>
          <tr>
              <td><input  class="bt1" type="submit" value="Login"/></td>
              <td><input class="bt2" type="reset" value="Reset"/></td>

          </tr>
    </table></form>
    </body>
</html>
