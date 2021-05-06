create table if not exists teacher
(
    id           serial not null
        constraint teacher_pk
            primary key,
    first_name   varchar(264),
    phone_number varchar(64),
    birthdate    date,
    address      varchar(512)
);

create unique index if not exists teacher_id_uindex
    on teacher (id);
