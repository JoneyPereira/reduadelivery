import './styles.css';
import {ReactComponent as MainImage} from './main.svg';
import Footer from '../Footer';

function Home() {
    return (
        <>
        <div className='home-container'>
            <div className='home-content'>
                <div className='home-actions'>
                    <h1>
                        Faça seu pedido <br/> que entregamos <br/> na hora!
                    </h1>
                    <h3 className='home-subtitle'>
                        Escolha o que precisa e em poucos minutos entregamos na sua porta.
                    </h3>
                    <a href='orders' className='home-btn-order'>
                        FAZER PEDIDO
                    </a>
                </div>
                <div className='home-image'>
                    <MainImage/>
                </div>
            </div>
        </div>
        <Footer/>
        </>
        
    )
}
export default Home;