<html>
<head><title>Login Page</title></head>
<body onload='document.f.username.focus();'>
<p style='color:red;'>Your login attempt was not successful, try again.<br /><br />Reason: Bad credentials</p>
<h3>Login with Username and Password</h3>
<form name='f' action='/dubboweb/login' method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
        </tr>
        <input name="_csrf" type="hidden" value="d7585288-8285-4faa-ab55-b539e40e4c24" />
    </table>
</form>
</body>
</html>