import { useEffect, useState } from 'react';
import StepsHeader from './StepsHeader';
import { Product, OrderLocationData } from './types';
import './styles.css';
import { fetchProducts } from '../api';
import ProducsList from './ProductsList';
import OrderLocation from './OrderLocation';

function Orders() {
    const [products, setProducts] = useState<Product []>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div className='orders-container'>
            <StepsHeader/>
            <ProducsList products={products}/>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}/>
        </div>
    )
}
export default Orders;