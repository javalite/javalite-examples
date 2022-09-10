<@content for="title">Websockets Web App</@content>

<h2>Websockets Example</h2>
<div id="chat"></div>
<input id="name" type="text" placeholder="name"/>
<input id="message" type="text" placeholder="message"/>
<button id="send">Send</button>


<@content for="js_include">
    <script type="application/javascript">

        $(document).ready(function() {

            const connection = new WebSocket("ws://localhost:8080/echo");

            connection.onopen = (event) => {
                console.log("WebSocket is open now.");
            };

            connection.onclose = (event) => {
                console.log("WebSocket is closed now.");
            };

            connection.onerror = (event) => {
                console.error("WebSocket error observed:", event);
            };

            connection.onmessage = (event) => {
                const chat = document.querySelector("#chat");
                chat.innerHTML += event.data;
            };

            $("#send").on('click', function (){

                var name = $("#name");
                var message = $("#message");
                connection.send(name.val()  + " " + message.val() );

                // clear input fields
                name.val("");
                message.val("");
            });
        });
    </script>
</@content>