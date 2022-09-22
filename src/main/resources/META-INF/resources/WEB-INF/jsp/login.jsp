<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Login Page</title>
    </head>
    <body>

    <nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
    	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28minutes</a>
    </nav>

    <div class="container">


        <h1>Welcome to login page</h1>
        <hr>
            <form method="post">
                Name: <input type="text" name="name">
                Password: <input type="password" name="password">
                <input type="submit">
            </form>
        <pre>${errorMessage}</pre>
        </div>
    </body>
</html>