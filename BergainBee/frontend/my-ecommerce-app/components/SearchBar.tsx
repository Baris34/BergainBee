import React, { useState } from 'react';
import { View, TextInput, StyleSheet } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import Colors from '../constants/Colors';

interface SearchBarProps {
  onSearch: (keyword: string) => void;
}

const SearchBar: React.FC<SearchBarProps> = ({ onSearch }) => {
  const [keyword, setKeyword] = useState('');

  const handleSearch = () => {
    onSearch(keyword);
  };

  return (
    <View style={styles.container}>
      <Ionicons name="search" size={20} color={Colors.grey} style={styles.icon} />
      <TextInput
        style={styles.input}
        placeholder="Search what you need"
        placeholderTextColor={Colors.grey}
        value={keyword}
        onChangeText={setKeyword}
        onSubmitEditing={handleSearch} // Enter'a basıldığında arama yap
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: Colors.lightGrey,
    padding: 10,
    borderRadius: 5,
    margin: 10,
  },
  icon: {
    marginRight: 10,
  },
  input: {
    flex: 1,
    fontSize: 16,
    color: Colors.text,
  },
});

export default SearchBar;