document.addEventListener('DOMContentLoaded', function () {

  lucide.createIcons();

  var navbar = document.querySelector('.lp-nav');
  var hero = document.querySelector('.lp-hero');

  function updateNav() {
    if (!navbar || !hero) return;
    var heroBottom = hero.getBoundingClientRect().bottom;
    if (heroBottom <= 64) {
      navbar.style.borderBottomColor = 'var(--hairline)';
      navbar.style.boxShadow = '0 1px 3px rgba(0,0,0,.06)';
    } else {
      navbar.style.borderBottomColor = 'transparent';
      navbar.style.boxShadow = 'none';
    }
  }

  updateNav();
  window.addEventListener('scroll', updateNav, { passive: true });

  var parallaxElements = document.querySelectorAll('.parallax');
  function updateParallax() {
    parallaxElements.forEach(function (el) {
      var speed = parseFloat(el.getAttribute('data-speed')) || 0.3;
      var rect = el.getBoundingClientRect();
      var offset = rect.top * speed;
      var bg = el.querySelector('[class$="-bg"]');
      if (bg) {
        bg.style.transform = 'translateY(' + offset + 'px)';
      }
    });
  }

  window.addEventListener('scroll', updateParallax, { passive: true });
  updateParallax();

  var counters = document.querySelectorAll('.lp-stat-number');
  var counted = false;

  function animateCounters() {
    if (counted) return;
    var stats = document.querySelector('.lp-stats');
    if (!stats) return;
    var rect = stats.getBoundingClientRect();
    if (rect.top < window.innerHeight && rect.bottom > 0) {
      counted = true;
      counters.forEach(function (el) {
        var target = parseInt(el.getAttribute('data-target')) || 0;
        var current = 0;
        var step = Math.max(1, Math.floor(target / 60));
        var interval = setInterval(function () {
          current += step;
          if (current >= target) {
            current = target;
            clearInterval(interval);
          }
          el.textContent = target >= 1000 ? (current >= 1000 ? (current / 1000).toFixed(1) + 'K' : current) : current + (target === 99 ? '%' : '+');
        }, 25);
      });
    }
  }

  animateCounters();
  window.addEventListener('scroll', animateCounters, { passive: true });

  document.querySelectorAll('a[href^="#"]').forEach(function (a) {
    a.addEventListener('click', function (e) {
      e.preventDefault();
      var target = document.querySelector(this.getAttribute('href'));
      if (target) {
        target.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    });
  });

  console.log("GoRide app running at " + window.location.origin);
});
