import { Link } from "react-router-dom";
import "./styles.css";

const HomePage = () => (
  <div className="container margin">
    <div class="card-deck fonts">
      <div class="card">
        <div class="card-body">
          <h5 class="card-title bold">Regist Project</h5>
          <p class="card-text">Registra seus projetos!</p>
        </div>
        <div class="card-footer">
          <Link to="/regist-project">
            <label class="btn btn-primary">Regist Project</label>
          </Link>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
          <h5 class="card-title bold">List Projects</h5>
          <p class="card-text">Listagem de todos os projetos cadastrados!</p>
        </div>
        <div class="card-footer">
          <Link to="/list-projects">
            <label class="btn btn-primary">List Projects</label>
          </Link>{" "}
        </div>
      </div>
      <div class="card">
        <div class="card-body">
          <h5 class="card-title bold">Link Alumn</h5>
          <p class="card-text">Linka alunos para o projeto!</p>
        </div>
        <div class="card-footer">
          <Link to="/link-alumn">
            <label class="btn btn-primary">Link Alumn</label>
          </Link>{" "}
        </div>
      </div>
    </div>
  </div>
);

export default HomePage;
