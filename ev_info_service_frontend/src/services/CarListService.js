import axios from "axios"

const REST_API_URL = "http://localhost:8080/api/cars";

//Get request to collect a list of cars
export const getAllCars = () => axios.get(REST_API_URL);

//Get request to collect a list of cars by brand
export const getByBrand = (brand) => axios.get(REST_API_URL + "/filter/" + brand);

//Get request to collect a single car by id
export const getCar = (id) => axios.get(REST_API_URL + "/" + id);