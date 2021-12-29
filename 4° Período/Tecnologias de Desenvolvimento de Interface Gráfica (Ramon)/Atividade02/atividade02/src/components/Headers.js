import React, { useEffect } from 'react';
import LogoTL from "../images/logo.png";
import Aos from "aos";
import "aos/dist/aos.css";

const Hearders = () => {
    useEffect(() => {
        Aos.init({ duration: 2000 });
    }, [])
        return (
            <div align="center" id="header">
            <table>
                <tr>
                    <td><img id="logoTeclineHeader" src={LogoTL} alt="Logo TecLine"/></td>
                    <td>
                        <h1 className="titleHeader">Diário Eletrônico TecLine</h1>
                        <h2 align = "center" class="subtitleHeader">Manutenção em Computadores e Notebooks</h2>
                    </td>
                    <td><img id="logoTeclineHeader" src={LogoTL} alt="Logo TecLine"/></td>
                </tr>
            </table>
        </div>
        );
}

export default Hearders;