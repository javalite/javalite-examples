<@content for="title">Public page</@content>

<div class="row">

<#if (flasher.message) ??>
    <div class="alert alert-danger" role="alert">
        <@flash name="message"/>
    </div>
</#if>

    <div class="col-lg-4">
        <h2>Login:</h2>
    </div>
</div>

<div class="col-lg-4">
<@form action="login" method="post">
<form role="form">
    <div class="form-group">
        <label for="exampleInputEmail1">Email:</label>
        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email" name="email">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</@form>

</div>



