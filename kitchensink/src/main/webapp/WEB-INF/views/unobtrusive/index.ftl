<@content for="title">JavaLite - Unobtrusive</@content>
<br/>
<h1>Form:</h1>
<form id="form1" action="blah" method="get">
    First name: <input type="text" name="first_name" value="${first_name!}"><br/><br/>
    Last name: <input type="text" name="last_name" value="${last_name!}">
</form>
<br/>
<h1>Simple links</h1>
<@link_to controller="unobtrusive" action="do-simple-get" before="getFormData" before_arg="form1">Get</@>
<br/>
<@link_to controller="unobtrusive" action="do-simple-get" form="form1">Get (with the form)</@>
<br/>
<@link_to controller="unobtrusive" method="post" action="do-simple-post" before="getFormData" before_arg="form1">Post</@>
<br/>
<@link_to controller="unobtrusive" method="put" action="do-simple-put" before="getFormData" before_arg="form1">Put</@>
<br/>
<@link_to controller="unobtrusive" method="delete" action="do-simple-delete" before="getFormData" before_arg="form1">Delete</@>
<br/>
<div id="result" style="margin:20px;font-size:large;background-color:#f5f5f5;">${result!"result will be here"}</div>
<h1>Ajax links:</h1>
<@link_to controller="unobtrusive" action="do-get" form="form1" destination="result1">Ajax Get</@>
<br/>
<@link_to controller="unobtrusive" action="do-post" form="form1" destination="result1" method="post">Ajax Post</@>
<br/>
<@link_to controller="unobtrusive" action="do-put" form="form1" destination="result1" method="put">Ajax Put</@>
<br/>
<@link_to controller="unobtrusive" action="do-delete" form="form1" destination="result1" method="delete">Ajax Delete</@>

<div id="result1" style="margin:20px;font-size:large;background-color:#f5f5f5;">result will be here</div>

<h1>Links with JS callbacks</h1>

<@link_to controller="unobtrusive" action="do-get" form="form1"  before="doBeforeWithArg" before_arg="callbacks_result"
                                after="doAfterWithArg" after_arg="callbacks_result">Callbacks Get</@>
<br/>
<@link_to controller="unobtrusive" action="do-post" form="form1"  method="post" before="doBefore" after="doAfter" >Callbacks Post</@>
<br/>
<@link_to controller="unobtrusive" action="do-put" form="form1"  method="put" before="doBefore" after="doAfter">Callbacks Put</@>
<br/>
<@link_to controller="unobtrusive" action="do-delete" form="form1"  method="delete" before="doBefore" after="doAfter" confirm="are you really sure???">Callbacks Delete</@> - uses confirmation 


<br/>
<@link_to controller="unobtrusive" action="doesnotexist" error="onError" destination="callbacks_result">Will cause error</@>


<div id="callbacks_result" style="margin:20px;font-size:large;background-color:#f5f5f5;">Result  Here</div>

<script type="text/javascript">

    function onError(status, responseText){
        alert("Got error, status: " + status + ", Response: " + responseText);
    }

    function getFormData(formId) {
        let form = document.getElementById(formId);
        let result = {}
        for([key, val] of new FormData(form).entries()) {
            result[key] = val;
        }
        return result;
    }

    function doBeforeWithArg(elm){
        $("#" + elm).html("wait...");
    }

    function doAfterWithArg(elm, data){
        $("#" + elm).html(data);
    }

    function doBefore(arg){
        $('#callbacks_result').html("wait...");
    }
    function doAfter(arg, data){
        $('#callbacks_result').html(data);
    }
</script>

