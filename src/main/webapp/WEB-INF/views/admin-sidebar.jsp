<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<div class="admin-wrapper">
<div class="admin-sidebar">
<div class="sidebar-brand">Go<span>Ride</span></div>
<a href="/admin/dashboard"><i data-lucide="layout-dashboard" class="side-icon"></i> <span>Dashboard</span></a>
<a href="/admin/users"><i data-lucide="users" class="side-icon"></i> <span>Passengers</span></a>
<a href="/admin/drivers"><i data-lucide="user-cog" class="side-icon"></i> <span>Drivers</span></a>
<a href="/admin/bookings"><i data-lucide="clipboard-list" class="side-icon"></i> <span>Bookings</span></a>
<a href="/admin/vehicles"><i data-lucide="car" class="side-icon"></i> <span>Vehicles</span></a>
<div class="sidebar-footer">
<a href="/logout"><i data-lucide="log-out" class="side-icon"></i> <span>Logout</span></a>
</div>
</div>
<div class="admin-content">
<div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:24px;">
<h2 style="font-weight:700;color:var(--ink);letter-spacing:-0.3px;">${param.title}</h2>
<span style="color:var(--muted);font-size:.875rem;">${sessionScope.loggedInUser.name}</span>
</div>
