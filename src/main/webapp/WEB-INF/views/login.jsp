<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Login</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"></head><body>
<div class="auth-page">
<div class="auth-card">
<h1>Sign In</h1>
<c:if test="${not empty error}"><div class="alert alert-error">${error}</div></c:if>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<form method="post" action="/login">
<div class="form-group"><label>Email</label><input type="email" name="email" required placeholder="you@example.com"/></div>
<div class="form-group"><label>Password</label><input type="password" name="password" required placeholder="********"/></div>
<div class="form-group"><label>Login as</label>
<select name="userType">
<option value="PASSENGER">Passenger</option>
<option value="DRIVER">Driver</option>
<option value="ADMIN">Admin</option>
</select>
</div>
<button type="submit" class="btn btn-primary" style="width:100%;justify-content:center;">Sign In</button>
</form>
<div class="auth-footer">Don't have an account? <a href="/register">Register</a></div>
</div>
</div>
<script src="/js/app.js"></script>
</body></html>
