import React, { Component } from "react";
import { Formik, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import "./App.css";

const RegisterSchema = Yup.object().shape({
  nome: Yup.string().required("Campo obrigatório"),
  idade: Yup.number().min(16).required("Campo obrigatório"),
  cpf: Yup.string().required("Campo obrigatório"),
  matricula: Yup.string().required("Campo obrigatório"),
  curso: Yup.string().required("Campo obrigatório"),
  endereco: Yup.string().required("Campo obrigatório"),
  numero: Yup.string(),
  complemento: Yup.string(),
  bairro: Yup.string().required("Campo obrigatório"),
  cidade: Yup.string().required("Campo obrigatório"),
  estado: Yup.string().required("Campo obrigatório"),
  cep: Yup.string().required("Campo obrigatório"),
});

class App extends Component {
  render() {
    return (
      <div className="App">
        <Formik
          initialValues={{
            nome: "",
            idade: "",
            cpf: "",
            matricula: "",
            curso: "",
            endereco: "",
            numero: "",
            complemento: "",
            bairro: "",
            cidade: "",
            estado: "",
            cep: "",
          }}
          onSubmit={(values, { setSubmitting }) => {
            setTimeout(() => {
              console.log(JSON.stringify(values, null, 2));
              setSubmitting(false);
            }, 200);
          }}
          validateOnChange={false}
          validationSchema={RegisterSchema}
        >
          {({ handleSubmit, handleChange, isSubmitting, isValid }) => (
            <form onSubmit={handleSubmit}>
              <label>Nome completo:</label>
              <br />
              <Field type="text" name="nome" onChange={handleChange} />
              <ErrorMessage name="nome" />
              <br />

              <label>Idade:</label>
              <br />
              <Field type="number" name="idade" onChange={handleChange} />
              <ErrorMessage name="idade" />
              <br />

              <label>CPF:</label>
              <br />
              <Field type="text" name="cpf" onChange={handleChange} />
              <ErrorMessage name="cpf" />
              <br />

              <label>Matrícula:</label>
              <br />
              <Field type="text" name="matricula" onChange={handleChange} />
              <ErrorMessage name="matricula" />
              <br />

              <label>Curso:</label>
              <br />
              <Field type="text" name="curso" onChange={handleChange} />
              <ErrorMessage name="curso" />
              <br />

              <label>Endereço:</label>
              <br />
              <Field type="text" name="endereco" onChange={handleChange} />
              <ErrorMessage name="endereco" />
              <br />

              <label>Número:</label>
              <br />
              <Field type="text" name="numero" onChange={handleChange} />
              <ErrorMessage name="numero" />
              <br />

              <label>Complemento:</label>
              <br />
              <Field type="text" name="complemento" onChange={handleChange} />
              <ErrorMessage name="complemento" />
              <br />

              <label>Bairro:</label>
              <br />
              <Field type="text" name="bairro" onChange={handleChange} />
              <ErrorMessage name="bairro" />
              <br />

              <label>Cidade:</label>
              <br />
              <Field type="text" name="cidade" onChange={handleChange} />
              <ErrorMessage name="cidade" />
              <br />

              <label>Estado:</label>
              <br />
              <select name="estado" onChange={handleChange}>
                <option label="" value="" />
                <option label="Acre" value="AC" />
                <option label="Alagoas" value="AL" />
                <option label="Amapá" value="AP" />
                <option label="Amazonas" value="AM" />
                <option label="Bahia" value="BA" />
                <option label="Ceará" value="CE" />
                <option label="Distrito Federal" value="DF" />
                <option label="Espírito Santo" value="ES" />
                <option label="Goiás" value="GO" />
                <option label="Maranhão" value="MA" />
                <option label="Mato Grosso" value="MT" />
                <option label="Mato Grosso do Sul" value="MS" />
                <option label="Minas Gerais" value="MG" />
                <option label="Pará" value="PA" />
                <option label="Paraíba" value="PB" />
                <option label="Paraná" value="PR" />
                <option label="Pernambuco" value="PE" />
                <option label="Piauí" value="PI" />
                <option label="Rio de Janeiro" value="RJ" />
                <option label="Rio Grande do Norte" value="RN" />
                <option label="Rio Grande do Sul" value="RS" />
                <option label="Rondônia" value="RO" />
                <option label="Roraima" value="RR" />
                <option label="Santa Catarina" value="SC" />
                <option label="São Paulo" value="SP" />
                <option label="Sergipe" value="SE" />
                <option label="Tocantins" value="TO" />
              </select>
              <ErrorMessage name="estado" />
              <br />

              <label>CEP:</label>
              <br />
              <Field type="text" name="cep" onChange={handleChange} />

              <ErrorMessage name="cep" />
              <br />

              <input
                type="submit"
                value="Register"
                disabled={isSubmitting && !isValid}
              />
            </form>
          )}
        </Formik>
      </div>
    );
  }
}

export default App;
