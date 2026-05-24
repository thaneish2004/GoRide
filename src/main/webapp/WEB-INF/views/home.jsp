<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Dashboard</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<div class="top-header">
<div class="logo">Go<span>Ride</span></div>
<nav>
<span style="color:var(--muted);font-size:.875rem;">${sessionScope.loggedInUser.name}</span>
<a href="/logout">Logout</a>
</nav>
</div>
<div style="max-width:1000px;margin:32px auto;padding:0 24px;">
<h2 style="margin-bottom:24px;color:var(--ink);font-weight:700;letter-spacing:-0.3px;">Welcome, ${sessionScope.loggedInUser.name}</h2>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="home-grid">
<a href="/book" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="navigation" width="32" height="32"></i></div><h3>Book a Ride</h3><p>Request a taxi now</p></a>
<a href="/my-bookings" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="clipboard-list" width="32" height="32"></i></div><h3>My Bookings</h3><p>View your trips</p></a>
<a href="/profile" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="user" width="32" height="32"></i></div><h3>Profile</h3><p>Manage your account</p></a>
<a href="/payment" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="credit-card" width="32" height="32"></i></div><h3>Payment</h3><p>Update card info</p></a>
<a href="/fleet" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="car" width="32" height="32"></i></div><h3>My Fleet</h3><p>Manage vehicles</p></a>
<a href="/tasks" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="list-checks" width="32" height="32"></i></div><h3>Dispatch</h3><p>Driver tasks</p></a>
</div>
</div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>
