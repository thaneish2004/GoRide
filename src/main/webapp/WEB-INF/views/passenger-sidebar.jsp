<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<div class="admin-wrapper">
<div class="admin-sidebar">
<div class="sidebar-brand">Go<span>Ride</span></div>
<a href="/home"><i data-lucide="layout-dashboard" class="side-icon"></i> <span>Dashboard</span></a>
<a href="/book"><i data-lucide="navigation" class="side-icon"></i> <span>Book a Ride</span></a>
<a href="/my-bookings"><i data-lucide="clipboard-list" class="side-icon"></i> <span>My Bookings</span></a>
<a href="/profile"><i data-lucide="user" class="side-icon"></i> <span>Profile</span></a>
<a href="/payment"><i data-lucide="credit-card" class="side-icon"></i> <span>Payment</span></a>
<div class="sidebar-footer">
<a href="/logout"><i data-lucide="log-out" class="side-icon"></i> <span>Logout</span></a>
</div>
</div>
<div class="admin-content">
<div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:24px;">
<h2 style="font-weight:700;color:var(--ink);letter-spacing:-0.3px;">${param.title}</h2>
<span style="color:var(--muted);font-size:.875rem;">${sessionScope.loggedInUser.name}</span>
</div>
