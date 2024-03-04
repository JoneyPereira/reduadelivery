import { useEffect, useState } from 'react';
import StepsHeader from './StepsHeader';
import { Product } from './types';
import './styles.css';
import { fetchProducts } from '../api';
import ProducsList from './ProductsList';

function Orders() {
    const [products, setProducts] = useState<Product []>([]);

    useEffect(() => {
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div className='orders-container'>
            <StepsHeader/>
            <ProducsList products={products}/>
        </div>
    )
}
export default Orders;