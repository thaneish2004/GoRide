document.addEventListener('DOMContentLoaded', function () {

    document.querySelectorAll('.alert').forEach(function (el) {
        setTimeout(function () { el.style.transition = 'opacity .5s'; el.style.opacity = '0'; }, 4000);
        setTimeout(function () { if (el.parentNode) el.parentNode.removeChild(el); }, 4500);
    });

    document.querySelectorAll('[data-confirm]').forEach(function (el) {
        el.addEventListener('click', function (e) {
            if (!confirm(el.getAttribute('data-confirm') || 'Are you sure?')) {
                e.preventDefault();
            }
        });
    });

    var toggle = document.getElementById('sidebarToggle');
    var sidebar = document.querySelector('.admin-sidebar');
    if (toggle && sidebar) {
        toggle.addEventListener('click', function () {
            sidebar.classList.toggle('collapsed');
        });
    }

    var currentPath = window.location.pathname;
    document.querySelectorAll('.admin-sidebar a').forEach(function (a) {
        var href = a.getAttribute('href');
        if (href && currentPath.indexOf(href) === 0) {
            a.classList.add('active');
        }
    });

    document.querySelectorAll('form').forEach(function (form) {
        form.addEventListener('submit', function () {
            var required = form.querySelectorAll('[required]');
            var valid = true;
            required.forEach(function (el) {
                if (!el.value.trim()) { el.style.borderColor = '#ef4444'; valid = false; }
                else { el.style.borderColor = ''; }
            });
            if (!valid) {
                alert('Please fill in all required fields.');
            }
        });
    });
});
