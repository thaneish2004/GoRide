/**
 * GoRide common app utilities.
 * - Auto-dismiss alerts after 4s
 * - Confirmation dialogs for destructive actions
 * - Sidebar toggle + active-link highlighting
 * - Client-side required-field validation
 */
document.addEventListener('DOMContentLoaded', function () {

    // Auto-dismiss flash messages
    document.querySelectorAll('.alert').forEach(function (el) {
        setTimeout(function () { el.style.transition = 'opacity .5s'; el.style.opacity = '0'; }, 4000);
        setTimeout(function () { if (el.parentNode) el.parentNode.removeChild(el); }, 4500);
    });

    // Confirmation dialog for delete/destructive buttons
    document.querySelectorAll('[data-confirm]').forEach(function (el) {
        el.addEventListener('click', function (e) {
            if (!confirm(el.getAttribute('data-confirm') || 'Are you sure?')) {
                e.preventDefault();
            }
        });
    });

    // Sidebar collapse toggle
    var toggle = document.getElementById('sidebarToggle');
    var sidebar = document.querySelector('.admin-sidebar');
    if (toggle && sidebar) {
        toggle.addEventListener('click', function () {
            sidebar.classList.toggle('collapsed');
        });
    }

    // Highlight active sidebar link based on current URL
    var currentPath = window.location.pathname;
    document.querySelectorAll('.admin-sidebar a').forEach(function (a) {
        var href = a.getAttribute('href');
        if (href && currentPath.indexOf(href) === 0) {
            a.classList.add('active');
        }
    });

    // Client-side required field validation
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
