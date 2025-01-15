import React from 'react';
import { View, Text, Image, StyleSheet, TouchableOpacity } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import Colors from '../constants/Colors';
import axios from 'axios';
import { Link } from 'expo-router';

interface Product {
  productID: number;
  name: string;
  price: number;
  details: string;
  category: string;
  platform: string;
  url: string;
  imageUrl: string;
}

interface ProductCardProps {
  product: Product;
  userId: number;
}

const ProductCard: React.FC<ProductCardProps> = ({ product, userId }) => {
  const addToFavorites = async () => {
    try {
      const response = await axios.post(
        `http://192.168.1.104:8080/products/${product.productID}/favorites/add/${userId}`
      );
      console.log(response.data);
      // Gerekirse kullanıcıya geri bildirim verin (örneğin, bir Toast mesajı gösterin)
    } catch (error) {
      console.error("Error adding product to favorites:", error);
    }
  };

  const removeFromFavorites = async () => {
    try {
      const response = await axios.post(
        `http://192.168.1.104:8080/products/${product.productID}/favorites/remove/${userId}`
      );
      console.log(response.data);
      // Gerekirse kullanıcıya geri bildirim verin (örneğin, bir Toast mesajı gösterin)
    } catch (error) {
      console.error("Error removing product from favorites:", error);
    }
  };


  return (
    <View style={styles.card}>
      <Link
        href={{
          pathname: '/product/[id]', // Ürün detay sayfası yolu
          params: { id: product.productID }, // Ürün ID'sini parametre olarak geçirin
        }}
        asChild
      >
        <TouchableOpacity>
          <Image source={{ uri: product.url }} style={styles.image} />
        </TouchableOpacity>
      </Link>

      <Text style={styles.brand}>{product.platform}</Text>
      <Text style={styles.name}>{product.name}</Text>
      <Text style={styles.price}>{`TL ${product.price.toFixed(2)}`}</Text>
      <TouchableOpacity style={styles.heartIcon} onPress={addToFavorites}>
        <Ionicons name="heart-outline" size={24} color={Colors.secondary} />
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: Colors.white,
    borderRadius: 10,
    padding: 10,
    margin: 10,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
    width: '45%',
  },
  image: {
    width: '100%',
    height: 150,
    resizeMode: 'cover',
    marginBottom: 5,
  },
  brand: {
    fontSize: 16,
    fontWeight: 'bold',
    color: Colors.text,
  },
  name: {
    fontSize: 14,
    color: Colors.grey,
  },
  price: {
    fontSize: 16,
    fontWeight: 'bold',
    color: Colors.primary,
    marginTop: 5,
  },
  heartIcon: {
    position: 'absolute',
    top: 10,
    right: 10,
  },
});

export default ProductCard;