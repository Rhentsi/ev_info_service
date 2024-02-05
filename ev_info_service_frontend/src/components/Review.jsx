const Review = ({ review }) => {
    return (
        <div id="review">
            <table>
                <thead>
                    <tr>
                        <th>{review.username} says:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td >{review.comment}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}

export default Review;