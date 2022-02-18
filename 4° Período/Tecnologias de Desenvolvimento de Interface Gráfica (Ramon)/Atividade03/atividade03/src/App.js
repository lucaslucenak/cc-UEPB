import React from 'react';
import { Formik, ErrorMessage, Field } from 'formik';
import * as Yup from 'yup';

const LoginSchema = Yup.object().shape({
  nome: Yup.string().required('Required').email('Invalid'),
  idade: Yup.string().required('Required').email('Invalid'),
  cpf: Yup.string().required('Required').email('Invalid'),
  matricula: Yup.string().required('Required').email('Invalid'),
  curso: Yup.string().required('Required').email('Invalid'),
  email: Yup.string().required('Required').email('Invalid'),
  email: Yup.string().required('Required').email('Invalid'),
  email: Yup.string().required('Required').email('Invalid'),
  password: Yup.string().required('Required').min(4, 'Too short!').max(10, 'Too long!')
});


const App = () => {
  const handleSubmitting = (values, {setSubmitting, setStatus}) => {
    setStatus({ isValidating: true });
    setTimeout(() => {
      console.info(JSON.stringify(values, null, 2));
      setSubmitting(false);
      setStatus({ isValidating: false });
    }, 400)
  }
  return (
    <Formik validationSchema={LoginSchema}
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
                <span class="input-group-text" id="inputGroup-sizing-lg">Large</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg"/>
              </div>
            </form>
          </div>
        </div>
      )}
    </Formik>
  )
}
export default App;
