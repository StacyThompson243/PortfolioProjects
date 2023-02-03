BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,first_time,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_USER');
INSERT INTO users (username,password_hash,first_time,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_ADMIN');

insert into pets (pet_image, name, type, age, gender, weight, breed, description, adopted)
values ('https://res.cloudinary.com/difcq8eki/image/upload/v1675116167/Dogs/pexels-helena-lopes-1938126_dvvvya.jpg', 'Fido', 'dog', 3, 'male', 35, 'mixed', 'Sweet dog who loves people, squirrels, and the mailman', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675116130/Dogs/pexels-pixabay-257519_ebxcag.jpg', 'Jayna', 'dog', 1, 'female', 9, 'dachshund', 'Looking for a home for this little abandoned guy', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675116120/Dogs/pexels-ylanite-koppens-612813_oddfwy.jpg', 'Frank', 'dog', 2, 'male', 40, 'mixed', 'This guy will love you and protect your home forever!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675186216/Dogs/pexels-vadim-b-127028_byvb2r.jpg', 'Peach', 'cat', 1, 'female', 5, 'scottish fold mix', 'Just a baby', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137395/Dogs/goldenretriever_q6xtcp.jpg', 'Angus', 'Dog', 5, 'Male', 60, 'Golden Retriever', 'Your next best friend cannot wait to meet you!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675281098/Dogs/stripeycat_jodnzt.jpg', 'Smudge', 'Cat', 4, 'Male', 18, 'Manx', 'Looking for someone to feed me and love me!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137381/Dogs/greyhound_iukaja.jpg', 'Lulu', 'Dog', 3, 'Female', 30, 'Italian Greyhound', 'A running buddy who also enjoys snuggling!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137402/Dogs/aussiedoodlepuppy_dhwhj1.jpg', 'Penelope', 'Dog', 0, 'Female', 15, 'AussieDoodle', 'I do not shed and am passionate about squeaky toys!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675282740/Dogs/guineapig_fmq2l9.jpg', 'Peanut', 'Guinea Pig', 1, 'Male', 2, 'American Guinea Pig', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675116141/Dogs/pexels-alexandru-rotariu-733416_wweugv.jpg', 'Cookie', 'Dog', 3, 'Female', 55, 'Pit Bull Mix', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137374/Dogs/russelterrier_hamxuo.jpg"', 'Loki', 'Dog', 2, 'Male', 22, 'Jack Russel', 'Plays well with others and very active!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137374/Dogs/russelterrier_hamxuo.jpg"', 'Loki', 'Dog', 2, 'Male', 22, 'Jack Russel', '"Plays well with others and very active!"', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675282748/Dogs/white_cat_z6khf4.jpg', 'Elsa', 'Cat', 7, 'Female', 14, 'Turkish Angora', 'Apex predator disguised as a fluffy white cloud.', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137387/Dogs/whitespikeyears_cghjnw.jpg', 'Spock', 'Dog', 5, 'Male', 45, 'Pit Bull Mix', 'Just waiting for you to throw me a ball!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287694/Dogs/Ella_al1ax3.jpg', 'Ella', 'Dog', 4, 'Female', 42, 'Blue Heeler', 'I am very protective over the people I love and do not want to live in a house with children.', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287682/Dogs/seth_bkbfzc.jpg', 'Seth', 'Dog', 8, 'Male', 70, 'Husky', 'Retired guard dog looking for a loving home.', false);


COMMIT TRANSACTION;
