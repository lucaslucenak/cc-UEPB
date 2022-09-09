import './styles.css'
import img from '../Img/github.svg'

const About = () => (
    <div className="About container">
        <h1>About Page</h1>
        <hr />
        <p>Projeto desenvolvido para o trabalho de Tecnologias de Interface Gráficas. UEPB - Prof. Ramon</p>
        <p>
            Desenvolvidor por Daniel Xavier e Lucas de Lucena.
        </p>
        <div className="redes">
            <img src={img} alt="" className="image" />
            <ul>
                <li><a href="https://github.com/DanielXav" target="_blank">/DanielXav</a></li>
                <li><a href="https://github.com/lucaslucenak" target="_blank">/lucaslucenak</a></li>
            </ul>
        </div>
    </div>
);

export default About;