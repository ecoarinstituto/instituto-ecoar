document.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('[data-phone]').forEach(el => {
    el.addEventListener('input', () => {
      el.value = el.value.replace(/[^0-9+()\\s-]/g, '');
    });
  });
});
