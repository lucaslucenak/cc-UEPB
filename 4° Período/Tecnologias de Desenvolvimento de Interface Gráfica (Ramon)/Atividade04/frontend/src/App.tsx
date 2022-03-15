import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Navbar from "./components/NavBar";
import AuthProvider from "./components/AuthProvider/AuthProvider";

function App() {
  return (
    <BrowserRouter>
      <AuthProvider>
        <Navbar />
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/cadastrar" element={<Cadastro />} />
        </Routes>
      </AuthProvider>
    </BrowserRouter>
  );
}

export default App;
