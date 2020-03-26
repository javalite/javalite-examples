<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">ActiveWeb</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <#if (session.user) ??>
                    <li><a href="javascript:void(0);" ">Logged in as: ${session.user}</a></li>
                    <li><@link_to controller="login" action="logout">Logout</@></li>
                <#else>
                    <li><@link_to controller="login" >Login</@></li>
                </#if>

            </ul>
        </div>
    </div>
</div>


