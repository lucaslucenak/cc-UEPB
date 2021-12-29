import React from "react";
import memoriaRAM1 from "../images/dicasTL/memoriaRAM/1.png"
import memoriaRAM2 from "../images/dicasTL/memoriaRAM/2.png"
import memoriaRAM3 from "../images/dicasTL/memoriaRAM/3.png"
import memoriaRAM4 from "../images/dicasTL/memoriaRAM/4.png"
import atalhos1 from "../images/dicasTL/6atalhosWin10/1.png"
import atalhos2 from "../images/dicasTL/6atalhosWin10/2.png"
import atalhos3 from "../images/dicasTL/6atalhosWin10/3.png"
import atalhos4 from "../images/dicasTL/6atalhosWin10/4.png"
import preservarPC1 from "../images/dicasTL/7dicasPreservarPC/1.png"
import preservarPC2 from "../images/dicasTL/7dicasPreservarPC/2.png"
import preservarPC3 from "../images/dicasTL/7dicasPreservarPC/3.png"
import preservarPC4 from "../images/dicasTL/7dicasPreservarPC/4.png"
import preservarPC5 from "../images/dicasTL/7dicasPreservarPC/5.png"

class Paragraphs extends React.Component {
    render() {
        return (
            <div align="center" className="paragraphContainer">
            <p className="FirstParagraph"><mark>Lorem Ipsum</mark> is simply dummy text of the printing and typesetting industry. Lorem Ipsum has
                been
                the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and
                scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into
                electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of
                Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like
                Aldus
                PageMaker including versions of Lorem Ipsum.</p>
                <img className="dicaMemoriaRAM" src={memoriaRAM1} alt="parte 1"></img>
                <img className="dicaMemoriaRAM" src={memoriaRAM2} alt="parte 2"></img>
                <img className="dicaMemoriaRAM" src={memoriaRAM3} alt="parte 3"></img>
                <img className="dicaMemoriaRAM" src={memoriaRAM4} alt="parte 4"></img>
            <p className="paragraph">It is a long established fact that a reader will be distracted by the readable content of a
                page when looking at
                its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as
                opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing
                packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem
                ipsum'
                will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes
                by
                accident, sometimes on purpose (injected humour and the like).</p>
                <img className="atalhosWin10" src={atalhos1} alt="parte 1"></img>
                <img className="atalhosWin10" src={atalhos2} alt="parte 2"></img>
                <img className="atalhosWin10" src={atalhos3} alt="parte 3"></img>
                <img className="atalhosWin10" src={atalhos4} alt="parte 4"></img>        
            <p className="paragraph">There are many variations of passages of Lorem Ipsum available, but the majority have
                suffered alteration in some
                form, by injected humour, or randomised words which don't look even slightly believable. If you are going to
                use
                a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of
                text.
                All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this
                the
                first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful
                of
                model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is
                therefore always free from repetition, injected humour, or non-characteristic words etc.</p>
                <img className="dicasPreservarPC" src= {preservarPC1} alt ="parte 1"></img>
                <img className="dicasPreservarPC" src= {preservarPC2} alt ="parte 2"></img>
                <img className="dicasPreservarPC" src= {preservarPC3} alt ="parte 3"></img>
                <img className="dicasPreservarPC" src= {preservarPC4} alt ="parte 4"></img>
                <img className="dicasPreservarPC" src= {preservarPC5} alt ="parte 5"></img>
            <p className="LastParagraph">Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece
                of classical Latin
                literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at
                Hampden-Sydney
                College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage,
                and
                going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum
                comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil)
                by
                Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the
                Renaissance.
                The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.</p>
                <p id="sigla">A <abbr title="Universidade Estadual da Paraíba">UEPB</abbr> é uma universidade</p>
                <mark>Marcação importante</mark>
        </div>
        );
    }
}

export default Paragraphs;