import { useEffect, useState } from "react";
import { getAllReviews, writeReview } from "../services/ReviewService";
import Review from "./Review";

//Interface that allows to view and write reviews

const ReviewComponent = () => {

    const [username, setUsername] = useState("");
    const [comment, setComment] = useState("");

    const [reviews, setReviews] = useState([]);

    useEffect(() => {
        getAllReviews().then((response) => {
            setReviews(response.data);
        })
    }, [])

    const sendReview = async (e) => {

        const review = { username, comment };

        writeReview(review).then((response) => {
            getAllReviews();
        })
    }

    return (
        <div id="profile-container">
            <div id="head" className="d-flex justify-content-center">
                <h3>Share your experience!</h3>
            </div>
            <div id="bottom">
                {
                    reviews.map(review =>
                        <Review key={review.id} review={review}></Review>)
                }
            </div>
            <div className="container">
                <br /> <br />
                <div className="row">
                    <div className="col-md-6 offset-md-3 offset-md-3">
                        <div>
                            <form onSubmit={sendReview}>
                                <div className="form-group mb-2">
                                    <input
                                        type="text"
                                        placeholder="Username"
                                        value={username}
                                        onChange={(e) => setUsername(e.target.value)}
                                        className="form-control">
                                    </input>
                                </div>
                                <div className="form-group mb-2">
                                    <textarea
                                        type="text"
                                        placeholder="Share your experience"
                                        value={comment}
                                        onChange={(e) => setComment(e.target.value)}
                                        className="form-control">
                                    </textarea>
                                </div>

                                <button className="btn btn-success">Submit</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div >
    )
}

export default ReviewComponent;