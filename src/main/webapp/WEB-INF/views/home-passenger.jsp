<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html><head><title>Passenger Dashboard</title><link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css/style.css"><script src="https://unpkg.com/lucide@latest"></script></head><body>
<jsp:include page="passenger-sidebar.jsp"><jsp:param name="title" value="Dashboard"/></jsp:include>
<p style="color:var(--muted);margin-bottom:24px;">Book a ride or check your trips</p>
<c:if test="${not empty message}"><div class="alert alert-success">${message}</div></c:if>
<div class="home-grid">
<a href="/book" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="navigation" width="32" height="32"></i></div><h3>Book a Ride</h3><p>Request a taxi now</p></a>
<a href="/my-bookings" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="clipboard-list" width="32" height="32"></i></div><h3>My Bookings</h3><p>View your trip history</p></a>
<a href="/profile" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="user" width="32" height="32"></i></div><h3>Profile</h3><p>Manage your account details</p></a>
<a href="/payment" class="home-card" style="text-decoration:none;color:inherit;"><div class="home-icon"><i data-lucide="credit-card" width="32" height="32"></i></div><h3>Payment</h3><p>Update card information</p></a>
</div>
</div></div>
<script>lucide.createIcons();</script>
<script src="/js/app.js"></script>
</body></html>