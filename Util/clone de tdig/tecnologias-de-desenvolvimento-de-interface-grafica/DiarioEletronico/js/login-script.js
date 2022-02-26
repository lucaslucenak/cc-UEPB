var form = document.getElementById("login-form");

var username = document.getElementById("username");
var password = document.getElementById("password");

var usernameWarning = document.getElementById("username-warning");
var passwordWarning = document.getElementById("password-warning");

var loginButton = document.getElementById("login-button");

function goToInternalLink(path) {
  var myDomain = "http://127.0.0.1:5500/DiarioEletronico";
  window.location.href = myDomain + "/" + path;
}

function login() {
  var usernameValue = username.value.trim();
  var passwordValue = password.value.trim();

  if (usernameValue.length != 0 && passwordValue.length != 0) {
    alert("Login para " + username.value + " efetuado com sucesso!");
    goToInternalLink("sobre.html");
  }
}

function handleForm(event) {
  event.preventDefault();
}

form.addEventListener("submit", handleForm);

username.addEventListener("focus", () => {
  username.style.borderColor = "#1ed760";
  usernameWarning.innerText = "";
});

password.addEventListener("focus", () => {
  password.style.borderColor = "#1ed760";
  passwordWarning.innerText = "";
});

username.addEventListener("focusout", () => {
  username.style.borderColor = "#000000";
});

password.addEventListener("focusout", () => {
  password.style.borderColor = "#000000";
});

loginButton.addEventListener("click", () => {
  var usernameValue = username.value.trim();

  if (usernameValue.length == 0) {
    usernameWarning.innerText = "Preencha o campo usuário";
    username.style.borderColor = "#ed3237";
  }

  var passwordValue = password.value.trim();

  if (passwordValue.length == 0) {
    passwordWarning.innerText = "Preencha o campo senha";
    password.style.borderColor = "#ed3237";
  }
});
