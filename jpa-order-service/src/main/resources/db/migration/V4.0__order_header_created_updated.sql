alter table order_header
    add column created_date timestamp;

alter table order_header
    add column last_modified_date timestamp;