import React from "react";
import { Navigate, Outlet, useLocation } from "react-router-dom";
import { authContext } from "./AuthProvider";

const PrivateOutlet = () => {
    const { authed } = React.useContext(authContext);
    const location = useLocation();

    return authed ? <Outlet /> : <Navigate to="/login" replace state={{ from: location }} />;
}

export default PrivateOutlet;