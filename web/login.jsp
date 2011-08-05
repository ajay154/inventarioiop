<%@ taglib uri="http://struts.apache.org/tags-html"
    prefix="html" %>
<html lang="en">
<HEAD>
    <title> 
            Login
    </title>
    <link rel="stylesheet" type="text/css" href="hstyle.css" >
    <style>
    body { 
        background: #52A1CC;
    }        
    .bgmain {
        background-image: url("images/cct_backg.gif");
        background-repeat: repeat-x
    }
    </style> 
</HEAD>    

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
    
<table border=0 cellpadding=8 cellspacing=0 width=960 bgcolor="#d6dbdd" align="center">    
<tr><td>
    <table border="0" cellspacing="0" cellpadding="0" align="center" width=944 class="bgmain">
    <tr height="256px">
        <td width="185"><IMG SRC="images/trans.gif" WIDTH="14" HEIGHT="1" BORDER="0" ALT=""></td>
        <td colspan=2 valign=top>
            
 
 
 

<table border="0" cellspacing="0" cellpadding="0" align="right" width=162>
<tr><td height="25" colspan=2></td></tr>
<tr><td valign="top" width=137>
        
            <a href="http://www.facusa.com.pe/" target=_blank><img src='images/logo1_la.gif' BORDER="0" ALT=""></a>
        
        
    </td>
    <td width=25></td>
</tr>       
</table>        
        </td>
    </tr>
    <tr height="417px">
        <td width=185></td>
        <td valign=top align="center">
            

   

<style>
    .bglogin{
        background-image: url("images/cct_back1.gif");        
    }
</style>
<script>
function showTxtBox(divhide,divshow,objtxtbox) {
    document.getElementById('tpass1').value='Password';
    document.getElementById(divhide).style.display='none';
    document.getElementById(divshow).style.display='inline';

    if (objtxtbox!='tpass1'){
        document.getElementsByName(objtxtbox)[0].value='';
        document.getElementsByName(objtxtbox)[0].focus();
        }
}    
</script>

<html:form action="/Login.do" method="post">
<input type="hidden" name="method" value="login">
<table border=0 cellpadding=0 cellspacing=0 width=574>
<tr><td width=220 valign=top><img src="images/cct_title.gif"></td>
    <td width=354 valign=top class="bglogin">
        <table border=0 cellpadding=0 cellspacing=0 width=351>        
        <tr><td height=83></td>
            <td colspan=3 height=83 valign=bottom>
            <img src="images/la_user.gif"><br>
            <br>
        </td></tr>
        <tr><td width=66></td>
            <td width=130 valign="top"><input type="text" name="bean.login" maxlength="60" value="UserID" onclick="if (this.value=='UserID') {this.value='';this.focus();}" onblur="if (this.value=='') {this.value='UserID'}" onfocus="if (this.value=='UserID') {this.value=''}" style="width:130px" class="inputtxt"><br></td>
            <td width=105 class="whitetxt1"><br></td>
            <td width="50"></td>
        </tr>
        <tr><td colspan=4 height=9></td></tr>
        <tr><td width=66></td>            
            <td width=130 valign="top">
                
                <div id="pass1"><input type=text name="tpass1" 
                value="Password" style="width:128px" id="tpass1"
                onclick="showTxtBox('pass1','pass2','bean.password');" 
                onfocus="showTxtBox('pass1','pass2','bean.password');" 
                onblur="showTxtBox('pass1','pass2','bean.password');" class="inputtxt" style="width:130px"
                ></div>
                <div id="pass2" style="display:none">
                    <input type="password" name="bean.password" maxlength="" value="" onblur="if (this.value=='') {showTxtBox('pass2','pass1','tpass1');};" style="width:130px" class="inputtxt">
                        </div>
            </td>
            <td width=85 align=center><input type="image" name="btnSubmit" src="images/bot_signin.gif" onclick="document.getElementsByName('method')[0].value='login'"><br>
           </td>
            <td></td>
        </tr>
        <tr><td colspan=4 height=13 align=right></td></tr>
        <tr><td colspan=4 height=18 align=center>
            
            
                
            
        </td></tr>
        <tr><td bgcolor="9ecde5" width=66 height=22></td>
            <td bgcolor="9ecde5" colspan=2 class="graytxt4"><!--<img src="images/cct_bullet.gif" hspace=4><a href="#">Forgot your password?</a><br>!--></td>
            <td bgcolor="9ecde5"></td>            
        </tr>        
        </table>
    </td>
</tr>
</table>           
</html:form>

        
        </td>
        <td width=185></td>
    </tr>
    </table>
</td></tr>
<tr><td>
    <table border=0 cellpadding=0 cellspacing=0 width="100%" align="center">
    <tr><td valign="top">
    

<table border="0" cellspacing="0" cellpadding="0" width="944">
<tr>
    <td WIDTH="640" class="graytxt2">Copyright 2011 &copy; <B>Facusa.</B> All rights reserved<!--&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Privacy Policy</a>&nbsp;!--></td>
    <td class="graytxt2" width=335 align=right>&nbsp;
            <!--&nbsp;<a href="#">FAQ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Contact Us</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;
            &nbsp;<a href="#">Site Map</a><br>!-->
    </td>
</tr>
<tr><td colspan=2 height=5></td></tr>
</table>

    </td>
    </tr>
    </table>
    
</td></tr>
</table>
</body>
    
</html>
