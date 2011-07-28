<%@ taglib uri="http://struts.apache.org/tags-html"
    prefix="html" %>
<body>    
<html:form action="/Login.do" method="post" >
    <input type=hidden name=test>
</html:form>
</body>
<script language="javascript">             
        document.forms[0].submit();
</script>