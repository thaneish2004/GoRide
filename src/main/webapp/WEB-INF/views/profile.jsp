<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Profile editor: name/phone/passenger-type/card details --><title>Profile</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="passenger-sidebar.jsp"><jsp:param name="title" value="Profile"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<c:if test="${not empty profile}">
<form method="post" action="/profile/edit">
<div class="form-group"><label>Name</label><input type="text" name="name" value="${profile.name}"/></div>
<div class="form-group"><label>Email</label><input type="email" value="${profile.email}" disabled style="background:var(--surface-soft);color:var(--muted);"/></div>
<div class="form-group"><label>Phone</label><input type="text" name="phone" value="${profile.phone}"/></div>
<div class="form-group"><label>Passenger Type</label>
<select name="passengerType">
<option value="REGULAR" ${profile.passengerType == 'REGULAR' ? 'selected' : ''}>Regular</option>
<option value="VIP" ${profile.passengerType == 'VIP' ? 'selected' : ''}>VIP</option>
</select></div>
<div class="form-group"><label>Card Number</label><input type="text" name="cardNumber" value="${profile.cardNumber}"/></div>
<div class="form-group"><label>Card Expiry</label><input type="text" name="cardExpiry" value="${profile.cardExpiry}" placeholder="MM/YY"/></div>
<div class="form-actions"><button type="submit" class="btn btn-primary">Save Changes</button> <a href="/home" class="btn btn-outline">Cancel</a></div>
</form>
</c:if>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>