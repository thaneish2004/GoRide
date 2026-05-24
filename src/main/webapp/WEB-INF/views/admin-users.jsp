<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Manage Passengers</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="admin-sidebar.jsp"><jsp:param name="title" value="Passengers"/></jsp:include>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="card">
<form method="get" action="/admin/users/search" style="display:flex;gap:8px;margin-bottom:16px;">
<input type="text" name="q" placeholder="Search by name, email or phone..." style="flex:1;padding:10px 14px;border:1px solid var(--hairline);border-radius:var(--radius-md);background:var(--surface);color:var(--ink);"/>
<button type="submit" class="btn btn-primary">Search</button>
</form>
<div class="table-wrap">
<table><thead><tr><th>Name</th><th>Email</th><th>Phone</th><th>Type</th><th>Action</th></tr></thead>
<tbody>
<c:forEach var="u" items="${users}">
<tr><td>${u.name}</td><td>${u.email}</td><td>${u.phone}</td><td><span class="badge badge-info">${u.passengerType}</span></td>
<td><form method="post" action="/admin/users/delete" style="display:inline"><input type="hidden" name="id" value="${u.id}"/><button type="submit" class="btn btn-danger btn-sm" data-confirm="Delete this user?">Delete</button></form></td></tr>
</c:forEach>
<c:if test="${empty users}"><tr><td colspan="5" style="text-align:center;color:var(--muted);padding:24px;">No users found.</td></tr></c:if>
</tbody></table>
</div></div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
