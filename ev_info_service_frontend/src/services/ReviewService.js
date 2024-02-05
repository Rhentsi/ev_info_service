import axios from "axios";

const REST_API_URL = "http://localhost:8080/api/reviews";

//Get request to collect all reviews
export const getAllReviews = () => axios.get(REST_API_URL);

//Post request to write a new review
export const writeReview = (review) => axios.post(REST_API_URL, review);