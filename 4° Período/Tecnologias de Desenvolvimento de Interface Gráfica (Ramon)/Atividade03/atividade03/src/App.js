import React from 'react';
import { Formik, ErrorMessage, Field } from 'formik';
import * as Yup from 'yup';
import EstadoSelect from './EstadoSelect';

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

  const options = [
    { value: 'chocolate', label: 'Chocolate' },
    { value: 'strawberry', label: 'Strawberry' },
    { value: 'vanilla', label: 'Vanilla' }
  ]
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

          <div className="container" align="center">
            <form  onSubmit={handleSubmit} className="centered">

              <label className="form-group">
                Nome completo*:
                <Field className="form-control" type="text" name="nome" onBlur={handleBlur} onChange={handleChange}/>
              </label>
              <ErrorMessage name="nome" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Idade*:
              <Field className="form-control" type="number" name="idade" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="idade" className="error" component="span" />

            <br/><br/>

            <label  className="form-group">
              CPF*:
              <Field className="form-control" type="text" name="cpf" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="cpf" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Matrícula*:
              <Field className="form-control" type="text" name="matricula" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="matricula" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Curso*:
              <Field className="form-control" type="text" name="curso" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="curso" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Endereço*:
              <Field className="form-control" type="text" name="endereco" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="endereco" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Número:
              <Field className="form-control" type="text" name="numero" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="numero" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Complemento:
              <Field className="form-control" type="text" name="complemento" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="complemento" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Bairro*:
              <Field className="form-control" type="text" name="bairro" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="bairro" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Cidade*:
              <Field className="form-control" type="text" name="cidade" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="cidade" className="error" component="span"/>

            <br/><br/>

            <label  className="form-group">
              Estado*:
              <EstadoSelect name="estado">
                {options.map((option) => (
                <option key={option.value} value={option.value}>
                    {option.label}
                </option>
                ))}
              </EstadoSelect>
            </label>
            <ErrorMessage name="estado" className="error" component="span"/>

            <br/><br/>

            <label className="form-group">
              CEP*:
              <Field className="form-control" type="text" name="cep" onBlur={handleBlur} onChange={handleChange}/>
            </label>
            <ErrorMessage name="cep" className="error" component="span"/>

            <br/><br/>

            <input type="submit" value="Enviar" disabled={isSubmitting}/>

            </form>

          </div>
        </div>
      )}
    </Formik>
  )
}
export default App;