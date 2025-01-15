import React, { useState, useEffect } from 'react';
import { StyleSheet, View, FlatList, Text, TouchableOpacity, ActivityIndicator } from 'react-native';
import { Link, useLocalSearchParams } from 'expo-router';
import ProductList from '../../components/ProductList'; // ProductList bileşenini import edin
import SearchBar from '../../components/SearchBar'; // SearchBar import'u
import Colors from '../../constants/Colors'; // Renk tanımlarını import edin
import { Ionicons } from '@expo/vector-icons'; // Geri ikonu için

const categories = ['Shoes', 'Electronics', 'Fashions', 'Accessories', 'Bags'];

export default function TabOneScreen() {
  const [selectedCategory, setSelectedCategory] = useState<string | null>(null);

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity onPress={() => { /* Handle back action */ }}>
          <Ionicons name="chevron-back" size={24} color={Colors.black} />
        </TouchableOpacity>
        <SearchBar onSearch={() => {}} />
      </View>

      <View style={styles.categoriesContainer}>
        {categories.map((category) => (
          <TouchableOpacity
            key={category}
            style={[
              styles.categoryButton,
              selectedCategory === category && styles.categoryButtonSelected,
            ]}
            onPress={() => setSelectedCategory(selectedCategory === category ? null : category)}
          >
            <Text
              style={[
                styles.categoryText,
                selectedCategory === category && styles.categoryTextSelected,
              ]}
            >
              {category}
            </Text>
          </TouchableOpacity>
        ))}
      </View>
      <ProductList selectedCategory={selectedCategory} userId={1} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: Colors.background,
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    marginBottom: 20,
    marginTop:20
  },
  loadingContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  errorContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  categoriesContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-around',
    marginBottom: 10,
  },
  categoryButton: {
    padding: 10,
    margin: 5,
    borderRadius: 20,
    backgroundColor: Colors.lightGrey,
  },
  categoryButtonSelected: {
    backgroundColor: Colors.secondary,
  },
  categoryText: {
    color: Colors.text,
    fontWeight: 'bold',
  },
  categoryTextSelected: {
    color: Colors.white,
  },
});