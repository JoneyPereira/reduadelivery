import './styles.css';
import {ReactComponent as YouTubeIcon} from './youtube.svg';
import {ReactComponent as LinkeDinIcon} from './linkedin.svg';
import {ReactComponent as InstagramIcon} from './instagram.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior.
            <a href='https://www.youtube.com/' target='_new'>
                <YouTubeIcon/>
            </a>
            <a href='https://www.linkedin.com/' target='_new'>
                <LinkeDinIcon/>
            </a>
            <a href='https://www.instagram.com/' target='_new'>
                <InstagramIcon/>
            </a>
        </footer>
    )
}
export default Footer;