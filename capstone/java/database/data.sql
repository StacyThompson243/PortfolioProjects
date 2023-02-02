BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,first_time,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_USER');
INSERT INTO users (username,password_hash,first_time,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_ADMIN');

insert into pets (pet_image, name, type, age, gender, weight, breed, description, adopted)
values ('https://res.cloudinary.com/difcq8eki/image/upload/v1675116167/Dogs/pexels-helena-lopes-1938126_dvvvya.jpg', 'Fido', 'dog', 3, 'male', 35, 'mixed', 'Sweet dog who loves people, squirrels, and the mailman', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675116130/Dogs/pexels-pixabay-257519_ebxcag.jpg', 'Jayna', 'dog', 1, 'female', 9, 'dachshund', 'Looking for a home for this little abandoned guy', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675116120/Dogs/pexels-ylanite-koppens-612813_oddfwy.jpg', 'Frank', 'dog', 2, 'male', 40, 'mixed', 'This guy will love you and protect your home forever!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675186216/Dogs/pexels-vadim-b-127028_byvb2r.jpg', 'Peach', 'cat', 1, 'female', 5, 'scottish fold mix', 'Just a baby', false);

COMMIT TRANSACTION;
