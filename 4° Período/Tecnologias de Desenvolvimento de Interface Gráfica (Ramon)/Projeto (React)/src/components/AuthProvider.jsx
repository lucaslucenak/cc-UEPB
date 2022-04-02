import React from "react";
import useAuth from "../hooks/useAuth";

const authContext = React.createContext(null);

const AuthProvider = ({ children }) => {
    const auth = useAuth();

    return <authContext.Provider value={auth}>{children}</authContext.Provider>
}

export { authContext };

export default AuthProvider;