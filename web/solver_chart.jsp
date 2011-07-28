<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<link rel="stylesheet" href="modal-message.css" type="text/css">

<style>
.bgmaintable2 {
background-image: url("<html:rewrite page='/images/v_back1.gif'/>");
background-repeat: repeat-x
}
</style> 
<table border="0" cellspacing="0" cellpadding="0" WIDTH="735" class="bgmaintable2" bgcolor=F0EFED height=726>
<tr><td colspan=3 valign=top>
        <table border=0 cellpadding=0 cellspacing=0 width=735>
        <tr><td width=674 valign=top><img src="images/v_top2.gif" width=674></td>
            <td width=61 valign=top><a href="javascript:closeMessage()"><img src="images/v_close.gif" width=61></a></td>
        </tr>
        </table>
    </td>
</tr>
<tr><td width=34></td>
    <td width=667 valign=top bgcolor=F0EFED><br>
        <html:img action="/Solver.do?method=zoomchart&width=650&height=670" alt="No Data"/><br>
    </td>
    <td width=34></td>
</tr>
<tr><td colspan=3 height=10></td></tr>
<tr><td></td>
    <td valign=top align=center>
    </td>
    <td></td>
</tr>
</table>  