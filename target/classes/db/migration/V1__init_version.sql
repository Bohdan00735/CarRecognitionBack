create table users
(
    id bigserial primary key
);

create table top_picks
(
    id            bigserial primary key,
    top_pick_type text,
    header        text not null,
    image_url     text not null,
    user_id       bigint references users (id) on delete cascade
);