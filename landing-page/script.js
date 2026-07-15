(function () {
  'use strict';

  // === DOM References ===
  var header = document.getElementById('header');
  var hamburger = document.getElementById('hamburger');
  var mainNav = document.getElementById('mainNav');
  var navLinks = mainNav.querySelectorAll('.nav-list a');
  var contactForm = document.getElementById('contactForm');
  var formSuccess = document.getElementById('formSuccess');
  var counterItems = document.querySelectorAll('.counter-value');
  var fadeElements = document.querySelectorAll('.fade-in');
  var fundFills = document.querySelectorAll('.fund-fill');

  // === State ===
  var countersAnimated = false;
  var fundBarsAnimated = false;

  // === Mobile Menu Toggle ===
  hamburger.addEventListener('click', function () {
    var isOpen = mainNav.classList.toggle('open');
    hamburger.classList.toggle('open');
    hamburger.setAttribute('aria-expanded', isOpen ? 'true' : 'false');
    document.body.style.overflow = isOpen ? 'hidden' : '';
  });

  navLinks.forEach(function (link) {
    link.addEventListener('click', function () {
      mainNav.classList.remove('open');
      hamburger.classList.remove('open');
      hamburger.setAttribute('aria-expanded', 'false');
      document.body.style.overflow = '';
    });
  });

  // Close mobile nav on Escape
  document.addEventListener('keydown', function (e) {
    if (e.key === 'Escape' && mainNav.classList.contains('open')) {
      mainNav.classList.remove('open');
      hamburger.classList.remove('open');
      hamburger.setAttribute('aria-expanded', 'false');
      document.body.style.overflow = '';
    }
  });

  // === Smooth scroll for all anchor links ===
  document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
    anchor.addEventListener('click', function (e) {
      var targetId = this.getAttribute('href');
      if (targetId === '#privacy' || targetId === '#terms') return;
      var target = document.querySelector(targetId);
      if (target) {
        e.preventDefault();
        var headerHeight = header.offsetHeight;
        var targetPosition = target.getBoundingClientRect().top + window.pageYOffset - headerHeight;
        window.scrollTo({ top: targetPosition, behavior: 'smooth' });
      }
    });
  });

  // === Counter Animation ===
  function animateCounter(el) {
    var target = parseInt(el.getAttribute('data-target'), 10);
    var suffix = el.getAttribute('data-suffix') || '';
    var duration = 2000;
    var startTime = null;

    function update(timestamp) {
      if (!startTime) startTime = timestamp;
      var progress = Math.min((timestamp - startTime) / duration, 1);
      var eased = 1 - Math.pow(1 - progress, 3);
      var current = Math.floor(eased * target);
      el.textContent = current.toLocaleString() + suffix;
      if (progress < 1) {
        requestAnimationFrame(update);
      } else {
        el.textContent = target.toLocaleString() + suffix;
      }
    }

    requestAnimationFrame(update);
  }

  // === Intersection Observer for Counters ===
  var counterObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting && !countersAnimated) {
        countersAnimated = true;
        counterItems.forEach(function (item) {
          animateCounter(item);
        });
      }
    });
  }, { threshold: 0.3 });

  var counterGrid = document.querySelector('.counter-grid');
  if (counterGrid) counterObserver.observe(counterGrid);

  // === Intersection Observer for Fade-in Elements ===
  var fadeObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting) {
        entry.target.classList.add('visible');
        fadeObserver.unobserve(entry.target);
      }
    });
  }, { threshold: 0.15, rootMargin: '0px 0px -40px 0px' });

  fadeElements.forEach(function (el) {
    fadeObserver.observe(el);
  });

  // === Intersection Observer for Fund Allocation Bars ===
  var fundObserver = new IntersectionObserver(function (entries) {
    entries.forEach(function (entry) {
      if (entry.isIntersecting && !fundBarsAnimated) {
        fundBarsAnimated = true;
        fundFills.forEach(function (fill) {
          var width = fill.style.width;
          fill.style.width = '0%';
          requestAnimationFrame(function () {
            fill.style.width = width;
          });
        });
      }
    });
  }, { threshold: 0.3 });

  var fundAlloc = document.querySelector('.fund-alloc');
  if (fundAlloc) fundObserver.observe(fundAlloc);

  // === Contact Form Validation ===
  function showError(fieldId, message) {
    var errorEl = document.getElementById(fieldId + 'Error');
    var inputEl = document.getElementById(fieldId);
    if (errorEl) errorEl.textContent = message;
    if (inputEl) {
      inputEl.classList.add('error');
      inputEl.classList.remove('valid');
      inputEl.setAttribute('aria-invalid', 'true');
    }
  }

  function clearError(fieldId) {
    var errorEl = document.getElementById(fieldId + 'Error');
    var inputEl = document.getElementById(fieldId);
    if (errorEl) errorEl.textContent = '';
    if (inputEl) {
      inputEl.classList.remove('error');
      inputEl.classList.add('valid');
      inputEl.removeAttribute('aria-invalid');
    }
  }

  function validateEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }

  function validateField(fieldId, value) {
    if (fieldId === 'name') {
      if (!value.trim()) { showError(fieldId, 'Name is required.'); return false; }
      if (value.trim().length < 2) { showError(fieldId, 'Name must be at least 2 characters.'); return false; }
      clearError(fieldId); return true;
    }
    if (fieldId === 'email') {
      if (!value.trim()) { showError(fieldId, 'Email is required.'); return false; }
      if (!validateEmail(value.trim())) { showError(fieldId, 'Please enter a valid email address.'); return false; }
      clearError(fieldId); return true;
    }
    if (fieldId === 'message') {
      if (!value.trim()) { showError(fieldId, 'Message is required.'); return false; }
      if (value.trim().length < 10) { showError(fieldId, 'Message must be at least 10 characters.'); return false; }
      clearError(fieldId); return true;
    }
    return true;
  }

  // Real-time validation on blur
  ['name', 'email', 'message'].forEach(function (fieldId) {
    var input = document.getElementById(fieldId);
    if (input) {
      input.addEventListener('blur', function () {
        validateField(fieldId, input.value);
      });
      input.addEventListener('input', function () {
        if (input.classList.contains('error') || input.classList.contains('valid')) {
          validateField(fieldId, input.value);
        }
      });
    }
  });

  if (contactForm) {
    contactForm.addEventListener('submit', function (e) {
      e.preventDefault();
      formSuccess.hidden = true;

      var nameValid = validateField('name', document.getElementById('name').value);
      var emailValid = validateField('email', document.getElementById('email').value);
      var messageValid = validateField('message', document.getElementById('message').value);

      if (nameValid && emailValid && messageValid) {
        formSuccess.hidden = false;
        contactForm.reset();
        ['name', 'email', 'message'].forEach(function (fieldId) {
          var input = document.getElementById(fieldId);
          if (input) {
            input.classList.remove('valid', 'error');
            input.removeAttribute('aria-invalid');
          }
        });
        formSuccess.scrollIntoView({ behavior: 'smooth', block: 'nearest' });
      } else {
        var firstError = document.querySelector('.form-group input.error, .form-group textarea.error');
        if (firstError) firstError.focus();
      }
    });
  }

  // === Header scroll background opacity ===
  var headerObserver = new IntersectionObserver(function (entries) {
    if (entries[0].isIntersecting) {
      header.style.background = 'rgba(13, 26, 45, 0.6)';
    } else {
      header.style.background = 'rgba(13, 26, 45, 0.95)';
    }
  }, { threshold: 0 });

  var heroSection = document.getElementById('hero');
  if (heroSection) headerObserver.observe(heroSection);

})();
