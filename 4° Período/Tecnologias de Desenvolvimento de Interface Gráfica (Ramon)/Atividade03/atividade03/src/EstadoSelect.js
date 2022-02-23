import React from "react";
import { useField } from "formik";
import Select from "react-select";

function EstadoSelect({ label, ...props }) {
  const [field, meta, { setValue, setTouched }] = useField(props);
  const options = props.children.map((option) => ({
    value: option.props.value,
    label: option.props.children,
  }));

  const onChange = ({ value }) => {
    setValue(value);
  };

  return (
    <div >
      <label htmlFor={props.id || props.name}>
        {label}
      </label>
      <Select
        defaultValue={options.find((option) => option.value === field.value)}
        options={options}
        onChange={onChange}
        onBlur={setTouched}
      />

    </div>
  );
}
export default EstadoSelect;