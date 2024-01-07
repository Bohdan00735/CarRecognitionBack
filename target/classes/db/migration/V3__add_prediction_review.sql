create table prediction_reviews
(
    id         bigserial primary key,
    request    text,
    prediction boolean,
    image_url  text,
    comment    text,
    user_id    bigint references users (id) on delete cascade
);