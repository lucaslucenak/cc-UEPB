import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';

ReactDOM.render( //Atribua todo o conteúdo do componente App onde tiver o id = root no index .html
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);