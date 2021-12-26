import React from 'react';

class Hearders extends React.Component {
    render() {
        return (
            <div align="center" id="header">
            <table>
                <tr>
                    <td><img id="logoTeclineHeader" src="../images/TL Assistência Técnica.png" alt="Logo TecLine"/></td>
                    <td>
                        <h1 className="titleHeader">Diário Eletrônico TecLine</h1>
                        <h2 align = "center" class="subtitleHeader">Manutenção em Computadores e Notebooks</h2>
                    </td>
                    <td><img id="logoTeclineHeader" src="../images/TL Assistência Técnica.png" alt="Logo TecLine"/></td>
                </tr>
            </table>
        </div>
        );
    }
}

export default Hearders;