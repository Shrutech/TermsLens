import "./Navbar.css";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <header className="navbar-shell">
      <nav className="navbar container">
        <div className="left-group">
          <Link className="brand" to="/">
            <span className="brand-text">TermLens</span>
          </Link>

          <div className="nav-links">
            <Link to="/why-matters">Why Matter?</Link>
            <Link to="/about-us">AboutUs</Link>
          </div>
        </div>

        <Link className="nav-cta" to="/analyze">
          Begin Analysis
        </Link>
      </nav>
    </header>
  );
}
