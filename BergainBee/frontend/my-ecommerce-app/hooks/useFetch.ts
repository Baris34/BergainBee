import { useState, useEffect } from 'react';
import axios from 'axios';
import { Product } from '../components/Product'; // Product arayüzünü import edin

const useFetch = (url: string) => {
    const [data, setData] = useState<Product[]>([]); 
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<any>(null);
  
    useEffect(() => {
      const fetchData = async () => {
        try {
          const response = await axios.get<Product[]>(url);
          // Resim URL'lerini backgroundImage olarak güncelle
          const updatedData = response.data.map(product => ({
            ...product,
            imageUrl: product.imageUrl,
          }));
          setData(updatedData);
        } catch (err) {
          setError(err);
        } finally {
          setLoading(false);
        }
      };
  
      fetchData();
    }, [url]);
  
    return { data, loading, error };
  };

export default useFetch;