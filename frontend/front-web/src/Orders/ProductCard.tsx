import { ReactComponent as Pizza} from './Pizza.png';

function ProductCard() {
    return (
        <div className='order-card-container'>
            <h3 className="order-card-title">Produto 1</h3>
            <Pizza className="order-card-image"/>
            <h3 className="order-card-price">Preço</h3>
            <div className="order-card-description">
                <h3>Descrição</h3>
                <p>Uma breve descrição.</p>
            </div>
        </div>
    )
}
export default ProductCard;