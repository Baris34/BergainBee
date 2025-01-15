# BergainBee: Price Comparison Project

## Overview

BergainBee is a mobile application developed to allow users to easily compare product prices across various e-commerce platforms. The application is built with **React Native** for mobile devices and **Java Spring Boot** for the backend. Instead of real-time data fetching, the project provides a price comparison system based on static data.

## Technical Features

- **Technologies Used**:
  - **Frontend**: React Native
  - **Backend**: Java Spring Boot
  - **Database**: Centralized database
  - **Architecture**: 3-layer architecture (Data Layer, Business Layer, Presentation Layer)
- **Design Patterns Used**:
  - **Singleton**: To manage database connections and global variables.
  - **State**: To control UI updates.
  - **Iterator**: For navigating through data.
  - **Flyweight**: To optimize memory usage.
  - **Abstract Factory**: To create objects from different data sources.
  - **Strategy**: To manage different comparison algorithms.
  - **Observer**: To notify users of discounts or changes.

## Features

- **Price Comparison**: Users can easily compare product prices across different platforms.
- **Product Comparison**: Detailed analysis of two products based on price and features.
- **User-Friendly Interface**: A simple and intuitive user experience.
- **Discount Notifications**: Get notifications about price drops for your favorite products.

## Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/bergainbee.git
2. **Start the Backend**:
   ```bash
     cd backend
3. **Start the Spring Boot application using Maven**:
    ```bash
    ./mvnw spring-boot:run
4. **Start the Frontend**:
   ```bash
    npm start
## Roadmap

- [x] Development of the basic price comparison module.
- [ ] Addition of the product comparison module.
- [ ] Integration with more e-commerce platforms.
- [ ] Advanced discount notification system.
- [ ] Completion of frontend development (React Native).
- [x] Static data-based product display.

## Team
The following individuals have contributed to the development of BergainBee:

- [Barış Kaya](https://github.com/Baris34) - Backend Developer (Java Spring Boot)
- [Yusuf Ahmet Tokgöz](https://github.com/yahmettokgoz) - Frontend Developer (React Native)
- [Elif Buse Köprücü](https://github.com/buselifkprc) - Frontend Developer (React Native)
- [Mehmet Fatih Akbaş](https://github.com/mfatihakbas) - Database Architect (PostgreSQL)
- [Utku Alyüz](https://github.com/UtkuAlyuz) - Database Architect (PostgreSQL)
