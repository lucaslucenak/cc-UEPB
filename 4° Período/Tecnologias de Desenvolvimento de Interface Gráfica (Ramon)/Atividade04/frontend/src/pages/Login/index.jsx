import React from "react";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import { authContext } from "../../components/AuthProvider/AuthProvider";
import { useLocation, useNavigate } from "react-router-dom";

const LoginSchema = Yup.object().shape({
  username: Yup.string().required("Required"),
  password: Yup.string()
    .required("Required")
    .min(4, "Too short!")
    .max(10, "Too long!"),
});

const LoginPage = () => {
  const { login } = React.useContext(authContext);
  let navigate = useNavigate();
  let location = useLocation();

  let from = location.state?.from || "/cadastrar";

  const handleSubmitting = (values, { setSubmitting, setStatus }) => {
    setStatus({ isValidating: true });
    login().then(navigate(from, { replace: true }));
    setTimeout(() => {
      console.info(JSON.stringify(values, null, 2));
      setSubmitting(false); // iremos fazer modificações aqui
      setStatus({ isValidating: false });
    }, 400);
  };

  return (
    <Formik
      validationSchema={LoginSchema}
      initialValues={{ username: "", password: "" }}
      onSubmit={handleSubmitting}
    >
      {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (
        <div className="container">
          <div className="div-class-conteiner">
            <div className="text-center mt-5">
              <form onSubmit={handleSubmit}>
                <Field
                  placeholder="Usuário"
                  className="form-control mt-3"
                  type="text"
                  name="username"
                  onBlur={handleBlur}
                  onChange={handleChange}
                />
                <ErrorMessage
                  name="username"
                  className="error"
                  component="span"
                />
                
                <br />
                <br />

                <Field
                  type="password"
                  placeholder="Senha"
                  name="password"
                  className="form-control mt-3"
                  onBlur={handleBlur}
                  onChange={handleChange}
                />

                <ErrorMessage
                  name="password"
                  className="error"
                  component="span"
                />
                <br />
                <br />
                <input
                  className="btn btn-primary"
                  type="submit"
                  value="Cadastrar usuário"
                  disabled={isSubmitting}
                />
              </form>
            </div>
          </div>
        </div>
      )}
    </Formik>
  );
};

export default LoginPage;
