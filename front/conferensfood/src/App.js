import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './components/Home';
import "../src/css/bootstrap.min.css";
import Contact from './pages/Contact';
import Footer from './components/Footer';
import Copyright from './components/Copyright';
import Shop from "./components/Shop";


function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/shop" element={<Shop/>}/>
                    <Route path="/contact" element={<Contact/>}/>
                </Routes>
            </BrowserRouter>

        </>
    );
}

export default App;
