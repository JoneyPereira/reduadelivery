import './styles.css';
import {ReactComponent as Logo} from './logo.svg';
import { Link } from 'react-router-dom';

function Navbar() {
    return (
        <nav className="main-navbar">
            <Logo />
            <a href="/" className="logo-text">Redua Delivery</a>
        </nav>
    )
}
export default Navbar;