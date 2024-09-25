import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Home from './components/Home';
import "../src/css/bootstrap.min.css";
import Contact from './pages/Contact';
import Shop from "./components/Shop";
import CityHome from "./components/City/CityHome";


function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/shop" element={<Shop/>}/>
                    <Route path="/contact" element={<Contact/>}/>
                    <Route path="/city" element={<CityHome/>}/>
                </Routes>
            </BrowserRouter>

        </>
    );
}

export default App;
