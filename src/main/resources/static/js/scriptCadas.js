$(function() {
    $('#signup-form').on('submit', function(event) {
      event.preventDefault();

      // Obtém os valores dos campos do formulário
      var email = $('#email').val();
      var username = $('#username').val();
      var password = $('#password').val();
      var birthday = $('#birthday').val();
      var cep = $('#cep').val();

      // Verifica se os campos estão preenchidos
  if (email === '' || username === '' || password === '' || birthday === '' || cep === '') {
    $('#error-message').html('<p class="text-danger">Por favor, preencha todos os campos.</p>');
    return;
  }

  // Verifica se o email é válido
  if (!validateEmail(email)) {
    $('#email').addClass('is-invalid');
    $('#email-error').show();
    return;
  }

  // Verifica se o username é válido
  if (!validateUsername(username)) {
    $('#username').addClass('is-invalid');
    $('#username-error').show();
    return;
  }

  // Verifica se a senha é válida
  if (!validatePassword(password)) {
    $('#password').addClass('is-invalid');
    $('#password-error').show();
    return;
  }

  // Verifica se a data de aniversário é válida
  if (!validateBirthday(birthday)) {
    $('#birthday').addClass('is-invalid');
    $('#birthday-error').show();
    return;
  }

  // Verifica se o CEP é válido
  if (!validateCEP(cep)) {
    $('#cep').addClass('is-invalid');
    $('#cep-error').show();
    return;
  }

  // Se todos os campos são válidos, exibe uma mensagem de sucesso
  $('#error-message').html('<p class="text-success">Cadastro realizado com sucesso!</p>');

  // Limpa os valores dos campos do formulário
  $('#email').val('');
  $('#username').val('');
  $('#password').val('');
  $('#birthday').val('');
  $('#cep').val('');

  // Remove as classes de erro e as mensagens de erro dos campos do formulário
  $('.is-invalid').removeClass('is-invalid');
  $('.invalid-feedback').hide();
});

// Função para validar o email
function validateEmail(email) {
  var re = /\S+@\S+\.\S+/;
  return re.test(email);
}

// Função para validar o username
function validateUsername(username) {
  var re = /^[a-zA-Z0-9]+$/;
  return re.test(username);
}

// Função para validar a senha
function validatePassword(password) {
  return password.length >= 6;
}

// Função para validar a data de aniversário
function validateBirthday(birthday) {
  var date = new Date(birthday);
  return !isNaN(date.getTime());
}

// Função para validar o CEP
function validateCEP(cep) {
  var re = /^[0-9]{5}-?[0-9]{3}$/;
  return re.test(cep);
}
});