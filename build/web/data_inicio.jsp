<%@ taglib uri="http://struts.apache.org/tags-html"
           prefix="html" %>
<HEAD>
    <title> 
        Data
    </title>
    <link rel="stylesheet" type="text/css" href="style.css" >
    <style>
        body { 
            background: #52A1CC;
        }        
        .bgmain {
            background-image: url("images/cct_back2.gif");
            background-repeat: repeat-x
        }
    </style>    
</HEAD>    

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
    
    <table border=0 cellpadding=8 cellspacing=0 width=960 bgcolor="#d6dbdd" align="center">    
        <tr><td>
                <table border="0" cellspacing="0" cellpadding="0" align="center" width=944>
                    <tr height="106">        
                        <td colspan=3 valign=top>
                            
                            
                            <table border="0" cellspacing="0" cellpadding="0" align="center" width=944>
                                <tr><td width=218 rowspan=2>
                                        <a href="<%=request.getContextPath()%>/Info.do"><img src='images/cct_title1.gif' BORDER="0" ALT=""></a><br>
                                    </td>
                                    <td width=708 height=18 bgcolor=ffffff></td>
                                    <td width=18 rowspan=2 bgcolor=ffffff></td>
                                </tr>
                                <tr><td width=708 height=88 align=right bgcolor=ffffff valign=top>
                                        
                                        <a href="http://www.loc-aid.net" target=_blank><img src='images/logo2_la.gif' BORDER="0" ALT=""></a><br>
                                        
                                        
                                    </td>
                                </tr>
                            </table>
                            
                        </td>
                    </tr>
                    <tr height="28">
                        <td colspan=3>
                            
                            <table border="0" cellspacing="0" cellpadding="0" align="center" width=944 bgcolor="E4F0F8">
                                <tr>
                                    <td width="18px">&nbsp;</td>
                                    <td height="28px">
                                                                                
                                        <a href="<%=request.getContextPath()%>/Info.do"><img src="images/m2_phone.gif" border="0" alt=""></a>
                                        &nbsp;<img src="images/m_space.gif" border="0" alt="">&nbsp;
                                        
                                        <a href="<%=request.getContextPath()%>/Solver.do"><img src="images/m1_cust.gif" border="0" alt=""></a>
                                        &nbsp;<img src="images/m_space.gif" border="0" alt="">&nbsp;
                                        
                                        <a href="<%=request.getContextPath()%>/Data.do"><img src="images/m9x_report.gif" border="0" alt=""></a>
                                        
                                    </td>
                                </tr>
                            </table>
                            
                        </td>
                    </tr>    
                    <tr class="bgmain" bgcolor=ffffff>
                        <td width=18></td>
                        <td valign=top align="center" valign=top width=908>          
                            <table border="0" cellspacing="0" cellpadding="0" height=300>
                                <tr><td valign=top>
                                        
                                        <style type="text/css">
                                            .reportmain{
                                                background-image: url("images/r_back1.gif");
                                                background-repeat: repeat-x
                                            }
                                            .reportmain_2{
                                                background-image: url("images/r_imag.gif");
                                                background-repeat: repeat-x
                                            }
                                        </style>
                                        
                                        <table border="0" cellspacing="0" cellpadding="0" align="center" width=908>
                                            <tr><td colspan=2 height=10></td></tr>
                                            <tr><td align="left" width=550 height=23>
                                                    <!-- setting paths for all options -->
        
                                                    <font class=txtpath>
                                                        <html:link action="/Info.do">Home</html:link> > Data<br>
                                                    </font>
                                                    <!--  -->
                                                </td>                    
                                                <td class="graytxt512" width=350 align="right">
                                                    <!-- user session menu -->            
                                                    Signed in   <b>${sessionScope["SessionUsuario"].nombre}</b> as Commercial | <html:link action="/Login.do">Sign out</html:link><br>
                                                    <!-- user session menu -->  
                                                </td>
                                            </tr>
                                        </table>  
                                        
                                        
                                        
                                        <table border="0" cellspacing="0" cellpadding="0" width="913" >
                                            <tr><td>
                                                    <table border="0" cellspacing="0" cellpadding="0" width="460" height="215" class="reportmain">
                                                        <tr><td>
                                                                <table border="0" cellspacing="0" cellpadding="0" width="146" height="215">
                                                                    <tr height="22"><td></td></tr>
                                                                    <tr><td align="center" valign="top">
                                                                            <img src="images/r_titulo2.gif" border="0" alt="">
                                                                    </td></tr>
                                                                </table>
                                                            </td>
                                                            <td>
                                                                <table border="0" cellspacing="0" cellpadding="0" width="314">
                                                                    
                                                                    
                                                                    <tr height="32"><td align="center" >
                                                                            <html:link action="/Data.do?method=configurar&tipo=mineria"><img src="images/rep_trx.gif" name="repOption1" height="100%" border="0" alt="" onmouseover="document.repOption1.src='images/rep_trx2.gif'" onmouseout="document.repOption1.src='images/rep_trx.gif'"></html:link>
                                                                   </td></tr>
                                                                    
                                                                    <tr height="9"><td></td></tr>
                                                                    
                                                                     <tr height="32"><td align="center" >
                                                                            <html:link action="/Data.do?method=configurar&tipo=energia"><img src="images/rep_end.gif" name="repOption3" height="100%" border="0" alt="" onmouseover="document.repOption3.src='images/rep_end2.gif'" onmouseout="document.repOption3.src='images/rep_end.gif'"></html:link>
                                                                    </td></tr>
                                                                    
                                                                    <tr height="9"><td></td></tr>
                                                                    
                                                                    
                                                                    <tr height="32"><td align="center" >
                                                                            <html:link action="/Data.do?method=configurar&tipo=alimentos"><img src="images/rep_cus.gif" name="repOption4" height="100%" border="0" alt="" onmouseover="document.repOption4.src='images/rep_cus2.gif'" onmouseout="document.repOption4.src='images/rep_cus.gif'"></html:link>
                                                                    </td></tr>
                                                                    
                                                                    <tr height="9"><td></td></tr>
                                                                    
                                                                    <tr height="32"><td align="center" >
                                                                            <html:link action="/Data.do?method=configurar&tipo=plasticos"><img src="images/rep_app.gif" name="repOption2" height="100%" border="0" alt="" onmouseover="document.repOption2.src='images/rep_app2.gif'" onmouseout="document.repOption2.src='images/rep_app.gif'"></html:link>
                                                                    </td></tr>
                                                                    
                                                                    
                                                                </table>
                                                        </td></tr>
                                                    </table>
                                                </td><td>
                                                    <table border="0" cellspacing="0" cellpadding="0" width="453" height="215" class="reportmain_2">
                                                        <tr><td></td></tr>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>
                                        
                                        
                                </td></tr>
                            </table>
                        </td>
                        <td width=18></td>
                    </tr>
                    <tr><td colspan=3 height=100 bgcolor=ffffff>&nbsp;</td></tr>
                </table>
        </td></tr>
        <tr><td bgcolor=d6dbdd>
                <table border=0 cellpadding=0 cellspacing=0 width="944" align="center">
                    <tr><td valign="top">
                            
                            
                            
                            
                            <table border="0" cellspacing="0" cellpadding="0" width="944">
                                <tr>
                                    <td WIDTH="640" class="graytxt2">Copyright 2009 &copy; <B>LOC-AID.</B> All rights reserved<!--&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Privacy Policy</a>&nbsp;!--></td>    
                                    <td class="graytxt2" width=335 align=right>
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