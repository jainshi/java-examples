<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form method="POST" action="<c:url value="/j_spring_security_check" />">
		<table>
			<tr>
				<td align="right">Username</td>
				<td>
					<input type="text" name="j_username" />
				</td>
			</tr>
			<tr>
				<td align="right">Password</td>
				<td>
					<input type="password" name="j_password" />
				</td>
			</tr>
			<tr>
				<td align="right">Remember me</td>
				<td>
					<input type="checkbox" name="_spring_security_remember_me" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="Login" /> 
					<input type="reset" value="Reset" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>