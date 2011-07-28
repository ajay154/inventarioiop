<%@ taglib uri="http://struts.apache.org/tags-html"
    prefix="html" %>
<HEAD>
    <title> 
        Information
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
                                        
                                        <a href="<%=request.getContextPath()%>/Info.do"><img src="images/m2x_phone.gif" border="0" alt=""></a>
                                        &nbsp;<img src="images/m_space.gif" border="0" alt="">&nbsp;
                                        
                                        <a href="<%=request.getContextPath()%>/Solver.do"><img src="images/m1_cust.gif" border="0" alt=""></a>
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
                                                        
                                                        <html:link action="/Info.do">Home</html:link> > Information<br>
                                                        
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
                                        
                                        
                                        <!-- informacion de recursos-->
                                        <html:form action="/Info.do" method="post">
                                           <input type="hidden" name="method" value="">
                                            
                                            <table border="0" cellspacing="0" cellpadding="0" width="908" >
                                                <tr><td width=535 height=23></td></tr>
                                                <tr><td width=535 height=23><img src='images/rtit_summary.gif'><br></td></tr>
                                                <tr><td width=535 align="left">
                                                    <table border=0 cellpadding=0 cellspacing=0 width=535>
                                                        <tr><td width=535 bgcolor=a8cfe4>
                                                                <!-- information table -->
                                                                
                                                                <table class="displaytag" style="width:535px" cellspacing="1" id="rpt">
                                                                    <thead>
                                                                        <tr>
                                                                        <th>Sector industrial</th>
                                                                        <th>Empresa</th>
                                                                        <th>Rendimiento de Inversión en acciones tipo Alto</th>
                                                                        <th>Rendimiento de Inversión en acciones tipo Bajo</th>
                                                                    </thead>
                                                                    <tbody>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Mineria
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Yanacocha</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[0].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[0].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Barrick</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[1].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[1].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Comarsa</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[2].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[2].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Minsur</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[3].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[3].rendimientoB}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Energia
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edegel</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[0].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[0].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Tecsur</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[1].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[1].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edecanete</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[2].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[2].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edenor</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[3].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[3].rendimientoB}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Alimentos
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Alicorp</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[0].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[0].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Sayon</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[1].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[1].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Molitalia</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[2].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[2].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Donofrio</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[3].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[3].rendimientoB}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Plasticos
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Amanco</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[0].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[0].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Nicoll</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[1].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[1].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Tuboplast</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[2].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[2].rendimientoB}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Marca</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[3].rendimientoA}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[3].rendimientoB}</td>
                                                                    </tr>
                                                                    
                                                                </table>
                                                                
                                                                
                                                        </td></tr>
                                                    </table>
                                                    
                                                    <!--<br><img src="images/v_darkgraytop537.gif"><br>
                                                    <table border=0 cellpadding=0 cellspacing=0 width=537 bgcolor=cccccc>
                                                        <td width="470px">&nbsp;</td>
                                                        <td width="101"  style=""align="left"></td>
                                                        <td width="101"  style=""align="left"><input type="image" name="" src="images/bot_export.gif" onclick="document.getElementsByName('method')[0].value='save'"></td>
                                                    </table>
                                                    <img src="images/vdarkgray_bottom537.gif"><br>-->
                                                    <td width="50">&nbsp;</td>
                                                    <td align="right">
                                                        &nbsp;
                                                </td></tr>
                                            </table>
                                            
                                            
                                            <table border="0" cellspacing="0" cellpadding="0" width="908" >
                                                <tr><td width=535 height=23></td></tr>
                                                <tr><td width=535 height=23><img src='images/rtit_summary.gif'><br></td></tr>
                                                <tr><td width=535 align="left">
                                                    <table border=0 cellpadding=0 cellspacing=0 width=535>
                                                        <tr><td width=535 bgcolor=a8cfe4>
                                                                <!-- information table -->
                                                                
                                                                <table class="displaytag" style="width:535px" cellspacing="1" id="rpt">
                                                                    <thead>
                                                                        <tr>
                                                                        <th>Sector industrial</th>
                                                                        <th>Empresa</th>
                                                                        <th>Cantidad mínima a invertir</th>
                                                                        <th>Cantidad máxima a invertir</th>
                                                                    </thead>
                                                                    <tbody>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Mineria
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Yanacocha</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[0].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[0].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Barrick</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[1].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[1].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Comarsa</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[2].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[2].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="odd">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Minsur</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[3].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.mineria[3].cantMaxima}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Energia
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edegel</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[0].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[0].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Tecsur</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[1].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[1].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edecanete</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[2].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[2].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Edenor</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[3].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.energia[3].cantMaxima}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Alimentos
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Alicorp</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[0].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[0].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Sayon</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[1].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[1].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Molitalia</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[2].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[2].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Donofrio</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[3].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.alimentos[3].cantMaxima}</td>
                                                                    </tr>
                                                                    
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal;" rowspan=4>
                                                                            Plasticos
                                                                        </td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Amanco</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[0].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[0].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Nicoll</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[1].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[1].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Tuboplast</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[2].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[2].cantMaxima}</td>
                                                                    </tr>
                                                                    <tr class="even">
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">Marca</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[3].cantMinima}</td>
                                                                        <td style="width:100px; background-color:ffffff; color:333333; font-weight:normal; text-align: center;">${InfoForm.mapList.plasticos[3].cantMaxima}</td>
                                                                    </tr>
                                                                    
                                                                </table>
                                                                
                                                                
                                                        </td></tr>
                                                    </table>
                                                    
                                                    <!--<br><img src="images/v_darkgraytop537.gif"><br>
                                                    <table border=0 cellpadding=0 cellspacing=0 width=537 bgcolor=cccccc>
                                                        <td width="470px">&nbsp;</td>
                                                        <td width="101"  style=""align="left"></td>
                                                        <td width="101"  style=""align="left"><input type="image" name="" src="images/bot_export.gif" onclick="document.getElementsByName('method')[0].value='save'"></td>
                                                    </table>
                                                    <img src="images/vdarkgray_bottom537.gif"><br>-->
                                                    <td width="50">&nbsp;</td>
                                                    <td align="right">
                                                        &nbsp;
                                                </td></tr>
                                            </table>
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
