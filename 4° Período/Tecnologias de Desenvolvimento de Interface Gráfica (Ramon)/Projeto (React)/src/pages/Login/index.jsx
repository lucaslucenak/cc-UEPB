import React from "react";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import { authContext } from "../../components/AuthProvider";
import { useLocation, useNavigate, Link } from "react-router-dom";
import axios from "axios";
import './styles.css';

const LoginSchema = Yup.object().shape({
  username: Yup.string().required("Required"),
  password: Yup.string().required("Required"),
});

const LoginPage = () => {
  const { login } = React.useContext(authContext);
  let navigate = useNavigate();
  let location = useLocation();

  let from = "/";

  const handleSubmitting = (values, { setSubmitting, setStatus }) => {
    setStatus({ isValidating: true });
    axios
      .post("https://immense-sands-97611.herokuapp.com/api/v1/login", values)
      .then(resp => {
        console.log(resp)
        const { token } = resp.data
        const { status } = resp
        localStorage.setItem('token', JSON.stringify(token));
        axios.defaults.headers.common['Authorization'] = token
        if (status == 200) {
          login().then(navigate(from, { replace: true }));
        }
      })
      .catch(error => {
        alert(error)
      });
  };

  return (
    <div className="container">
      <div class="d-flex justify-content-center h-100">
        <div class="card">
          <div class="card-header">
            <h3>Sign In</h3>
          </div>
          <Formik
            validationSchema={LoginSchema}
            initialValues={{ username: "", password: "" }}
            onSubmit={handleSubmitting}
          >
            {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (

              <div class="card-body">
                <form onSubmit={handleSubmit}>
                  <div class="input-group form-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-user"></i>
                      </span>
                    </div>

                    <Field
                      class="form-control"
                      placeholder="username"
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
                  </div>

                  <div class="input-group form-group">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-key"></i>
                      </span>
                    </div>

                    <Field
                      class="form-control"
                      placeholder="password"
                      type="password"
                      name="password"
                      onBlur={handleBlur}
                      onChange={handleChange}
                    />

                    <ErrorMessage
                      name="password"
                      className="error"
                      component="span"
                    />
                  </div>

                  <div class="form-group">
                    <input
                      type="submit"
                      class="btn float-right login_btn"
                      value="Login"
                      disabled={isSubmitting}
                    />
                  </div>

                </form>
              </div>
            )}
          </Formik>
          <div class="card-footer">
            <div class="d-flex justify-content-center links">
              Don't have an account?<Link to="/register">Sign up</Link>
            </div>


          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
