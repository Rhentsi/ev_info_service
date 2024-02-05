import { useState } from "react";
import { useNavigate } from "react-router-dom";

//Loads a card for each car that is saved in the database

const CarCard = ({ car }) => {

    const [url] = useState(`/car/${car.id}`)

    const navigate = useNavigate();

    const goToCar = () => {
        navigate(url);
    }

    return (
        <div className="card" onClick={goToCar}>
            <img className="card-image" alt="car-image" src={car.image}></img>
            <h4 className="card-title">{car.brand} {car.name}</h4>
            <table width="250px">
                <thead>
                    <tr>
                        <th>Price</th>
                        <th>Range</th>
                        <th>Efficiency</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>{car.price}€</td>
                        <td>{car.range} km</td>
                        <td>{car.efficiency} Wh/km</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default CarCard;