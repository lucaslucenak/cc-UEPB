import React from "react";

class Logo extends React.Component {
    render() {
        return (
            <div className ="logoContainer" align="center">
            <abbr title = "Logo da melhor assistência de CG"/> <img class="logoTecline" src="TL Assistência Técnica.png" alt="Logo TecLine"/> <br/><abbr/>
            <span className="logoLegend"> TecLine Assistência Técnica</span>
            </div>
        );
    }
}

export default Logo;