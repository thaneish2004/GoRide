<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Payment</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="passenger-sidebar.jsp"><jsp:param name="title" value="Payment"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<form method="post" action="/payment">
<div class="form-group"><label>Card Number</label><input type="text" name="cardNumber" value="${profile.cardNumber}" placeholder="4111 1111 1111 1111"/></div>
<div class="form-group"><label>Expiry (MM/YY)</label><input type="text" name="cardExpiry" value="${profile.cardExpiry}" placeholder="12/28"/></div>
<div class="form-actions"><button type="submit" class="btn btn-primary">Save</button> <a href="/profile" class="btn btn-outline">Back</a></div>
</form>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>