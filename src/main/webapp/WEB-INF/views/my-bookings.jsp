<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<% String flash = (String) session.getAttribute("flash"); session.removeAttribute("flash"); request.setAttribute("flash", flash); %>
<html><head>
<!-- Booking history table: status, fare, cancel action --><title>My Bookings</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="passenger-sidebar.jsp"><jsp:param name="title" value="My Bookings"/></jsp:include>
<c:if test="${not empty flash}"><div class="alert alert-success">${flash}</div></c:if>
<div class="card">
<h2>My Bookings</h2>
<div class="table-wrap">
<table><thead><tr><th>Pickup</th><th>Drop</th><th>Driver</th><th>Fare</th><th>Status</th><th></th></tr></thead>
<tbody>
<c:forEach var="b" items="${bookings}">
<tr>
<td>${b.pickup}</td><td>${b.drop}</td>
<td>${b.driverName}</td><td>$${b.fare}</td>
<td><span class="badge ${b.status == 'COMPLETED' ? 'badge-success' : b.status == 'CANCELLED' ? 'badge-danger' : b.status == 'IN_PROGRESS' ? 'badge-info' : b.status == 'CONFIRMED' ? 'badge-info' : 'badge-warning'}">${b.status}</span></td>
<td>
<c:if test="${b.status != 'COMPLETED' && b.status != 'CANCELLED'}">
<form method="post" action="/bookings/cancel/${b.bookingId}" style="display:inline"><button type="submit" class="btn btn-danger btn-sm" data-confirm="Cancel this booking?">Cancel</button></form>
</c:if>
<c:if test="${b.status == 'COMPLETED'}"><span style="color:var(--success);font-weight:600;">✓ Ride Complete</span></c:if>
</td></tr>
</c:forEach>
<c:if test="${empty bookings}"><tr><td colspan="6" style="text-align:center;padding:24px;color:var(--muted);">No bookings yet.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>