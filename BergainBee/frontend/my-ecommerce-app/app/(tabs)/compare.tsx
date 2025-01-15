// app/(tabs)/compare.tsx
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Colors from '../../constants/Colors';

const CompareScreen = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Compare Screen</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: 20,
    backgroundColor: Colors.background
  },
  text: {
    fontSize: 18,
    color: Colors.text,
  },
});

export default CompareScreen;