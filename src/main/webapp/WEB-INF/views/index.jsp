<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
<!-- Landing page: taxi hero SVG, features, stats counters, CTA -->
<title>GoRide — Ride With Confidence</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
<script src="https://unpkg.com/lucide@latest"></script>
</head><body>

<nav class="lp-nav">
<div class="lp-nav-inner">
<div class="lp-logo">Go<span>Ride</span></div>
<div class="lp-nav-links">
<a href="#features">Features</a>
<a href="#stats">Stats</a>
<a href="#how">How It Works</a>
</div>
<div class="lp-nav-actions">
<a href="/login" class="btn btn-outline btn-sm">Sign In</a>
<a href="/register" class="btn btn-primary btn-sm">Get Started</a>
</div>
</div>
</nav>

<section class="lp-hero parallax" data-speed="0.3">
<div class="lp-hero-bg"></div>
<div class="lp-hero-content">
<span class="lp-badge">Your Ride, Anytime</span>
<h1>Ride With<br><span class="lp-highlight">Confidence</span></h1>
<p>Reliable, fast, and affordable taxi service at your fingertips. Book a ride in seconds, track in real-time.</p>
<div class="lp-hero-actions">
<a href="/register" class="btn btn-primary lp-btn-lg">Get Started</a>
<a href="/login" class="btn btn-outline lp-btn-lg" style="border-color:rgba(255,255,255,.5);color:#fff;">Sign In</a>
</div>
</div>
<div class="lp-hero-car">
<svg width="320" height="130" viewBox="0 0 320 130" xmlns="http://www.w3.org/2000/svg">
  <defs>
    <linearGradient id="taxiBody" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0%" stop-color="#fbbf24"/>
      <stop offset="50%" stop-color="#f59e0b"/>
      <stop offset="100%" stop-color="#d97706"/>
    </linearGradient>
    <linearGradient id="taxiGlass" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0%" stop-color="#0f172a" stop-opacity=".35"/>
      <stop offset="100%" stop-color="#0f172a" stop-opacity=".15"/>
    </linearGradient>
    <linearGradient id="taxiGlassFront" x1="0" y1="0" x2="1" y2="0">
      <stop offset="0%" stop-color="#0f172a" stop-opacity=".3"/>
      <stop offset="100%" stop-color="#0f172a" stop-opacity=".1"/>
    </linearGradient>
    <linearGradient id="wheelTread" x1="0" y1="0" x2="0" y2="1">
      <stop offset="0%" stop-color="#1e293b"/>
      <stop offset="100%" stop-color="#0f172a"/>
    </linearGradient>
  </defs>

  <!-- Road -->
  <g class="road">
    <rect x="-10" y="109" width="340" height="16" fill="#1e293b" opacity=".6"/>
    <rect x="-10" y="109" width="340" height="2" fill="#475569" opacity=".5"/>
    <!-- Animated dashed centre line (scrolls right-to-left) -->
    <line x1="-10" y1="117" x2="330" y2="117" stroke="#fbbf24" stroke-width="1.5"
          stroke-dasharray="12,10" opacity=".45">
      <animate attributeName="stroke-dashoffset" from="22" to="0" dur=".3s" repeatCount="indefinite"/>
    </line>
  </g>

  <g class="car-body">
    <!-- Ground shadow -->
    <ellipse cx="160" cy="113" rx="140" ry="5" fill="#000" opacity=".15"/>

    <!-- Rear wheel arch cutout -->
    <path d="M42,88 A18,18 0 0,1 78,88" fill="none" stroke="#1e293b" stroke-width="3" opacity=".3"/>
    <!-- Front wheel arch cutout -->
    <path d="M252,88 A18,18 0 0,1 288,88" fill="none" stroke="#1e293b" stroke-width="3" opacity=".3"/>

    <!-- Main body silhouette -->
    <path d="M22,88
      L26,60
      C30,42 50,33 78,30
      L155,30
      C178,30 194,42 205,52
      L248,52
      C262,52 278,58 286,70
      L292,80
      L298,88 Z"
      fill="url(#taxiBody)" stroke="#d97706" stroke-width="1"/>

    <!-- Lower rocker panel -->
    <path d="M22,88 L298,88 L295,76 Q292,70 286,70 L278,70 L248,70 L205,70 L155,70 L78,70 L26,70 L24,76 Z"
      fill="#c2410c" opacity=".6"/>

    <!-- Rear window -->
    <path d="M72,34 L110,34 L150,34 L172,42 L190,50 L90,50 Z"
      fill="url(#taxiGlass)" stroke="#0f172a" stroke-width=".5" stroke-opacity=".15"/>

    <!-- Front windshield -->
    <path d="M172,42 L190,50 L202,50 L195,40 L178,34 Z"
      fill="url(#taxiGlassFront)" stroke="#0f172a" stroke-width=".5" stroke-opacity=".15"/>

    <!-- B-pillar -->
    <rect x="153" y="30" width="4" height="22" fill="#0f172a" opacity=".2"/>

    <!-- Roof drip rail accent -->
    <path d="M68,31 L78,30 L155,30 L170,31" fill="none" stroke="#d97706" stroke-width="1.5" opacity=".5"/>

    <!-- Rear window divider -->
    <line x1="110" y1="50" x2="110" y2="34" stroke="#0f172a" stroke-width=".5" opacity=".15"/>

    <!-- Door gap line -->
    <line x1="195" y1="52" x2="195" y2="82" stroke="#b45309" stroke-width="1" opacity=".5"/>

    <!-- Rear door handle -->
    <rect x="124" y="60" width="7" height="2.5" rx="1" fill="#0f172a" opacity=".35"/>
    <!-- Front door handle -->
    <rect x="178" y="60" width="7" height="2.5" rx="1" fill="#0f172a" opacity=".35"/>

    <!-- Side mirror -->
    <ellipse cx="207" cy="42" rx="4" ry="3" fill="#0f172a" opacity=".5"/>
    <path d="M203,42 L207,42" stroke="#0f172a" stroke-width="1" opacity=".3"/>

    <!-- Taillight -->
    <path d="M24,58 L20,62 L20,72 L26,70 Z" fill="#ef4444" opacity=".85"/>
    <path d="M22,62 L20,65 L20,72 L24,70 Z" fill="#dc2626" opacity=".6"/>

    <!-- Headlight cluster -->
    <path d="M295,68 L298,68 L300,75 L292,75 Z" fill="#fff" opacity=".85"/>
    <circle cx="297" cy="71" r="2.5" fill="#fef08a" opacity=".7"/>

    <!-- Front grille -->
    <rect x="290" y="76" width="8" height="12" rx="1" fill="#0f172a" opacity=".6"/>
    <line x1="292" y1="76" x2="292" y2="88" stroke="#334155" stroke-width=".5" opacity=".4"/>
    <line x1="294" y1="76" x2="294" y2="88" stroke="#334155" stroke-width=".5" opacity=".4"/>
    <line x1="296" y1="76" x2="296" y2="88" stroke="#334155" stroke-width=".5" opacity=".4"/>

    <!-- Front bumper -->
    <path d="M290,88 L303,88 L302,82 Q300,76 298,76 L290,76 Z" fill="#334155" opacity=".4"/>

    <!-- Checkered racing stripe -->
    <g opacity=".25">
      <rect x="80" y="80" width="4" height="4" fill="#0f172a"/>
      <rect x="88" y="80" width="4" height="4" fill="#0f172a"/>
      <rect x="96" y="80" width="4" height="4" fill="#0f172a"/>
      <rect x="104" y="80" width="4" height="4" fill="#0f172a"/>
      <rect x="112" y="80" width="4" height="4" fill="#0f172a"/>
      <rect x="84" y="84" width="4" height="4" fill="#0f172a"/>
      <rect x="92" y="84" width="4" height="4" fill="#0f172a"/>
      <rect x="100" y="84" width="4" height="4" fill="#0f172a"/>
      <rect x="108" y="84" width="4" height="4" fill="#0f172a"/>
    </g>

    <!-- Taxi sign on roof -->
    <rect x="122" y="24" width="36" height="8" rx="3" fill="#fbbf24" stroke="#d97706" stroke-width=".8"/>
    <rect x="124" y="25.5" width="32" height="5" rx="2" fill="#fef08a" opacity=".5"/>
    <text x="140" y="30.5" text-anchor="middle" font-size="5.5" font-weight="800" fill="#0f172a" font-family="Inter,sans-serif">TAXI</text>
    <!-- Sign mounting poles -->
    <line x1="130" y1="24" x2="130" y2="30" stroke="#d97706" stroke-width="1"/>
    <line x1="150" y1="24" x2="150" y2="30" stroke="#d97706" stroke-width="1"/>
  </g>

  <!-- Rear wheel -->
  <g class="wheel-back">
    <!-- Tire -->
    <circle cx="60" cy="97" r="16" fill="url(#wheelTread)" stroke="#0f172a" stroke-width="1.5"/>
    <!-- Tire treads -->
    <circle cx="60" cy="97" r="15" fill="none" stroke="#1e293b" stroke-width="1" stroke-dasharray="3,3"/>
    <!-- Alloy rim -->
    <circle cx="60" cy="97" r="9" fill="#475569" stroke="#334155" stroke-width="1"/>
    <!-- Hub -->
    <circle cx="60" cy="97" r="3" fill="#64748b"/>
    <!-- Spokes -->
    <line x1="60" y1="88" x2="60" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="60" y1="97" x2="60" y2="106" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="51" y1="97" x2="60" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="60" y1="97" x2="69" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <animateTransform attributeName="transform" type="rotate" from="0 60 97" to="360 60 97" dur=".25s" repeatCount="indefinite"/>
  </g>

  <!-- Front wheel -->
  <g class="wheel-front">
    <circle cx="270" cy="97" r="16" fill="url(#wheelTread)" stroke="#0f172a" stroke-width="1.5"/>
    <circle cx="270" cy="97" r="15" fill="none" stroke="#1e293b" stroke-width="1" stroke-dasharray="3,3"/>
    <circle cx="270" cy="97" r="9" fill="#475569" stroke="#334155" stroke-width="1"/>
    <circle cx="270" cy="97" r="3" fill="#64748b"/>
    <line x1="270" y1="88" x2="270" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="270" y1="97" x2="270" y2="106" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="261" y1="97" x2="270" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <line x1="270" y1="97" x2="279" y2="97" stroke="#64748b" stroke-width="2" opacity=".8"/>
    <animateTransform attributeName="transform" type="rotate" from="0 270 97" to="360 270 97" dur=".25s" repeatCount="indefinite"/>
  </g>
</svg>
</div>
</section>

<section id="features" class="lp-section">
<div class="lp-container">
<div class="lp-section-head">
<h2>Why Choose <span class="lp-highlight">GoRide</span></h2>
<p>Everything you need for a seamless ride experience</p>
</div>
<div class="lp-features">
<div class="lp-feature-card">
<div class="lp-feature-icon"><i data-lucide="navigation" width="28" height="28"></i></div>
<h3>Real-Time Tracking</h3>
<p>Track your ride in real-time. Know exactly where your driver is and when they'll arrive.</p>
</div>
<div class="lp-feature-card">
<div class="lp-feature-icon"><i data-lucide="shield" width="28" height="28"></i></div>
<h3>Safe & Secure</h3>
<p>All drivers are verified. Share your trip with loved ones for added peace of mind.</p>
</div>
<div class="lp-feature-card">
<div class="lp-feature-icon"><i data-lucide="zap" width="28" height="28"></i></div>
<h3>Fast Booking</h3>
<p>Book a ride in under 10 seconds. No complicated forms, just tap and go.</p>
</div>
<div class="lp-feature-card">
<div class="lp-feature-icon"><i data-lucide="wallet" width="28" height="28"></i></div>
<h3>Best Prices</h3>
<p>Transparent pricing with no hidden fees. Know your fare before you ride.</p>
</div>
</div>
</div>
</section>

<section id="stats" class="lp-stats parallax" data-speed="0.5">
<div class="lp-stats-bg"></div>
<div class="lp-container">
<div class="lp-stats-grid">
<div class="lp-stat-item">
<div class="lp-stat-number" data-target="50000">0</div>
<div class="lp-stat-label">Rides Completed</div>
</div>
<div class="lp-stat-item">
<div class="lp-stat-number" data-target="1500">0</div>
<div class="lp-stat-label">Active Drivers</div>
</div>
<div class="lp-stat-item">
<div class="lp-stat-number" data-target="99">0</div>
<div class="lp-stat-label">Satisfaction %</div>
</div>
<div class="lp-stat-item">
<div class="lp-stat-number" data-target="50">0</div>
<div class="lp-stat-label">Cities Covered</div>
</div>
</div>
</div>
</section>

<section id="how" class="lp-section">
<div class="lp-container">
<div class="lp-section-head">
<h2>How It <span class="lp-highlight">Works</span></h2>
<p>Three simple steps to get you where you need to go</p>
</div>
<div class="lp-steps">
<div class="lp-step">
<div class="lp-step-number">1</div>
<div class="lp-step-icon"><i data-lucide="map-pin" width="32" height="32"></i></div>
<h3>Set Your Location</h3>
<p>Enter your pickup and drop-off locations. Our smart system finds the best route.</p>
</div>
<div class="lp-step-connector"></div>
<div class="lp-step">
<div class="lp-step-number">2</div>
<div class="lp-step-icon"><i data-lucide="car" width="32" height="32"></i></div>
<h3>Choose Your Ride</h3>
<p>Select from available vehicles and drivers near you. View fares and ETAs instantly.</p>
</div>
<div class="lp-step-connector"></div>
<div class="lp-step">
<div class="lp-step-number">3</div>
<div class="lp-step-icon"><i data-lucide="smile" width="32" height="32"></i></div>
<h3>Enjoy the Ride</h3>
<p>Sit back and relax. Track your journey live and pay seamlessly at the end.</p>
</div>
</div>
</div>
</section>

<section class="lp-cta parallax" data-speed="0.4">
<div class="lp-cta-bg"></div>
<div class="lp-container">
<div class="lp-cta-content">
<h2>Ready to Ride?</h2>
<p>Join thousands of satisfied passengers. Sign up today and get your first ride.</p>
<div class="lp-hero-actions">
<a href="/register" class="btn btn-primary lp-btn-lg">Create Account</a>
<a href="/login" class="btn btn-outline lp-btn-lg" style="border-color:rgba(255,255,255,.5);color:#fff;">Sign In</a>
</div>
</div>
</div>
</section>

<footer class="lp-footer">
<div class="lp-container">
<div class="lp-footer-grid">
<div>
<div class="lp-logo" style="margin-bottom:12px;">Go<span>Ride</span></div>
<p style="color:var(--muted);font-size:.875rem;max-width:280px;">Your reliable ride partner. Safe, fast, and affordable taxi service available 24/7.</p>
</div>
<div>
<h4>Quick Links</h4>
<a href="#features">Features</a>
<a href="#stats">Stats</a>
<a href="#how">How It Works</a>
</div>
<div>
<h4>Support</h4>
<a href="/contact">Contact Us</a>
<a href="#">FAQ</a>
<a href="#">Safety</a>
</div>
<div>
<h4>Legal</h4>
<a href="#">Privacy Policy</a>
<a href="#">Terms of Service</a>
</div>
</div>
<div class="lp-footer-bottom">
<p>&copy; 2026 GoRide. All rights reserved.</p>
</div>
</div>
</footer>

<script src="/js/landing.js"></script>
</body></html>
