import React from 'react';
import { Formik, ErrorMessage, Field } from 'formik';
import * as Yup from 'yup';

const FormSchema = Yup.object().shape({
  nome: Yup.string().required('Informe seu nome!'),
  idade: Yup.number().required('Informe sua idade!').positive('Informe um número postivo!').integer('Informe um número inteiro!').min(16, 'Idade menor que 16 anos!'),
  cpf: Yup.string().required('Informe seu CPF!').min(14, 'Informe um CPF válido (999.999.999-99)').max(14, 'Informe um CPF válido (999.999.999-99)').matches(/^[0-9\s\.\-]*$/,'Informe um CPF válido (999.999.999-99)'),
  matricula: Yup.string().required('Informe sua matrícula!').min(9, 'Informe a matrícula com 9 dígitos!').max(9, 'Informe a matrícula com 9 dígitos!').matches(/^[0-9\s\-]*$/, 'Informe uma Matrícula com números apenas'),
  curso: Yup.string().required('Informe seu curso!'),
  endereco: Yup.string().required('Informe seu endereço!'),
  numero: Yup.number(),
  complemento: Yup.string(),
  bairro: Yup.string().required('Informe seu bairro!'),
  cidade: Yup.string().required('Informe sua cidade!'),
  estado: Yup.string().required('Informe seu estado!'),
  cep: Yup.string().required('Informe seu CEP!').min(9, 'Informe um CEP válido (00000-000)').max(9, 'Informe um CEP válido (00000-000)').matches(/^[0-9\s\-]*$/, 'Informe um CEP válido')
});


const App = () => {
  const handleSubmitting = (values, {setSubmitting, setStatus}) => {
    setStatus({ isValidating: true });
    setTimeout(() => {
      console.info(JSON.stringify(values, null, 2));
      setSubmitting(false);
      setStatus({ isValidating: false });
    }, 1000)
    alert(JSON.stringify(values));
  }
  return (
    <Formik validationSchema={FormSchema}
    initialValues={{ nome: '',
      idade: '',
      cpf: '',
      matricula: '',
      curso: '', 
      endereco: '',
      numero: '', 
      complemento: '', 
      bairro: '', 
      cidade: '', 
      estado: '', 
      cep: ''}}
    onSubmit={handleSubmitting}>{({
        handleChange,
        handleBlur,
        handleSubmit,
        isSubmitting,
      }) => (
        <div>

          <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">TecLine Assistência Técnica</a>
            </div>
          </nav>

          <div className="container">
            <form onSubmit={handleSubmit}>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Nome*: <Field class="form-control" type="text" name="nome" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="nome" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Idade*: <Field class="form-control" type="number" name="idade" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="idade" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">CPF*: <Field class="form-control" type="text" name="cpf" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="cpf" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Matrícula*: <Field class="form-control" type="text" name="matricula" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="matricula" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Curso*: <Field class="form-control" type="text" name="curso" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="curso" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Endereço*: <Field class="form-control" type="text" name="endereco" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="endereco" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Número: <Field class="form-control" type="idade" name="numero" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="numero" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Complemento: <Field class="form-control" type="text" name="complemento" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="complemento" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Bairro*: <Field class="form-control" type="text" name="bairro" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="bairro" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Cidade*: <Field class="form-control" type="text" name="cidade" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="cidade" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">Estado*: <Field class="form-control" type="text" name="estado" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="estado" className="error" component="span"/>
              </div>

              <div class="input-group input-group-lg">
                <span class="input-group-text" id="inputGroup-sizing-lg">CEP*: <Field class="form-control" type="text" name="cep" onBlur={handleBlur} onChange={handleChange}/> </span>
                <ErrorMessage name="cep" className="error" component="span"/>
              </div>

              <button type="submit">Enviar</button>

              

            </form>
          </div>
        </div>
      )}
    </Formik>
  )
}
export default App;