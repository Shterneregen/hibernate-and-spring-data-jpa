create table book_uuid
(
    id        binary(16) not null,
    isbn      varchar(255),
    publisher varchar(255),
    title     varchar(255),
    primary key (id)
) engine = InnoDB;
-- alter table book_uuid change id id varbinary(16);