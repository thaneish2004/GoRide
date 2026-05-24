<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>My Fleet</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="driver-sidebar.jsp"><jsp:param name="title" value="My Fleet"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<h3 style="margin-bottom:16px;color:var(--ink);font-weight:600;">Add Vehicle</h3>
<form method="post" action="/vehicle/add" class="form-row">
<div class="form-group"><label>Make</label><input type="text" name="make" required/></div>
<div class="form-group"><label>Model</label><input type="text" name="model" required/></div>
<div class="form-group"><label>Year</label><input type="number" name="year" required/></div>
<div class="form-group"><label>Plate</label><input type="text" name="plateNumber" required/></div>
<div class="form-group"><label>Type</label>
<select name="type"><option value="SEDAN">Sedan</option><option value="SUV">SUV</option><option value="VAN">Van</option><option value="LUXURY">Luxury</option></select></div>
<div class="form-actions" style="grid-column:1/-1;"><button type="submit" class="btn btn-success">Add Vehicle</button></div>
</form>
</div>
<div class="card">
<div class="table-wrap">
<table><thead><tr><th>Make</th><th>Model</th><th>Year</th><th>Plate</th><th>Type</th><th>Status</th><th>Action</th></tr></thead>
<tbody>
<c:forEach var="v" items="${vehicles}">
<tr>
                <td>${v.make}</td><td>${v.model}</td><td>${v.year}</td><td>${v.plate}</td>
<td><span class="badge badge-info">${v.type}</span></td>
<td><span class="badge ${v.status == 'AVAILABLE' ? 'badge-success' : 'badge-secondary'}">${v.status}</span></td>
<td>
<div style="display:flex;gap:4px;flex-wrap:nowrap;align-items:center;">
<form method="post" action="/vehicle/update" style="display:inline-flex;gap:4px;align-items:center;">
<input type="hidden" name="id" value="${v.id}"/>
<select name="status" style="padding:4px 8px;border:1px solid var(--hairline);border-radius:4px;background:var(--surface);color:var(--ink);">
<option value="AVAILABLE" ${v.status == 'AVAILABLE' ? 'selected' : ''}>Avail</option>
<option value="MAINTENANCE" ${v.status == 'MAINTENANCE' ? 'selected' : ''}>Maint</option>
<option value="OUT_OF_SERVICE" ${v.status == 'OUT_OF_SERVICE' ? 'selected' : ''}>Off</option>
</select>
<button type="submit" class="btn btn-primary btn-sm">Update</button>
</form>
<form method="post" action="/vehicle/delete" style="display:inline">
<input type="hidden" name="id" value="${v.id}"/>
<button type="submit" class="btn btn-danger btn-sm" data-confirm="Delete this vehicle?">Delete</button>
</form>
</div>
</td></tr>
</c:forEach>
<c:if test="${empty vehicles}"><tr><td colspan="7" style="text-align:center;padding:24px;color:var(--muted);">No vehicles yet.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>