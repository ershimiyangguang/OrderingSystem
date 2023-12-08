create database ordersystem
use ordersystem

create table users
(
    u_id                 integer                        not null,
    u_name               varchar(50)                    null,
    u_password           varchar(50)                    null,
    constraint PK_USERS primary key (u_id)
);
create table dish
(
    d_id                 integer                        not null,
    d_name               varchar(50)                    null,
    d_price              integer                        null,
    d_description        varchar(50)                    null,
    d_image              varchar(50)                    null,
    constraint PK_DISH primary key (d_id)
);
create table orders
(
    d_id                 integer                        not null,
    u_id                 integer                        not null,
    o_count              integer                        null,
    o_state              smallint                       null,
    constraint PK_ORDER primary key (d_id, u_id)
);
INSERT INTO `dish`  VALUES
                        (1, '皮蛋瘦肉粥', 5.00, '美味可口!', 'images/500022.jpg'),
                        (2, '清炒时蔬', 5.00, '时令绿色蔬菜', 'images/500046.jpg'),
                        (3, '炸酱面', 8.00, '京味小吃！', 'images/500045.jpg'),
                        (4, '肉丝茄子', 10.00, '美味可口！', 'images/500044.jpg'),
                        (5, '西红柿炒鸡蛋', 6.00, '经典搭配！', 'images/500043.jpg'),
                        (6, '香油抄手', 4.00, '川味小吃，鲜香可口！', 'images/500042.jpg'),
                        (7, '酸豆角炒肉末盖饭', 8.00, '开胃可口！', 'images/500041.jpg'),
                        (8, '创意炒饭', 7.00, '原料：鸡蛋、胡萝卜、青豆。。。口味适中，非常爽口！', 'images/500038.jpg'),
                        (9, '重庆小面', 5.00, '正宗重庆街头特色小面！', 'images/500036.jpg'),
                        (10, '米粉汤', 8.00, '原料：米粉、骨头汤、豆腐、肉丸汤味鲜美，口感极佳！', 'images/500035.jpg'),
                        (11, '特色炒饭', 7.00, '原料：蘑菇、鸡蛋、胡萝卜、青椒、绿色蔬菜。口感极好！', 'images/500034.jpg'),
                        (12, '木须肉盖饭', 8.00, '原料：木耳、猪肉、青瓜、鸡蛋。口味适中，营养美味。', 'images/500033.jpg'),
                        (13, '清炒时蔬', 5.00, '时令绿色蔬菜', 'images/500046.jpg'),
                        (14, '西红柿打卤面', 7.00, '配料：西红柿、鸡蛋口味：清淡。', 'images/500025.jpg'),
                        (15, '拉面', 6.00, '配料：牛肉、骨头汤口味：微辣、中辣、超辣。', 'images/500024.jpg'),
                        (16, '刀削面', 6.00, '配料：青菜、猪肉、海带、骨头汤口味：微辣、中辣、超辣。', 'images/500023.jpg'),
                        (17, '青菜肉丝粥', 4.00, '原料：青菜、肉丝口味清淡，清香可口！', 'images/500022.jpg'),
                        (18, '土豆丝盖饭', 7.00, '好好吃哦', 'images/500008.jpg');
INSERT INTO `users`  VALUES
                         (1, '张三', '1234'),
                         (2, 'test', '1234');
insert into orders VALUES
                       (1,1,5,0),
                       (1,2,5,0);
