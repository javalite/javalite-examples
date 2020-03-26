<@content for="title">Upload</@content>


<h2>Upload page</h2>



<#if (flasher.messages)??>

    <div style="background-color:#ffffe0;margin:20px>">
        <code>
            <ul>
                <#list flasher.messages as message>

                    <li>${message}</li>
                </#list>
            </ul>
        </code>

    </div>
</#if>
<@form controller="upload" action="save" method="post" enctype="multipart/form-data">
    Select a file to upload:<input type="file" name="file">

<input name="book" value="The Great Gatsby" type="text">
    <button>Upload File</button>
</@>
