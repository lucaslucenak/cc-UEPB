import { ReactComponent as GithubIcon } from '../../assets/img/github.svg';
import { Link, useNavigate } from 'react-router-dom';
import { authContext } from '../AuthProvider/AuthProvider';
import './styles.css'
import React from 'react';

function Navbar() {
    const { authed, logout } = React.useContext(authContext);
    const navigate = useNavigate();
  
    const handleLogout = () => {
      logout();
      navigate("/login");
    };

    return (
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>Gerenciamento de Projetos - TDIG</h1>
                    <a target="_blank" href="https://github.com/DanielXav">
                        <div className='dsvmovie-contact-container'>
                            <GithubIcon />
                            <p className='dsmovie-contact-link'>/DanielXav</p>
                            <a target="_blank" href="https://github.com/lucaslucenak">
                            <p className='dsmovie-contact-link'>/lucaslucenak</p>
                            </a>
                        </div>
                    </a>
                    {authed && <button onClick={handleLogout}>Logout</button>}

                </div>
            </nav>
        </header>
    );
}

export default Navbar;