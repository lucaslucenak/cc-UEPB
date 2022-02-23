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

  const estados = [
    { value: 'Acre', label: 'AC' },
    { value: 'Alagoas', label: 'AL' },
    { value: 'Amapá', label: 'AP' },
    { value: 'Amazonas', label: 'AM' },
    { value: 'Bahia', label: 'BA' },
    { value: 'Ceará', label: 'CE' },
    { value: 'Distrito Federal', label: 'DF' },
    { value: 'Espírito Santo', label: 'ES' },
    { value: 'Goiás', label: 'GO' },
    { value: 'Maranhão', label: 'MA' },
    { value: 'Mato Grosso', label: 'MT' },
    { value: 'Mato Grosso do Sul', label: 'MS' },
    { value: 'Minas Gerais', label: 'MG' },
    { value: 'Pará', label: 'PA' },
    { value: 'Paraíba', label: 'PB' },
    { value: 'Paraná', label: 'PR' },
    { value: 'Pernambuco', label: 'PE' },
    { value: 'Piauí', label: 'PI' },
    { value: 'Rio de Janeiro', label: 'RJ' },
    { value: 'Rio Grande do Norte', label: 'RN' },
    { value: 'Rio Grande do Sul', label: 'RS' },
    { value: 'Rondônia', label: 'RO' },
    { value: 'Roraima', label: 'RR' },
    { value: 'Santa Catarina', label: 'SC' },
    { value: 'São Paulo', label: 'SP' },
    { value: 'Sergipe', label: 'SE' },
    { value: 'Tocantins', label: 'TO' }
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
          <br></br>
          <div className="container" align="center">
            <form  onSubmit={handleSubmit} className="centered">

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Nome completo*:</span>
              <input type="text" name="nome" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="nome" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Idade*:</span>
              <input type="number" name="idade" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="idade" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">CPF*:</span>
              <input type="text" name="cpf" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="cpf" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Matrícula*:</span>
              <input type="text" name="matricula" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="matricula" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Curso*:</span>
              <input type="text" name="curso" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="curso" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Endereço*:</span>
              <input type="text" name="endereco" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="endereco" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Número:</span>
              <input type="text" name="numero" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="numero" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Complemento:</span>
              <input type="text" name="complemento" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="complemento" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Bairro*:</span>
              <input type="text" name="bairro" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="bairro" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Cidade*:</span>
              <input type="text" name="cidade" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="cidade" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">Estado*:</span>
              <div class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}>
                <EstadoSelect name="estado" >
                  {estados.map((estado) => (
                  <option key={estado.value} value={estado.value}>
                      {estado.label}
                  </option>
                  ))}
                </EstadoSelect>
              </div>
            </div>
            <ErrorMessage name="estado" className="error" component="span"/>

            <br/><br/>

            <div class="input-group input-group-lg">
              <span class="input-group-text" id="inputGroup-sizing-lg">CEP*:</span>
              <input type="text" name="cep" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange}/>
            </div>
            <ErrorMessage name="cep" className="error" component="span"/>

            <br/><br/>

            <button type="submit" class="btn btn-primary" disabled={isSubmitting}>Enviar</button>

            </form>
          </div>
        </div>
      )}
    </Formik>
  )
}
export default App;