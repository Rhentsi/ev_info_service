import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getCar } from "../services/CarListService";

//Upon clicking a car, load this profile to gain learn about additional specs

const CarProfile = (props) => {


    const [car, setCar] = useState({});

    const { id } = useParams();


    useEffect(() => {
        getCar(id).then((response) => {
            setCar(response.data);
        })
    }, [])

    return (
        <div id="profile-container">
            <div id="head" className="d-flex justify-content-center">
                <h5>{car.brand} {car.name}</h5>
            </div>
            <div id="bottom" className="d-flex justify-content-center">
                <img id="profileImage" className="p-2" src={car.image} width="700px" height="400px"></img>
            </div>
            <div>
                <div id="car-data" className="d-flex justify-content-start">
                    <table id="left-table" className="table table-striped">
                        <thead>
                            <tr>
                                <th>Performance:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Acceleration 0-100: </td>
                                <td align="right">{car.acceleration}s</td>
                            </tr>
                            <tr>
                                <td>Top speed: </td>
                                <td align="right">{car.topSpeed} km/h</td>

                            </tr>
                            <tr>
                                <td>Range: </td>
                                <td align="right">{car.range} km</td>
                            </tr>
                        </tbody>
                    </table>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th>Battery:</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Price: </td>
                                <td align="right">{car.price}€</td>
                            </tr>
                            <tr>
                                <td>Efficiency: </td>
                                <td align="right">{car.price} Wh/km</td>
                            </tr>
                            <tr>
                                <td>Battery capacity: </td>
                                <td align="right">{car.batteryCapacity} kWh</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div >
    )
}

export default CarProfile;