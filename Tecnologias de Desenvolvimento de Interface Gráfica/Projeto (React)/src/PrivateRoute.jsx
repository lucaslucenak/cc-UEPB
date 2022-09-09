import React from "react";
import { Navigate, useLocation } from "react-router-dom";
import { authContext } from "./components/AuthProvider";

const PrivateRoute = ({ children }) => {
    const { authed } = React.useContext(authContext);
    const location = useLocation();

    return authed ? children : <Navigate to="/login" replace state={{ from: location }}/>;
}

export default PrivateRoute;