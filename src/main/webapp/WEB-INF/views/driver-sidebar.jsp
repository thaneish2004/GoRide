<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<div class="admin-wrapper">
<div class="admin-sidebar">
<div class="sidebar-brand">Go<span>Ride</span></div>
<a href="/home"><i data-lucide="layout-dashboard" class="side-icon"></i> <span>Dashboard</span></a>
<a href="/tasks"><i data-lucide="list-checks" class="side-icon"></i> <span>Dispatch Tasks</span></a>
<a href="/fleet"><i data-lucide="car" class="side-icon"></i> <span>My Fleet</span></a>
<div class="sidebar-footer">
<a href="/logout"><i data-lucide="log-out" class="side-icon"></i> <span>Logout</span></a>
</div>
</div>
<div class="admin-content">
<div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:24px;">
<h2 style="font-weight:700;color:var(--ink);letter-spacing:-0.3px;">${param.title}</h2>
<span style="color:var(--muted);font-size:.875rem;">${sessionScope.loggedInUser.name}</span>
</div>
