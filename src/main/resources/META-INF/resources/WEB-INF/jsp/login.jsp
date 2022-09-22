<html>
    <head>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
        <title>Login Page</title>
    </head>
    <body>
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