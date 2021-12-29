import React from "react";
import LogoTL from "../images/logo.png"

class Logo extends React.Component {
    render() {
        return (
            <div className ="logoContainer" align="center">
            <abbr title = "Logo da melhor assistência de CG"/><img class="logoTecline" src={LogoTL} alt="Logo TecLine"></img><br/><abbr/>
            <span className="logoLegend"> TecLine Assistência Técnica</span>
            </div>
        );
    }
}

export default Logo;