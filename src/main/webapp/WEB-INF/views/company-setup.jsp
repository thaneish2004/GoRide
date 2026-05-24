<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Company profile: name/email/phone/address form --><title>Company Setup</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="driver-sidebar.jsp"><jsp:param name="title" value="Company Setup"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<form method="post" action="/company/setup">
<div class="form-group"><label>Company Name</label><input type="text" name="name" value="${company.name}" required/></div>
<div class="form-group"><label>Email</label><input type="email" name="email" value="${company.email}" required/></div>
<div class="form-group"><label>Phone</label><input type="text" name="phone" value="${company.phone}" required/></div>
<div class="form-group"><label>Address</label><input type="text" name="address" value="${company.address}"/></div>
<div class="form-actions"><button type="submit" class="btn btn-primary">Save Company</button></div>
</form>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>