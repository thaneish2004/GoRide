<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Admin dashboard: passenger/driver/booking/vehicle counts --><title>Admin Dashboard</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="admin-sidebar.jsp"><jsp:param name="title" value="Dashboard"/></jsp:include>
<div class="stats">
<div class="stat-card"><div class="stat-number">${userCount}</div><div class="stat-label">Passengers</div></div>
<div class="stat-card"><div class="stat-number">${driverCount}</div><div class="stat-label">Drivers</div></div>
<div class="stat-card"><div class="stat-number">${bookingCount}</div><div class="stat-label">Bookings</div></div>
<div class="stat-card"><div class="stat-number">${vehicleCount}</div><div class="stat-label">Vehicles</div></div>
</div>
<div class="card"><p>Welcome to the admin panel. Use the sidebar to manage passengers, drivers, bookings, and vehicles.</p></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
