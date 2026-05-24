<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Registration form: name/email/phone/password/user-type --><title>Register</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"></head><body>
<div class="auth-page">
<div class="auth-card">
<h1>Create Account</h1>
<c:if test="${not empty error}"><div class="alert alert-error">${error}</div></c:if>
<form method="post" action="/register">
<div class="form-group"><label>Full Name</label><input type="text" name="name" required placeholder="John Doe"/></div>
<div class="form-group"><label>Email</label><input type="email" name="email" required placeholder="you@example.com"/></div>
<div class="form-row">
<div class="form-group"><label>Phone</label><input type="text" name="phone" required placeholder="555-0000"/></div>
<div class="form-group"><label>User Type</label><select name="userType"><option value="PASSENGER">Passenger</option><option value="DRIVER">Driver</option></select></div>
</div>
<div class="form-group"><label>Password</label><input type="password" name="password" required placeholder="********"/></div>
<button type="submit" class="btn btn-primary" style="width:100%;justify-content:center;">Create Account</button>
</form>
<div class="auth-footer">Already have an account? <a href="/login">Sign In</a></div>
</div>
</div>
<script src="/js/app.js"></script>
</body></html>
