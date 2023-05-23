$(function() {
    $('#login-form').submit(function(e) {
      // Evita que o formulário seja enviado
      e.preventDefault();
  
      // Recupera os valores dos campos de entrada
      var username = $('#username').val().trim();
      var password = $('#password').val().trim();
  
      // Verifica se os campos estão vazios
      if (!username) {
        $('#username').addClass('is-invalid');
        return;
      } else {
        $('#username').removeClass('is-invalid');
      }
      if (!password) {
        $('#password').addClass('is-invalid');
        return;
      } else {
        $('#password').removeClass('is-invalid');
      }
  
      // Verifica se os campos são válidos
      if (username.length < 3) {
        $('#username').addClass('is-invalid');
        $('#username').siblings('.invalid-feedback').text('O nome de usuário deve ter pelo menos 3 caracteres.');
        return;
      } else {
        $('#username').removeClass('is-invalid');
      }
      if (password.length < 6) {
        $('#password').addClass('is-invalid');
        $('#password').siblings('.invalid-feedback').text('A senha deve ter pelo menos 6 caracteres.');
        return;
      } else {
        $('#password').removeClass('is-invalid');
      }
  
      // Envia o formulário
      $('#error-message').empty();
      $.ajax({
        type: 'POST',
        url: '/login',
        data: {
          username: username,
          password: password
        },
        success: function() {
          window.location.href = '/dashboard';
        },
        error: function() {
          $('#error-message').text('Nome de usuário ou senha incorretos.');
        }
      });
    });
  });