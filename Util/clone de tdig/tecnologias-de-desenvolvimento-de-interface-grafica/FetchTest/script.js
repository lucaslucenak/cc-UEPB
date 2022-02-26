// Reproduzir os exemplos criando outros recursos no mockable.io

// Criar recursos GET, POST, PUT e DELETE

// https://demo7950218.mockable.io/get
// https://demo7950218.mockable.io/post
// https://demo7950218.mockable.io/put
// https://demo7950218.mockable.io/delete

// Fazer uso dos recursos apresentados

fetch("https://demo7950218.mockable.io/get", {
  method: "GET",
  headers: {},
})
  .then((responseStream) => responseStream.json())
  .then((response) => {
    console.log(response);
  })
  .catch((err) => {
    console.log(err);
  });

fetch("https://demo7950218.mockable.io/post", {
  method: "POST",
  headers: {},
})
  .then((responseStream) => responseStream.json())
  .then((response) => {
    console.log(response);
  })
  .catch((err) => {
    console.error(err);
  });

fetch("https://demo7950218.mockable.io/put", {
  method: "PUT",
  headers: {},
})
  .then((responseStream) => responseStream.json())
  .then((response) => {
    console.log(response);
  })
  .catch((err) => {
    console.error(err);
  });

fetch("https://demo7950218.mockable.io/delete", {
  method: "DELETE",
  headers: {},
})
  .then((responseStream) => responseStream.json())
  .then((response) => {
    console.log(response);
  })
  .catch((err) => {
    console.error(err);
  });
