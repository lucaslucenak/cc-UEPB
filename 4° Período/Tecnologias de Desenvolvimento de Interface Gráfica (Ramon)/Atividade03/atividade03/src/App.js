import React from 'react';
import { Formik, ErrorMessage, Field } from 'formik';
import * as Yup from 'yup';

const FormSchema = Yup.object().shape({
  nome: Yup.string().required('Required'),
  idade: Yup.string().required('Required'),
  cpf: Yup.string().required('Required').min(14, 'CPF must be size 14! (999.999.999-99)').max(14, 'CPF must be size 14! (999.999.999-99)').matches(/^[0-9\s\.\-]*$/,'CPF can only contain numbers, dash and dot. (999.999.999-99)'),
  matricula: Yup.string().required('Required'),
  curso: Yup.string().required('Required'),
  endereco: Yup.string().required('Required'),
  numero: Yup.string().required('Required'),
  complemento: Yup.string().required('Required'),
  bairro: Yup.string().required('Required'),
  cidade: Yup.string().required('Required'),
  estado: Yup.string().required('Required'),
  cep: Yup.string().required('Required')
});


const App = () => {
  const handleSubmitting = (values, {setSubmitting, setStatus}) => {
    setStatus({ isValidating: true });
    setTimeout(() => {
      console.info(JSON.stringify(values, null, 2));
      setSubmitting(false);
      setStatus({ isValidating: false });
    }, 1000)
  }
  return (
    <Formik validationSchema={FormSchema}
    initialValues={{}}
    onSubmit={handleSubmitting}>
      {({
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
                <span class="input-group-text" id="inputGroup-sizing-lg">Idade*: <Field class="form-control" type="text" name="idade" onBlur={handleBlur} onChange={handleChange}/> </span>
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
                <span class="input-group-text" id="inputGroup-sizing-lg">Número: <Field class="form-control" type="text" name="numero" onBlur={handleBlur} onChange={handleChange}/> </span>
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

              <input type="submit" value="Enviar" class="btn btn-success" disabled={isSubmitting} />

            </form>
          </div>
        </div>
      )}
    </Formik>
  )
}
export default App;