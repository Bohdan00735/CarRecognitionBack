INSERT INTO users (id)
values (1);
INSERT INTO users (id)
values (2);
INSERT INTO prediction_reviews(request, prediction, image_url, comment, user_id)
values ('Audi', true, '1.jpg', 'comment', 1);
INSERT INTO prediction_reviews(request, prediction, image_url, comment, user_id)
values ('Mers', false, '1.jpg', 'comment', 1);
INSERT INTO prediction_reviews(request, prediction, image_url, comment, user_id)
values ('Audi', true, '1.jpg', 'comment', 2);