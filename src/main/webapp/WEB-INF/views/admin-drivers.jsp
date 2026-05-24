<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Manage Drivers</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="admin-sidebar.jsp"><jsp:param name="title" value="Drivers"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>

<div class="card">
<h3 style="margin-bottom:16px;color:var(--ink);font-weight:600;">Add Driver</h3>
<form method="post" action="/admin/drivers/create" class="form-row">
<div class="form-group"><label>Name</label><input type="text" name="name" required/></div>
<div class="form-group"><label>Email</label><input type="email" name="email" required/></div>
<div class="form-group"><label>Phone</label><input type="text" name="phone" required/></div>
<div class="form-group"><label>Password</label><input type="text" name="password" required/></div>
<div class="form-group"><label>License</label><input type="text" name="licenseNumber" placeholder="DL-XXX" required/></div>
<div class="form-group"><label>Status</label><select name="status"><option value="AVAILABLE">Available</option><option value="BUSY">Busy</option><option value="OFFLINE">Offline</option></select></div>
<div class="form-actions" style="grid-column:1/-1;"><button type="submit" class="btn btn-success">Add Driver</button></div>
</form>
</div>

<div class="card">
<div class="table-wrap">
<table><thead><tr><th>Name</th><th>Email</th><th>Phone</th><th>License</th><th>Status</th><th>Action</th></tr></thead>
<tbody>
<c:forEach var="d" items="${drivers}">
<tr>
<td>${d.name}</td><td>${d.email}</td><td>${d.phone}</td><td>${d.licenseNumber}</td>
<td><span class="badge ${d.status == 'AVAILABLE' ? 'badge-success' : d.status == 'BUSY' ? 'badge-warning' : 'badge-secondary'}">${d.status}</span></td>
<td>
<form method="post" action="/admin/drivers/edit" style="display:inline-flex;gap:4px;align-items:center;">
<input type="hidden" name="id" value="${d.id}"/>
<select name="status" style="padding:4px 8px;border:1px solid var(--hairline);border-radius:4px;background:var(--surface);color:var(--ink);">
<option value="AVAILABLE" ${d.status == 'AVAILABLE' ? 'selected' : ''}>Avail</option>
<option value="BUSY" ${d.status == 'BUSY' ? 'selected' : ''}>Busy</option>
<option value="OFFLINE" ${d.status == 'OFFLINE' ? 'selected' : ''}>Offline</option>
</select>
<button type="submit" class="btn btn-primary btn-sm">Update</button>
</form>
<form method="post" action="/admin/drivers/delete" style="display:inline">
<input type="hidden" name="id" value="${d.id}"/>
<button type="submit" class="btn btn-danger btn-sm" data-confirm="Delete this driver?">Delete</button>
</form>
</td></tr>
</c:forEach>
<c:if test="${empty drivers}"><tr><td colspan="6" style="text-align:center;padding:24px;color:var(--muted);">No drivers found.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
