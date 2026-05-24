<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Add Vehicle</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="driver-sidebar.jsp"><jsp:param name="title" value="Add Vehicle"/></jsp:include>
<c:if test="${not empty error}"><div class="alert alert-error">${error}</div></c:if>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<form method="post" action="/vehicle/add">
<div class="form-group"><label>Make</label><input type="text" name="make" required/></div>
<div class="form-group"><label>Model</label><input type="text" name="model" required/></div>
<div class="form-group"><label>Year</label><input type="number" name="year" required/></div>
<div class="form-group"><label>Plate</label><input type="text" name="plateNumber" required/></div>
<div class="form-group"><label>Type</label>
<select name="type"><option value="SEDAN">Sedan</option><option value="SUV">SUV</option><option value="VAN">Van</option><option value="LUXURY">Luxury</option></select></div>
<div class="form-actions"><button type="submit" class="btn btn-success">Add Vehicle</button> <a href="/fleet" class="btn btn-outline">Cancel</a></div>
</form>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>