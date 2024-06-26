
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2023/12/16 20:12:57                          */
/*==============================================================*/
create database ordersystem;
use ordersystem;
drop table if exists orders;

drop table if exists Users;

drop table if exists admin;

drop table if exists dish;


/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users
(
    u_name               varchar(50) not null,
    u_password           varchar(50),
    primary key (u_name)
);

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
    a_name               varchar(50) not null,
    a_password           varchar(50),
    primary key (a_name)
);

/*==============================================================*/
/* Table: dish                                                  */
/*==============================================================*/
create table dish
(
    d_id                 int not null,
    d_name               varchar(50),
    d_price              int,
    d_description        varchar(50),
    d_image              varchar(50),
    primary key (d_id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
    d_id                 int not null,
    u_name               varchar(50) not null,
    o_count              int,
    o_state              smallint
);

alter table orders add constraint FK_orders foreign key (u_name)
    references Users (u_name) on delete cascade on update cascade;

alter table orders add constraint FK_orders2 foreign key (d_id)
    references dish (d_id) on delete cascade on update cascade;


/*==============================================================*/
/* 插入数据                                              */
/*==============================================================*/
INSERT INTO `dish`  VALUES
                        (1, '皮蛋瘦肉粥', 5.00, '美味可口!', 'images/17.jpg'),
                        (2, '清炒时蔬', 5.00, '时令绿色蔬菜', 'images/2.jpg'),
                        (3, '炸酱面', 8.00, '京味小吃！', 'images/3.jpg'),
                        (4, '肉丝茄子', 10.00, '美味可口！', 'images/4.jpg'),
                        (5, '西红柿炒鸡蛋', 6.00, '经典搭配！', 'images/5.jpg'),
                        (6, '香油抄手', 4.00, '川味小吃，鲜香可口！', 'images/6.jpg'),
                        (7, '酸豆角炒肉末盖饭', 8.00, '开胃可口！', 'images/7.jpg'),
                        (8, '创意炒饭', 7.00, '原料：鸡蛋、胡萝卜、青豆。。。口味适中，非常爽口！', 'images/8.jpg'),
                        (9, '重庆小面', 5.00, '正宗重庆街头特色小面！', 'images/9.jpg'),
                        (10, '米粉汤', 8.00, '原料：米粉、骨头汤、豆腐、肉丸汤味鲜美，口感极佳！', 'images/10.jpg'),
                        (11, '特色炒饭', 7.00, '原料：蘑菇、鸡蛋、胡萝卜、青椒、绿色蔬菜。口感极好！', 'images/11.jpg'),
                        (12, '木须肉盖饭', 8.00, '原料：木耳、猪肉、青瓜、鸡蛋。口味适中，营养美味。', 'images/12.jpg'),
                        (13, '清炒时蔬', 5.00, '时令绿色蔬菜', 'images/2.jpg'),
                        (14, '西红柿打卤面', 7.00, '配料：西红柿、鸡蛋口味：清淡。', 'images/14.jpg'),
                        (15, '拉面', 6.00, '配料：牛肉、骨头汤口味：微辣、中辣、超辣。', 'images/15.jpg'),
                        (16, '刀削面', 6.00, '配料：青菜、猪肉、海带、骨头汤口味：微辣、中辣、超辣。', 'images/16.jpg'),
                        (17, '青菜肉丝粥', 4.00, '原料：青菜、肉丝口味清淡，清香可口！', 'images/17.jpg'),
                        (18, '土豆丝盖饭', 7.00, '好好吃哦', 'images/18.jpg');


INSERT INTO `users`  VALUES
                         ( 'root', '1234'),
                         ( 'test', '1234');
insert into orders VALUES
                       (1,'test',5,0),
                       (2,'test',5,0),
                       (1,'root',5,0),
                       (2,'root',5,0),
                       (3,'root',5,0);
insert into admin  values
                       ('admin','1234');