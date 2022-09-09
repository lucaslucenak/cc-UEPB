import React from "react";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import axios from "axios";
import SelectInput from "../../components/SelectInput";
import "./stylesLinkAlumn.css";

const LinkSchema = Yup.object().shape({
  function: Yup.string().required("Required"),
  projectId: Yup.string().required("Required"),
  username: Yup.string().required("Required"),
});

const LinkAlumn = () => {
  const handleSubmitting = (values, { setSubmitting, setStatus }) => {
    setStatus({ isValidating: true });
    axios
      .post(
        "https://immense-sands-97611.herokuapp.com/api/v1/projects/link?credentials=%7B%7D&details=%7B%7D&principal=%7B%7D",
        values
      )
      .then((resp) => console.log(resp));
  };

  const optionsFunctions = [
    { value: "TRAINEE", label: "TRAINEE" },
    { value: "JUNIOR", label: "JUNIOR" },
    { value: "SENIOR", label: "SENIOR" },
    { value: "MASTER", label: "MASTER" },
    { value: "COORDINATOR", label: "COORDINATOR" },
  ];

  return (
    <Formik
      validationSchema={LinkSchema}
      initialValues={{ function: "", projectId: "", username: "" }}
      onSubmit={handleSubmitting}
    >
      {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (
        <div class="container" id="cardLinkAlumn">
          <form onSubmit={handleSubmit}>
            <div class="form-group margin">
              <label>Function</label>
              <div class="labelProjectId">
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

            <div class="form-group">
              <label>Project Id*</label>

              <Field
                placeholder="Your Project Id"
                class="form-control"
                type="number"
                name="projectId"
                onBlur={handleBlur}
                onChange={handleChange}
              />

              <ErrorMessage
                name="projectId"
                className="error"
                component="span"
              />
            </div>

            <div class="form-group">
              <label>Username*</label>

              <Field
                placeholder="Your username"
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

export default LinkAlumn;
