/**
  회원 테이블
 */
create table members
(
    id                bigint auto_increment comment '아이디',
    name              varchar(20)  not null comment '이름',
    nickname          varchar(30)  not null comment '별명',
    password          varchar(100) not null comment '비밀번호',
    email             varchar(100) not null comment '이메일',
    gender            varchar(10)  null comment '성별',
    user_role         varchar(10)  null comment '권한',
    last_ordered_at   datetime     null comment '마지막 주문 시간',
    created_date_time datetime     not null comment '생성시간',
    updated_date_time datetime     not null comment '수정시간',
    constraint members_pk
        primary key (id)
);

create unique index members_email_uindex on members (email);
create index members_name_email_index on members (name, email);

/**
  주문 테이블
 */
create table orders
(
    id                bigint auto_increment comment '아이디',
    order_number      varchar(12)  not null comment '주문번호',
    product_name      varchar(100) not null comment '제품명',
    payment_date_time datetime     not null comment '결제일시',
    member_id         bigint       not null comment '회원아이디(FK)',
    updated_date_time datetime     not null comment '수정시간',
    created_date_time datetime     not null comment '생성시간',
    constraint orders_pk primary key (id),
    constraint orders_members_id_fk foreign key (member_id) references members (id)
);

create unique index orders_order_number_uindex on orders (order_number);



