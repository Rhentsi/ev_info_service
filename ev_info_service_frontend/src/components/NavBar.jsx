import logo from "../assets/car-icon.png"

const NavBar = () => {
    return (
        <nav className="navbar navbar-expand-sm bg-light navbar-light">
            <div className="container-fluid">
                <a className="nav-link active" href="/">
                    <img src={logo} width="100px" height="70px"></img>
                </a>
                <a className="nav-link active" href="/">
                    <h1>BEV Database</h1>
                </a>
                <ul className="navbar-nav">
                    <li className="nav-item">
                        <a className="nav-link active" href="/">Home</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/review">Review</a>
                    </li>
                </ul>
            </div>
        </nav>
    )
}

export default NavBar;