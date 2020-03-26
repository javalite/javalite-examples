<#macro header sorted_by millis>

<th <#if request.s == sorted_by >
        style="background-color: lightgreen"
</#if>>
    <@link_to query_string="s=${sorted_by}">${sorted_by}
        <#if millis >
            (ms)
        </#if>
    </@link_to>
</th>
</#macro>

<table>
    <tr>
        <th>Query</th>
    <@header "avg", true/>
    <@header "min", true/>
    <@header "max", true/>
    <@header "total", true/>
    <@header "count", false/>

    </tr>

<#list stats as stat>
    <tr>
        <td>${stat.query}</td>
        <td>${stat.avg}</td>
        <td>${stat.min}</td>
        <td>${stat.max}</td>
        <td>${stat.total}</td>
        <td>${stat.count}</td>

    </tr>
</#list>
</table>
