<h2>Paging example</h2>
<@form action="create-people" method="post">
<input type="submit" value="Create people"> (only do this once)
</@form>

<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
    </tr>
<#list people as person>
    <tr>
        <td>${person.first_name}</td>
        <td>${person.last_name}</td>
    </tr>
</#list>
</table>


<#if (prev_index > 0) >
    <@link_to query_string="page=" + prev_index >Previous</@link_to>
<#else>
Previous
</#if>
|
<#if (next_index > 0) >
    <@link_to query_string="page=" + next_index >Next</@link_to>
<#else>
Next
</#if>
