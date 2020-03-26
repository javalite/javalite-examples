<!-- Jumbotron -->
<div class="jumbotron">
    <h1>ActiveWeb Secure site</h1>
    <p class="lead">This is an example of an ActiveWeb site where some pages are public, and some require login</p>
    <p>
    <@link_to controller="public" class="btn btn-lg btn-success" role="button">This is a public page</@link_to>
    <@link_to controller="secure" class="btn btn-lg btn-danger" role="button">This is a private page</@link_to>
    </p>
</div>
