import React from 'react';
import { View, Text, StyleSheet, ActivityIndicator, Image } from 'react-native';
import { useLocalSearchParams } from 'expo-router';
import useFetch from '../../hooks/useFetch';
import { Product } from '../../components/Product';

const ProductDetail = () => {
  const { id } = useLocalSearchParams<{ id: string }>();
  const { data: products, loading, error } = useFetch(`http://192.168.170.20:8080/products`);

  if (loading) {
    return <ActivityIndicator size="large" color="#0000ff" />;
  }

  if (error || !products) {
    return <Text>Ürün detayları yüklenirken hata oluştu.</Text>;
  }

  // ID'ye göre doğru ürünü bul
  const product = products.find(p => p.productID.toString() === id);

  if (!product) {
    return <Text>Ürün bulunamadı.</Text>;
  }

  return (
    <View style={styles.container}>
      <Text style={styles.title}>{product.name}</Text>
      <Text>ID: {product.productID}</Text>
      <Text>Fiyat: TL{product.price}</Text>
      <Text>Platform: {product.platform}</Text>
      <Image source={{ uri: product.imageUrl }} style={styles.productImage} />
      <Text>{product.details}</Text>
      {/* Diğer ürün detaylarını burada gösterebilirsiniz */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  title: {
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  productImage: {
    width: '100%',
    height: 200,
    resizeMode: 'cover',
    marginBottom: 10,
  },
});

export default ProductDetail;