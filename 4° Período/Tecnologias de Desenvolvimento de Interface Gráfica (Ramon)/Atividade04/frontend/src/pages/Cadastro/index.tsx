import axios from "axios";
import { Formik, ErrorMessage, Field } from "formik";
import * as Yup from "yup";
import SelectInput from './selectInput';
import { BASE_URL } from "../../utils/requests";

const FormSchema = Yup.object().shape({
    username: Yup.string().required("Informe seu username!"),
    password: Yup.string().required("Informe sua senha!"),
    matricula: Yup.string().required("Informe sua matricula!"),
    papel: Yup.string().required("Informe seu papel!"),
    funcao: Yup.string().required("Informe sua funcao!"),
});

const Login = () => {

    axios.get(`${BASE_URL}/api/v1/projects`)
        .then(res => {
            console.log(res.data);
        })

    const handleSubmitting = (values: any, { setSubmitting, setStatus }: any) => {
        setStatus({ isValidating: true });
        setTimeout(() => {
            console.info(JSON.stringify(values, null, 2));
            setSubmitting(false);
            setStatus({ isValidating: false });
        }, 1000);
        alert(JSON.stringify(values.papel));
    };

    const optionsRoles = [
        { value: "alumn", label: 'ALUMN' },
        { value: "teacher", label: 'TEACHER' }
    ]

    const optionsFunctions = [
        { value: "trainee", label: 'TRAINEE' },
        { value: "junior", label: 'JUNIOR' },
        { value: "senior", label: 'SENIOR' },
        { value: "master", label: 'MASTER' },
        { value: "coordinator", label: 'COORDINATOR' }
    ]

    return (
        <Formik
            validationSchema={FormSchema}
            initialValues={{
                username: "",
                password: "",
                matricula: "",
                papel: "",
                funcao: ""
            }}
            onSubmit={handleSubmitting}
        >
            {({ handleChange, handleBlur, handleSubmit, isSubmitting }) => (
                <div className="container">
                    <div className="div-class-conteiner">
                        <div className="text-center mt-5">
                            <form onSubmit={handleSubmit} />
                            <img className="mt-4" src="./img/logo.svg" alt="" height="72" />
                            <h1 className="h3 mb-3 font-weight-normal">Cadastro</h1>

                            <div>
                                <input type="text" placeholder="Usuário" name="username" className="form-control mt-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange} />
                            </div>
                            <ErrorMessage name="username" className="error" component="span" />

                            <div>
                                <input type="password" placeholder="Senha" name="password" className="form-control mt-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange} />
                            </div>
                            <ErrorMessage name="password" className="error" component="span" />

                            <div>
                                <input type="text" placeholder="Matrícula" name="matricula" className="form-control mt-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" onBlur={handleBlur} onChange={handleChange} />
                            </div>
                            <ErrorMessage name="matricula" className="error" component="span" />

                            <SelectInput name="papel" label={undefined}>
                                {optionsRoles.map((option) => (
                                    <option key={option.value} value={option.value}>
                                        {option.label}
                                    </option>
                                ))}
                            </SelectInput>
                            <ErrorMessage name="papel" className="error" component="span" />
                                    
                            <SelectInput name="funcao" label={undefined}>
                                {optionsFunctions.map((option) => (
                                    <option key={option.value} value={option.value}>
                                        {option.label}
                                    </option>
                                ))}
                            </SelectInput>
                            <ErrorMessage name="funcao" className="error" component="span" />


                            <div className="d-grid gap-2 mt-3">
                                <input type="submit" value="Enviar" className="btn btn-primary" disabled={isSubmitting} />
                            </div>
                            <form />
                        </div>
                    </div>
                </div>
            )}
        </Formik>
    );
}

export default Login;