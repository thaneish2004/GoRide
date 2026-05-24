<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Driver dashboard: task/vehicle stats and quick links --><title>Driver Dashboard</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="driver-sidebar.jsp"><jsp:param name="title" value="Dashboard"/></jsp:include>
<p style="color:var(--muted);margin-bottom:24px;">Manage your tasks and fleet</p>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="stats">
<a href="/tasks" class="stat-card" style="text-decoration:none;"><div class="stat-number">${pendingCount}</div><div class="stat-label">Available Tasks</div></a>
<a href="/tasks" class="stat-card" style="text-decoration:none;"><div class="stat-number">${myTaskCount}</div><div class="stat-label">Active Tasks</div></a>
<a href="/fleet" class="stat-card" style="text-decoration:none;"><div class="stat-number">${vehicleCount}</div><div class="stat-label">My Vehicles</div></a>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>