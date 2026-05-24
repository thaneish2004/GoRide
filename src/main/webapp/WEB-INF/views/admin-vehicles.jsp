<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head>
<!-- Admin vehicle management: list + add/toggle/delete --><title>Manage Vehicles</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="admin-sidebar.jsp"><jsp:param name="title" value="Vehicles"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<h3 style="margin-bottom:16px;color:var(--ink);font-weight:600;">Add Vehicle</h3>
<form method="post" action="/admin/vehicles/add" class="form-row">
<div class="form-group"><label>Make</label><input type="text" name="make" required/></div>
<div class="form-group"><label>Model</label><input type="text" name="model" required/></div>
<div class="form-group"><label>Year</label><input type="number" name="year" required/></div>
<div class="form-group"><label>Plate</label><input type="text" name="plateNumber" required/></div>
<div class="form-group"><label>Type</label>
<select name="type"><option value="SEDAN">Sedan</option><option value="SUV">SUV</option><option value="VAN">Van</option><option value="LUXURY">Luxury</option></select></div>
<div class="form-group"><label>Owner</label>
<select name="ownerId" id="ownerId" required onchange="updateOwnerType()">
<optgroup label="Drivers">
<c:forEach var="d" items="${drivers}"><option value="${d.id}" class="owner-driver">${d.name}</option></c:forEach>
</optgroup>
<optgroup label="Companies">
<c:forEach var="c" items="${companies}"><option value="${c.id}" class="owner-company">${c.name}</option></c:forEach>
</optgroup>
</select>
<input type="hidden" name="ownerType" id="ownerType" value="DRIVER"/>
<script>
function updateOwnerType() {
var sel = document.getElementById('ownerId');
var opt = sel.options[sel.selectedIndex];
document.getElementById('ownerType').value = opt.classList.contains('owner-company') ? 'COMPANY' : 'DRIVER';
}
</script></div>
<div class="form-actions" style="grid-column:1/-1;"><button type="submit" class="btn btn-success">Add Vehicle</button></div>
</form>
</div>
<div class="card">
<div class="table-wrap">
<table><thead><tr><th>Make</th><th>Model</th><th>Year</th><th>Plate</th><th>Type</th><th>Status</th><th>Active</th><th>Owner</th><th>Actions</th></tr></thead>
<tbody>
<c:forEach var="v" items="${vehicles}">
<tr>
<td>${v.make}</td><td>${v.model}</td><td>${v.year}</td><td>${v.plate}</td>
<td><span class="badge badge-info">${v.type}</span></td>
<td><span class="badge ${v.status == 'AVAILABLE' ? 'badge-success' : v.status == 'MAINTENANCE' ? 'badge-warning' : 'badge-secondary'}">${v.status}</span></td>
<td>
<span class="badge ${v.active ? 'badge-success' : 'badge-danger'}">${v.active ? 'Active' : 'Inactive'}</span>
</td>
<td>${ownerNames[v.ownerId]}</td>
<td>
<div style="display:flex;gap:4px;flex-wrap:nowrap;">
<form method="post" action="/admin/vehicles/toggle" style="display:inline">
<input type="hidden" name="id" value="${v.id}"/>
<button type="submit" class="btn btn-sm ${v.active ? 'btn-warning' : 'btn-success'}">
${v.active ? 'Deactivate' : 'Activate'}
</button>
</form>
<form method="post" action="/vehicle/delete" style="display:inline">
<input type="hidden" name="id" value="${v.id}"/>
<input type="hidden" name="redirect" value="/admin/vehicles"/>
<button type="submit" class="btn btn-danger btn-sm" data-confirm="Delete this vehicle?">Delete</button>
</form>
</div>
</td></tr>
</c:forEach>
<c:if test="${empty vehicles}"><tr><td colspan="9" style="text-align:center;padding:24px;color:var(--muted);">No vehicles registered.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
