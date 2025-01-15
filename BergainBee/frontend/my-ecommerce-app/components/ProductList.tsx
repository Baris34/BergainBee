import React, { useState, useEffect } from 'react';
import { View, Text, FlatList, StyleSheet, ActivityIndicator, Image, TouchableOpacity } from 'react-native';
import useFetch from '../hooks/useFetch';
import Colors from '../constants/Colors';
import { Ionicons } from '@expo/vector-icons';
import { Link, useLocalSearchParams } from 'expo-router';
import axios from 'axios';
import { Product } from '../components/Product'; // Product arayüzünü import edin

interface ProductCardProps {
    product: Product;
    userId: number;
  }
  
  const ProductCard: React.FC<ProductCardProps> = ({ product, userId }) => {
    const addToFavorites = async () => {
        try {
          const response = await axios.post(
            `http://192.168.1.101:8080/products/${product.productID}/favorites/add/${userId}`
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
            `http://192.168.1.101:8080/products/${product.productID}/favorites/remove/${userId}`
          );
          console.log(response.data);
          
        } catch (error) {
          console.error("Error removing product from favorites:", error);
        }
      };
    return (
      <View style={styles.card}>
        <Link
          href={{
            pathname: "/product/[id]", 
            params: { id: product.productID }, 
          }}
          asChild
        >
          <TouchableOpacity>
            <Image source={{ uri: product.imageUrl }} style={styles.image} />
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
  
  const productstyles = StyleSheet.create({
    card: {
      backgroundColor: Colors.white,
      borderRadius: 10,
      padding: 10,
      margin: 10,
      shadowColor: '#000',
      shadowOffset: { width: 0, height: 2 },
      shadowOpacity: 0.1,
      shadowRadius: 4,
      elevation: 3, // Android için gölge efekti
      width: '45%', // Ekran genişliğinin yarısı
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
interface ProductListProps {
    selectedCategory: string | null;
    userId: number;
  }
  
  const ProductList: React.FC<ProductListProps> = ({ selectedCategory, userId }) => {
    const { data: products, loading, error } = useFetch('http://192.168.170.20:8080/products');
  
    if (loading) {
      return (
        <View style={styles.container}>
          <ActivityIndicator size="large" color="#0000ff" />
        </View>
      );
    }
  
    if (error) {
      return (
        <View>
          <Text>Ürünler yüklenirken bir hata oluştu.</Text>
        </View>
      );
    }
  
    // Ürünleri kategoriye göre filtrele
    const filteredProducts = selectedCategory && products
    ? products.filter((product: Product) => product.category.toLowerCase() === selectedCategory.toLowerCase())
    : products || [];
  
    return (
      <FlatList
        data={filteredProducts}
        renderItem={({ item }) => <ProductCard product={item} userId={userId}/>}
        keyExtractor={(item) => item.productID.toString()}
        numColumns={2} // İki sütunlu görünüm
      />
    );
  };
  
  const styles = StyleSheet.create({
      container: {
        flex: 1,
        padding: 20,
      },
      item: {
        backgroundColor: '#f9c2ff',
        padding: 20,
        marginVertical: 8,
        marginHorizontal: 16,
      },
      title: {
        fontSize: 18,
      },
      card: {
        backgroundColor: Colors.white,
        borderRadius: 10,
        padding: 10,
        margin: 10,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.1,
        shadowRadius: 4,
        elevation: 3, // Android için gölge efekti
        width: '45%', // Ekran genişliğinin yarısı
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
  
  export default ProductList;