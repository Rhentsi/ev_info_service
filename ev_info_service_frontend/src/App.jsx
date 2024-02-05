import './App.css'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import NavBar from './components/NavBar';
import CarList from './components/CarList';
import CarProfile from './components/CarProfile';
import ReviewComponent from './components/ReviewComponent';

function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path="/" element={<CarList />} />
        <Route path="/car/:id" element={<CarProfile />} />
        <Route path="/review" element={<ReviewComponent />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
