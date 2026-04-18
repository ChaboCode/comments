create table comments
(
    id         bigserial primary key,
    username   varchar(64) not null,
    comment    text,
    post       varchar(128) not null,
    created_at timestamp   not null default now(),
    deleted    boolean     not null default false
);