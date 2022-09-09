import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { authContext } from '../AuthProvider';
import './styles.css'
import Img from '../Img/logo.png'

const Navbar = () => {
  const { authed, logout } = React.useContext(authContext);
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <header class="cabecalho">
      <div class="logo">
        <a href="#inicio">
          <img src={Img} alt="Logo" />
        </a>
      </div>
      <nav class="menu">
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/regist-project">Regist Project</Link>
          </li>
          <li>
            <Link to="/list-projects">List Projects</Link>
          </li>
          <li>
            <Link to="/link-alumn">Link Alumn</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
        </ul>

      </nav>
      <aside class="autenticacao">
        {authed && <button onClick={handleLogout} class="botao destaque">Logout</button>}
      </aside>
    </header>

  );
}

export default Navbar;