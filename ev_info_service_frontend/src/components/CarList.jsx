import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { getAllCars, getByBrand } from "../services/CarListService";
import CarCard from "./CarCard";

const CarList = () => {


    const [cars, setCars] = useState([]);
    const navigate = useNavigate();

    const [brand, setBrand] = useState("");

    const filterBrand = async (e) => {
        e.preventDefault();
        const value = await document.getElementById("filter").value;
        setBrand(value);
    }


    useEffect(() => {

        if (brand === "All") {
            getAllCars().then((response) => {
                setCars(response.data);
            })
        } else if (brand) {
            getByBrand(brand).then((response) => {
                setCars(response.data);
            })
        } else {
            getAllCars().then((response) => {
                setCars(response.data);
            })
        }

    }, [brand])



    return (
        <div>
            <div>
                <div className="brand-filter">
                    <form onSubmit={filterBrand}>
                        <select id="filter">
                            <option value="All">All</option>
                            <option value="Audi">Audi</option>
                            <option value="BMW">BMW</option>
                            <option value="Mercedes">Mercedes</option>
                            <option value="Opel">Opel</option>
                            <option value="VW">Volkswagen</option>
                        </select>
                        <button id="filter-button">Submit</button>
                    </form>
                </div>
            </div>
            <div id="CarCards">
                {
                    cars.map(car =>
                        <CarCard className="CarCard" key={car.id} car={car}></CarCard>
                    )
                }
            </div>
        </div>
    )
}

export default CarList;