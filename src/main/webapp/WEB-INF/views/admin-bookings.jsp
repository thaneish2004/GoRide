<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>All Bookings</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="admin-sidebar.jsp"><jsp:param name="title" value="Bookings"/></jsp:include>
<div class="card">
<div class="table-wrap">
<table><thead><tr><th>ID</th><th>Passenger</th><th>Driver</th><th>Pickup</th><th>Drop</th><th>Status</th><th>Fare</th><th>Action</th></tr></thead>
<tbody>
<c:forEach var="b" items="${bookings}">
<tr>
<td>${b.bookingId}</td><td>${b.passengerName}</td><td>${b.driverName}</td>
<td>${b.pickup}</td><td>${b.drop}</td>
<td><span class="badge ${b.status == 'COMPLETED' ? 'badge-success' : b.status == 'CANCELLED' ? 'badge-danger' : b.status == 'IN_PROGRESS' ? 'badge-warning' : 'badge-info'}">${b.status}</span></td>
<td>$${b.fare}</td>
<td>
<c:if test="${b.status != 'CANCELLED' && b.status != 'COMPLETED'}">
<form method="post" action="/admin/bookings/delete" style="display:inline">
<input type="hidden" name="id" value="${b.bookingId}"/>
<button type="submit" class="btn btn-danger btn-sm" data-confirm="Cancel this booking?">Cancel</button>
</form>
</c:if>
</td></tr>
</c:forEach>
<c:if test="${empty bookings}"><tr><td colspan="8" style="text-align:center;padding:24px;color:var(--muted);">No bookings found.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
