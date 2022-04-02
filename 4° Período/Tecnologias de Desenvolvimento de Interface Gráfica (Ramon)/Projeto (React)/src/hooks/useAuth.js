import React from "react";

const useAuth = () => {
    const [authed, setAuthed] = React.useState(false);

    const login = () => new Promise(() => {
        setAuthed(true);
        setTimeout(() => {
            console.log('login', authed);
        }, 2000);
    });

    const logout = () => new Promise(() => {
        setAuthed(false);
        setTimeout(() => {
            console.log('login', authed);
        }, 2000);
    });

    return { authed, login, logout };
}

export default useAuth;