import React from "react";
import Hearders from "./Headers";
import Logo from "./Logo";
import Paragraphs from "./Paragraphs";
import Footer from "./Footer";

/*function App() {
  return (
    <div>
      Olá mundo
    </div>
  );
}*/

class App extends React.Component {
  render() {
    return (
      <div>
        <Hearders />
        <Logo />
        <Paragraphs />
        <Footer />
      </div>
    );
  }
}

export default App;
