<#setting url_escaping_charset='ISO-8859-1'>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <LINK href="${context_path}/css/main.css" rel="stylesheet" type="text/css"/>
    <script src="${context_path}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <title>ActiveWeb - <@yield to="title"/></title>
    <@aw_script debug=true/>
</head>
<body>

<div class="main">
<#include "header.ftl" >
        ${page_content}        
<#include "footer.ftl" >
</div>

</body>

</html>
