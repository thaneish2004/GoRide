<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Book a Ride</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="passenger-sidebar.jsp"><jsp:param name="title" value="Book a Ride"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<c:if test="${not empty error}"><div class="alert alert-error">${error}</div></c:if>
<div class="card">
<form method="post" action="/book">
<div class="form-group"><label>Pickup</label><input type="text" name="pickupLocation" required placeholder="123 Main St"/></div>
<div class="form-group"><label>Drop-off</label><input type="text" name="dropLocation" required placeholder="456 Oak Ave"/></div>
<div class="form-row">
<div class="form-group"><label>Vehicle Type</label>
<select name="vehicleType">
<option value="SEDAN">Sedan</option>
<option value="SUV">SUV</option>
<option value="VAN">Van</option>
<option value="LUXURY">Luxury</option>
</select></div>
</div>
<button type="submit" class="btn btn-primary" style="width:100%;justify-content:center;">Find My Ride</button>
</form>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>