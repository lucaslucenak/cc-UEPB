import React from "react";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import SelectInput from "../../components/SelectInput";
import { Link } from "react-router-dom";

import "./styles.css";

const RegisterSchema = Yup.object().shape({
  username: Yup.string().required("Required"),
  password: Yup.string()
    .required("Required")
    .min(4, "Too short!")
    .max(10, "Too long!"),
  registration: Yup.string().required("Informe sua registration!"),
  role: Yup.string().required("Informe seu role!"),
  function: Yup.string().required("Informe sua function!"),
});

const RegisterPage = () => {
  const handleSubmitting = (values, { setSubmitting, setStatus }) => {
    setStatus({ isValidating: true });
    axios
      .post("https://immense-sands-97611.herokuapp.com/api/v1/signup", values)
      .then((resp) => console.log(resp));
  };

  const navigate = useNavigate();

  const handleRegister = () => {
    setTimeout(() => {
      navigate("/login");
    }, 400);
  };

  const optionsRoles = [
    { value: "ALUMN", label: "ALUMN" },
    { value: "TEACHER", label: "TEACHER" },
  ];

  const optionsFunctions = [
    { value: "TRAINEE", label: "TRAINEE" },
    { value: "JUNIOR", label: "JUNIOR" },
    { value: "SENIOR", label: "SENIOR" },
    { value: "MASTER", label: "MASTER" },
    { value: "COORDINATOR", label: "COORDINATOR" },
  ];

  return (
    <Formik
      validationSchema={RegisterSchema}
      initialValues={{
        username: "",
        password: "",
        registration: "",
        role: "",
        function: "",
      }}
      onSubmit={handleSubmitting}
    >
      {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (
        <div class="container" id="cardRegister">
          <form onSubmit={handleSubmit}>
            <div class="form-group marginRegister">
              <label>Username</label>
              <Field
                placeholder="Be creative!"
                class="form-control"
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

            <div class="form-group">
              <label>Password</label>
              <Field
                placeholder="A strong one please!"
                class="form-control"
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
              <label>Registration</label>
              <Field
                placeholder="example: 123456789"
                class="form-control"
                type="number"
                name="registration"
                onBlur={handleBlur}
                onChange={handleChange}
              />

              <ErrorMessage
                name="registration"
                className="error"
                component="span"
              />
            </div>

            <div class="form-group">
              <label>Role</label>
              <div className="label">
                <SelectInput name="role">
                  {optionsRoles.map((option) => (
                    <option key={option.value} value={option.value}>
                      {option.label}
                    </option>
                  ))}
                </SelectInput>
              </div>
              <ErrorMessage name="role" className="error" component="span" />
            </div>
            <div class="form-group">
              <label>Function</label>
              <div className="labelRegister">
                <SelectInput name="function">
                  {optionsFunctions.map((option) => (
                    <option key={option.value} value={option.value}>
                      {option.label}
                    </option>
                  ))}
                </SelectInput>
              </div>
              <ErrorMessage
                name="function"
                className="error"
                component="span"
              />
            </div>

            <input
              class="btn btn-primary"
              type="submit"
              value="Register"
              disabled={isSubmitting}
              onClick={handleRegister}
            />
          </form>
          <div class="card-footer">
            <div class="d-flex justify-content-center links">
              Already have an account?<Link to="/login">Sign In</Link>
            </div>
          </div>
        </div>
      )}
    </Formik>
  );
};

export default RegisterPage;