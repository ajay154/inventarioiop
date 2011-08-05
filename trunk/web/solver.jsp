<%@ taglib uri="http://struts.apache.org/tags-html"
           prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic"
           prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<HEAD>
    <title> 
        Solution
    </title>
    <link rel="stylesheet" type="text/css" href="style.css" >
    
    <link rel="stylesheet" type="text/css" href="modal-message.css" >
    
    <script type="text/javascript" src="<html:rewrite page='/script/ajax.js'/>" ></script>
    <script type="text/javascript" src="<html:rewrite page='/script/modal-message.js'/>" ></script>
    <script type="text/javascript" src="<html:rewrite page='/script/ajax-dynamic-content.js'/>" ></script>
    <style type="text/css">
        .modalDialog_contentDiv_error{
            border:0px solid #d7d7d7;	
            padding:0px;
            z-index:100;/* Always needed	*/
            position:absolute;	/* Always needed	*/
            background-color:#d7d7d7;	/* White background color for the message */
            color:#d7d7d7;
        }
        .modalDialog_contentDiv_error a{
            color:#ffffff;
        }
    </style>
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
                                        <a href="http://www.facusa.com.pe/" target=_blank><img src='images/logo2_la.gif' BORDER="0" ALT=""></a><br>
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
                                        
                                        <a href="<%=request.getContextPath()%>/Solver.do"><img src="images/m1x_cust.gif" border="0" alt=""></a>
                                        &nbsp;<img src="images/m_space.gif" border="0" alt="">&nbsp;
                                        
                                        <a href="<%=request.getContextPath()%>/Data.do"><img src="images/m9_report.gif" border="0" alt=""></a>
                                        
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
                                            .search{
                                                background-image: url("images/cct_back3.gif");
                                                background-repeat:no-repeat;
                                            }
                                            .search td{
                                                font-family:Tahoma;
                                                font-size:11px;
                                                font-weight:bold;
                                            }
                                            .input_text{
                                                height:20px;
                                                width:116px;
                                                border-top: 1px solid #96969d;
                                                border-right: 1px solid #96969d;
                                                border-bottom: 1px solid #96969d;
                                                border-left: 1px solid #96969d;   
                                            }
                                        </style>
                                        <link rel="stylesheet" type="text/css" href="displayTagCenter.css" >
                                        
                                        <table border="0" cellspacing="0" cellpadding="0" align="center" width=908>
                                            <tr><td colspan=2 height=10></td></tr>
                                            <tr><td align="left" width=550 height=23>
                                                    <!-- setting paths for all options -->
        
                                                    <font class=txtpath>
                                                        
                                                        <html:link action="/Info.do">Home</html:link> > Solution<br>
                                                        
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
                                        
                                        
                                        <!-- Solver-->
                                        <html:form action="/Solver.do" method="post">
                                            <input type="hidden" name="method" value="">
                                            
                                            <table border="0" cellspacing="0" cellpadding="0" width="908" >
                                                <tr><td width=535 height=23></td></tr>
                                                <tr><td width=535 height=23>
                                                        <input type="image" name="" src="images/bot_submit.gif" onclick="document.getElementsByName('method')[0].value='solver'">
                                                </td></tr>
                                                <logic:equal name="SolverForm" property="readOnly" value="SOLVER">
                                                
                                                    <tr><td width=535 height=23></td></tr>
                                                    <tr><td width=535 height=23><img src='images/rtit_summary.gif'><br></td></tr>
                                                    <tr><td width=535 align="left">
                                                            
                                                            <table border=0 cellpadding=0 cellspacing=0 width=535>
                                                                <tr><td width=535 bgcolor=a8cfe4>
                                                                        <!-- information table -->
                                                    
                                                                        <table class="displaytag" style="width:900px" cellspacing="1" id="rpt">
                                                                            <thead>
                                                                                <tr>
                                                                                <th>Producto</th>
                                                                                <logic:iterate id="ped" name="vistaPedido">
                                                                                <th><bean:write name="ped" property="mes.nombre"/></th>    
                                                                                </logic:iterate>
                                                                            </thead>
                                                                            
                                                                                <logic:iterate id="vi" name="vista2">
                                                                                    <tbody>
                                                                                    <tr class="odd">
                                                                                            <td style="width:250px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                                                <bean:write name="vi" property="producto.descripcion"/>
                                                                                            </td>
                                                                                            <logic:iterate id="pe" name="vi" property="pedido">
                                                                                            <td style="width:80px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">
                                                                                                <bean:write name="pe" property="cantidad"/>
                                                                                            </td>
                                                                                            
                                                                                            </logic:iterate>    
                                                                                    </tr>
                                                                                </logic:iterate>
                                                                            </tbody>
                                                                        </table>
                                                                        
                                                                </td></tr>
                                                            </table>
                                                            <td width="50">&nbsp;</td>
                                                            <td align="right">
                                                                
                                                            </td>
                                                    </td></tr>
                                                    <tr>
                                                        <td>
                                                            <table border="0" cellspacing="5" cellpadding="0" width="908">
                                                                <tr>
                                                                    <td style="text-align: center;">
                                                                    <a href="javascript:displayMessage('<html:rewrite page="/solver_chart.jsp" />')"><html:img action="/Solver.do?method=chart" alt="No Data"/></a>
                                                                    </td>
                                                                </tr>
                                                            </table> 
                                                        </td>
                                                    </tr>
                                                </logic:equal>
                                            </table>
                                            </br>
                                           
                                                 
                                        </html:form>
                                        
                                   

               
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
                                    <td WIDTH="640" class="graytxt2">Copyright 2011 &copy; <B>Facusa.</B> All rights reserved<!--&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;<a href="#">Privacy Policy</a>&nbsp;!--></td>
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

<script type="text/javascript">
    messageObj = new DHTML_modalMessage();	// We only create one object of this class
    messageObj.setShadowOffset(5);	// Large shadow
    isCustomWindow=true;

    function displayMessage(url)
    {
        var random =  Math.round(Math.random() * 99999);
        //url = url + '&random=' + random;
        messageObj.setSource(url);
        messageObj.setCssClassMessageBox(false);
        messageObj.setSize(734,726);
        messageObj.setShadowDivVisible(true);	// Enable shadow for these boxes
        messageObj.display();
    }

    function closeMessage()
    {
        messageObj.close();	
    }

</script>