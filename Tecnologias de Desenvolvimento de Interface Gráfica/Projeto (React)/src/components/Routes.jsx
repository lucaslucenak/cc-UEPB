import { BrowserRouter, Route, Routes } from "react-router-dom";
import About from "./About/About";
import AuthProvider from "./AuthProvider";
import HomePage from "../pages/Home/index";
import LoginPage from "../pages/Login/index";
import Navbar from "./NavBar/index";
import NotFound from "./NotFound";
import PrivateOutlet from "./PrivateOutlet";
import PrivateRoute from "../PrivateRoute";
import RegisterPage from "../pages/Register/index";
import RegisterProject from "../pages/RegisterProject/index";
import ListProjects from "../pages/ListProjects/index";
import LinkAlumn from "../pages/LinkAlumn/index";

const Routess = () => (
    <BrowserRouter>
        <AuthProvider>
            <Navbar />
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route element={<PrivateOutlet />}>
                    <Route path="/about" element={<About />}></Route>
                    <Route path="/" element={<HomePage />}></Route>
                    <Route path="/regist-project" element={<RegisterProject />} />
                    <Route path="/list-projects" element={<ListProjects />} />
                    <Route path="/link-alumn" element={<LinkAlumn />} />
                </Route>

                <Route path="*" element={<NotFound />} />
            </Routes>
        </AuthProvider>
    </BrowserRouter>
);

export default Routess;