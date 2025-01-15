-- Önce BaseProduct verilerini ekleyin
INSERT INTO products (name, price, url, details, category, platform) VALUES
('Hepsiburada Product 1', 10.0, 'url1', 'details1', 'category1', 'Hepsiburada'),
('Hepsiburada Product 2', 20.0, 'url2', 'details2', 'category1', 'Hepsiburada'),
('Hepsiburada Product 3', 30.0, 'url3', 'details3', 'category2', 'Hepsiburada'),
('Trendyol Product 1', 15.0, 'url4', 'details4', 'category1', 'Trendyol'),
('Trendyol Product 2', 25.0, 'url5', 'details5', 'category2', 'Trendyol');

-- Ardından User verilerini ekleyin, DTYPE sütununa dikkat
INSERT INTO users (dtype, username, email, password) VALUES
('User', 'user1', 'user1@example.com', 'password123'),
('User', 'user2', 'user2@example.com', 'password456'),
('Admin', 'admin1', 'admin1@example.com', 'adminpass');

-- İsterseniz, users ve products tabloları arasında ilişki kurmak için de INSERT komutları ekleyebilirsiniz.
-- Örneğin, user1'in favorilerine Hepsiburada Product 1'i eklemek için:
-- Önce user tablosuna DTYPE değerleri ile User veya alt sınıflarını ekleyin
INSERT INTO users (dtype, username, email, password) VALUES
('User', 'user1', 'user1@example.com', 'password123'),
('User', 'user2', 'user2@example.com', 'password456'),
('Admin', 'admin1', 'admin1@example.com', 'adminpass');

-- Ardından user_favorites tablosuna veri ekleyin
-- user_favorites tablosuna ekleme yaparken, user_id ve product_id değerlerinin
-- users ve products tablolarında mevcut olduğundan emin olun.
INSERT INTO user_favorites (user_id, favorites_productid) VALUES
(1, 1), -- user1 (ID: 1) Hepsiburada Product 1'i (ID: 1) favorilere ekliyor
(2, 4); -- user2 (ID: 2) Trendyol Product 1'i (ID: 4) favorilere ekliyor