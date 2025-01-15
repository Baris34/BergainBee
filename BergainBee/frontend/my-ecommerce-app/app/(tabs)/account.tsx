import React from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Image } from 'react-native';
import Colors from '../../constants/Colors';
import { Ionicons } from '@expo/vector-icons';

export default function AccountScreen() {
  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <Ionicons name="chevron-back" size={24} color="black" />
        <Text style={styles.headerTitle}>My Account</Text>
      </View>

      <View style={styles.profileContainer}>
        <Image
          source={require('../../assets/images/Blank profile.png')} // Varsayılan profil resmi
          style={styles.profileImage}
        />
        <View style={styles.buttonContainer}>
          <TouchableOpacity style={[styles.button, {backgroundColor: Colors.primary}]}>
            <Text style={[styles.buttonText, {color: Colors.white}]}>Log In</Text>
          </TouchableOpacity>
          <TouchableOpacity style={[styles.button, {backgroundColor: Colors.lightGrey}]}>
            <Text style={[styles.buttonText,{color: Colors.text}]}>Sign Up</Text>
          </TouchableOpacity>
        </View>
      </View>

      <View style={styles.menu}>
        <TouchableOpacity style={styles.menuItem}>
          <Ionicons name="help-circle-outline" size={24} color={Colors.primary} />
          <Text style={styles.menuItemText}>FAQ</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.menuItem}>
          <Image source={require('../../assets/images/germany-flag.png')} style={styles.flagIcon} />
          <Text style={styles.menuItemText}>Türkçe</Text>
        </TouchableOpacity>
        <Text style={styles.menuItemText}>Change password</Text>
        <Text style={styles.menuItemText}>Privacy policy</Text>
        <Text style={styles.menuItemText}>Chasback</Text>
        <Text style={styles.menuItemText}>Chat with admin</Text>
        <Text style={styles.menuItemText}>About BergainBee</Text>
        <Text style={styles.menuItemText}>Return</Text>
        {/* Diğer menü öğeleri buraya gelecek */}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: Colors.background,
    padding: 20,
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 20,
    marginTop:20
  },
  headerTitle: {
    fontSize: 20,
    fontWeight: 'bold',
    marginLeft: 10,
  },
  profileContainer: {
    alignItems: 'center',
    marginBottom: 20,
  },
  profileImage: {
    width: 100,
    height: 100,
    borderRadius: 50,
    marginBottom: 10,
  },
  buttonContainer: {
    flexDirection: 'row',
    marginBottom: 20,
  },
  button: {
    paddingVertical: 10,
    paddingHorizontal: 20,
    borderRadius: 5,
    marginHorizontal: 5,
  },
  buttonText: {
    fontSize: 16,
    fontWeight: 'bold',
  },
  menu: {
    marginTop: 20,
  },
  menuItem: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 15,
  },
  menuItemText: {
    fontSize: 16,
    marginLeft: 10,
    color: Colors.text
  },
  flagIcon: {
    width: 24,
    height: 24,
    borderRadius: 12, // Bayrak ikonunu yuvarlak yapmak için
  },
});