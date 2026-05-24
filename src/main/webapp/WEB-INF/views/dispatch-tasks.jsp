<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<% String flash = (String) session.getAttribute("flash"); session.removeAttribute("flash"); request.setAttribute("flash", flash); %>
<html><head>
<!-- Dispatch tasks: pending/active/completed bookings table --><title>Dispatch Tasks</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="driver-sidebar.jsp"><jsp:param name="title" value="Dispatch Tasks"/></jsp:include>
<c:if test="${not empty flash}"><div class="alert alert-success">${flash}</div></c:if>
<div class="card">
<h2>Available Tasks</h2>
<div class="table-wrap">
<table><thead><tr><th>Booking ID</th><th>Passenger</th><th>Pickup</th><th>Drop</th><th>Fare</th><th>Status</th><th>Action</th></tr></thead>
<tbody>
<c:forEach var="b" items="${tasks}">
<tr>
<td>${b.bookingId}</td><td>${b.passengerName}</td><td>${b.pickup}</td><td>${b.drop}</td>
<td><c:choose><c:when test="${b.fare == 0}">TBD</c:when><c:otherwise>$${b.fare}</c:otherwise></c:choose></td>
<td><span class="badge ${b.status == 'PENDING' ? 'badge-warning' : b.status == 'CONFIRMED' ? 'badge-info' : b.status == 'IN_PROGRESS' ? 'badge-info' : 'badge-success'}">${b.status}</span></td>
<td>
<c:choose>
<c:when test="${b.status == 'PENDING'}">
<form method="post" action="/tasks/update" style="display:inline-flex;gap:4px;align-items:center;">
<input type="hidden" name="bookingId" value="${b.bookingId}"/>
<input type="hidden" name="status" value="CONFIRMED"/>
<input type="number" name="fare" step="0.01" min="1" required placeholder="Fare $"
  style="width:80px;padding:4px 8px;border:1px solid var(--hairline);border-radius:4px;background:var(--surface);color:var(--ink);font-size:.8rem;"/>
<button type="submit" class="btn btn-success btn-sm">Accept</button>
</form>
</c:when>
<c:when test="${b.status == 'COMPLETED'}">
<span style="color:var(--success);font-weight:600;">✓ Completed</span>
</c:when>
<c:otherwise>
<form method="post" action="/tasks/update" style="display:inline-flex;gap:4px;">
<input type="hidden" name="bookingId" value="${b.bookingId}"/>
<select name="status" style="padding:4px 8px;border:1px solid var(--hairline);border-radius:4px;background:var(--surface);color:var(--ink);">
<option value="IN_PROGRESS" ${b.status == 'IN_PROGRESS' ? 'selected' : ''}>In Progress</option>
<option value="COMPLETED">Completed</option>
</select>
<button type="submit" class="btn btn-primary btn-sm">Update</button>
</form>
</c:otherwise>
</c:choose>
</td></tr>
</c:forEach>
<c:if test="${empty tasks}"><tr><td colspan="7" style="text-align:center;padding:24px;color:var(--muted);">No tasks available.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>