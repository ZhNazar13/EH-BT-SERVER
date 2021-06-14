create table if not exists "group"
(
    id       integer not null
    constraint group_pkey
    primary key,
    name     varchar(255),
    rank     integer,
    workload integer
    );

alter table "group"
    owner to admin;

create table if not exists role
(
    id   integer not null
    constraint role_pkey
    primary key,
    code varchar(255)
    constraint uk_c36say97xydpmgigg38qv5l2p
    unique,
    name varchar(255)
    );

alter table role
    owner to admin;

create table if not exists subject
(
    id   integer not null
    constraint subject_pkey
    primary key,
    name varchar(255)
    );

alter table subject
    owner to admin;

create table if not exists academ
(
    id         integer not null
    constraint academ_pkey
    primary key,
    homework   varchar(255),
    rank       integer,
    theme      varchar(255),
    subject_id integer
    constraint fk6w3pjsm4tg30jp4h4ktcgdudm
    references subject
    );

alter table academ
    owner to admin;

create table if not exists "user"
(
    id       integer not null
    constraint user_pkey
    primary key,
    arcfl    integer,
    login    varchar(255)
    constraint uk_ew1hvam8uwaknuaellwhqchhb
    unique,
    password varchar(255),
    role_id  integer
    constraint fkn82ha3ccdebhokx3a8fgdqeyy
    references role
    );

alter table "user"
    owner to admin;

create table if not exists student
(
    id           integer not null
    constraint student_pkey
    primary key,
    name         varchar(255),
    parent_email varchar(255),
    parent_name  varchar(255),
    group_id     integer
    constraint fkqq8hb86jxf1vmnrcu6v7h0ac
    references "group",
    user_id      integer
    constraint fkk5m148xqefonqw7bgnpm0snwj
    references "user"
    );

alter table student
    owner to admin;

create table if not exists teacher
(
    id         integer not null
    constraint teacher_pkey
    primary key,
    first_name varchar(255),
    workload   integer,
    user_id    integer
    constraint fkpb6g6pahj1mr2ijg92r7m1xlh
    references "user"
    );

alter table teacher
    owner to admin;

create table if not exists schedule
(
    id            integer not null
    constraint schedule_pkey
    primary key,
    day           integer,
    quarter       varchar(255),
    time          time,
    academ_id     integer
    constraint fktri7w27poksy2fbxqj3c3o2mb
    references academ,
    group_id      integer
    constraint fkl3aqb505pgupfp862ovag66pu
    references "group",
    teacher_id    integer
    constraint fkof1t073hsxioayk2covxfe8um
    references teacher,
    class_room    varchar(255),
    day_of_week   integer,
    subject_order integer
    );

alter table schedule
    owner to admin;

create table if not exists journal
(
    id          integer not null
    constraint journal_pkey
    primary key,
    attendance  integer,
    grade       integer,
    schedule_id integer
    constraint fkjo0jbu3kpdcmxwo0bmcov3jso
    references schedule,
    student_id  integer
    constraint fkh7fqsadgwp38e91eyeswhqrju
    references student,
    date        timestamp
);

alter table journal
    owner to admin;

create table if not exists classroom
(
    id    integer,
    code  varchar(255),
    floor integer,
    name  varchar(255)
    );

alter table classroom
    owner to admin;

create table if not exists room
(
    id    integer not null
    constraint room_pkey
    primary key,
    code  varchar(255),
    floor integer,
    name  varchar(255)
    );

alter table room
    owner to admin;

create table if not exists grade
(
    id   integer,
    code integer,
    name integer
);

alter table grade
    owner to admin;

