BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,first_time,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_USER');
INSERT INTO users (username,password_hash,first_time,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC',false,'ROLE_ADMIN');

insert into pets (pet_image, name, type, age, gender, weight, breed, description, adopted)
values
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879456/Saved%20Pictures/pexels-dominika-roseclay-4193995_b7ilaf.jpg','Jayna', 'dog', 1, 'female', 9, 'dachshund', 'Looking for a home for this little abandoned guy', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887638/pexels-helena-lopes-1938126_awqfei.jpg', 'Fido', 'dog', 3, 'male', 35, 'mixed', 'Sweet dog who loves people, squirrels, and the mailman', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888119/pexels-ylanite-koppens-612813_i6vpcl.jpg', 'Frank', 'dog', 2, 'male', 40, 'mixed', 'This guy will love you and protect your home forever!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675892812/pexels-vadim-b-127028_mbkijo.jpg', 'Peach', 'cat', 1, 'female', 5, 'scottish fold mix', 'Just a baby', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137395/Dogs/goldenretriever_q6xtcp.jpg', 'Angus', 'Dog', 5, 'Male', 60, 'Golden Retriever', 'Your next best friend cannot wait to meet you!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675281098/Dogs/stripeycat_jodnzt.jpg', 'Smudge', 'Cat', 4, 'Male', 18, 'Manx', 'Looking for someone to feed me and love me!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137381/Dogs/greyhound_iukaja.jpg', 'Lulu', 'Dog', 3, 'Female', 30, 'Italian Greyhound', 'A running buddy who also enjoys snuggling!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137402/Dogs/aussiedoodlepuppy_dhwhj1.jpg', 'Penelope', 'Dog', 0, 'Female', 15, 'AussieDoodle', 'I do not shed and am passionate about squeaky toys!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957124/pexels-enrique-11010200_ad38ca.jpg', 'Peanut', 'Guinea Pig', 1, 'Male', 2, 'American Guinea Pig', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957273/pexels-alexandru-rotariu-733416_npx3gp.jpg', 'Cookie', 'Dog', 3, 'Female', 55, 'Pit Bull Mix', 'I love lettuce, hiding in small boxes, and when you scratch my forehead!', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957431/pexels-james-frid-1750542_suiunv.jpg', 'Loki', 'Dog', 2, 'Male', 22, 'Jack Russel', '"Plays well with others and very active!"', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675958333/pexels-phiraphon-srithakae-15317706_exlzs9.jpg', 'Elsa', 'Cat', 7, 'Female', 14, 'Turkish Angora', 'Apex predator disguised as a fluffy white cloud.', false),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675958582/RatFeistMountainFeistRatTerrierMixJoJo2YearsOld1_oyhysm.jpg', 'Spock', 'Dog', 5, 'Male', 45, 'Pit Bull Mix', 'Just waiting for you to throw me a ball!', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287694/Dogs/Ella_al1ax3.jpg', 'Ella', 'Dog', 4, 'Female', 42, 'Blue Heeler', 'I am very protective over the people I love and do not want to live in a house with children.', false),
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287682/Dogs/seth_bkbfzc.jpg', 'Seth', 'Dog', 8, 'Male', 70, 'Husky', 'Retired guard dog looking for a loving home.', false);

insert into pet_images (pet_image, is_primary, pet_id)
values
-- Jayna
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879456/Saved%20Pictures/pexels-dominika-roseclay-4193995_b7ilaf.jpg', true, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675880125/pexels-dominika-roseclay-4148015_b1wwb8.jpg', false, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879644/pexels-dominika-roseclay-4318208_whrvqq.jpg', false, 1),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675879456/Saved%20Pictures/pexels-dominika-roseclay-4884404_1_unprof.jpg', false, 1),
-- Fido
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887638/pexels-helena-lopes-1938126_awqfei.jpg', true, 2),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887627/pexels-blue-bird-7210704_bbbygn.jpg', false, 2),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675887636/pexels-blue-bird-7210618_acuj8s.jpg', false, 2),
-- Frank
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888119/pexels-ylanite-koppens-612813_i6vpcl.jpg', true, 3),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888117/pexels-ylanite-koppens-2115604_uo6vpr.jpg', false, 3),
-- Peach
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675892812/pexels-vadim-b-127028_mbkijo.jpg', true, 4),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888117/pexels-ylanite-koppens-2115604_uo6vpr.jpg', false, 4),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675888117/pexels-ylanite-koppens-2115604_uo6vpr.jpg', false, 4),
-- Angus
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137395/Dogs/goldenretriever_q6xtcp.jpg', true, 5),
-- Smudge
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675893868/pexels-pixabay-208984_rqiqvt.jpg', true, 6),
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675893868/pexels-inge-wallumr%C3%B8d-126407_1_y62etv.jpg', false, 6),
-- Lulu
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137381/Dogs/greyhound_iukaja.jpg', true, 7),
-- Penelope
('https://res.cloudinary.com/difcq8eki/image/upload/v1675137402/Dogs/aussiedoodlepuppy_dhwhj1.jpg', true, 8),
-- Peanut
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957124/pexels-enrique-11010200_ad38ca.jpg', true, 9),
--Cookie
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957273/pexels-alexandru-rotariu-733416_npx3gp.jpg', true, 10),
--Lokie
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675957431/pexels-james-frid-1750542_suiunv.jpg', true, 11),
-- Elza
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675958333/pexels-phiraphon-srithakae-15317706_exlzs9.jpg', true, 12),
-- Spock
('https://res.cloudinary.com/dfnprnclx/image/upload/v1675958582/RatFeistMountainFeistRatTerrierMixJoJo2YearsOld1_oyhysm.jpg', true, 13),
-- Ella
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287694/Dogs/Ella_al1ax3.jpg', true, 14),
-- Seth
('https://res.cloudinary.com/difcq8eki/image/upload/v1675287682/Dogs/seth_bkbfzc.jpg', true, 15);




COMMIT TRANSACTION;
