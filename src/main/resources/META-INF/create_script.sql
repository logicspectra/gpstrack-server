--  GPS Track database for PostgreSQL

create table device (
    device_id      int not null,
    status  int not null,
    creation_time  bigint not null,
    update_time    bigint ,
    phone  varchar(128) not null,
    model  varchar(128) ,
    primary key (device_id)
);



create table Location (
    loc_id      int not null,
    longitude   double precision not null,
    latitude    double precision not null,
    altitude    double precision,
    device_time  bigint not null,
    insert_time  bigint not null,
    primary key (loc_id) 
);




