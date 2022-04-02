import React from "react";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import axios from "axios";

import "./styles.css";

const RegisterSchema = Yup.object().shape({
  description: Yup.string().required("Required"),
  name: Yup.string().required("Required"),
});

const RegisterProject = () => {
  const handleSubmitting = (values, { setSubmitting, setStatus }) => {
    setStatus({ isValidating: true });
    axios
      .post("https://immense-sands-97611.herokuapp.com/api/v1/projects", values)
      .then((resp) => console.log(resp.data))
      .catch(error => {
        alert(error)
      });
  };

  return (
    <Formik
      validationSchema={RegisterSchema}
      initialValues={{ description: "", name: "" }}
      onSubmit={handleSubmitting}
    >
      {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (
        <div className="container" id="cardRegisterProject">
          <form onSubmit={handleSubmit}>
            <div class="form-group margin">
              <label>Description</label>
              <Field
                placeholder="Your project description"
                class="form-control"
                type="text"
                name="description"
                onBlur={handleBlur}
                onChange={handleChange}
              />

              <ErrorMessage
                name="description"
                className="error"
                component="span"
              />
            </div>
            <div class="form-group">
              <label>Name</label>
              <Field
                placeholder="Your project name"
                class="form-control"
                type="text"
                name="name"
                onBlur={handleBlur}
                onChange={handleChange}
              />

              <ErrorMessage name="name" className="error" component="span" />
            </div>

            <input
              class="btn btn-primary"
              type="submit"
              value="Register"
              disabled={isSubmitting}
            />
          </form>
        </div>
      )}
    </Formik>
  );
};

export default RegisterProject;