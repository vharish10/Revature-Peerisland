create database EcommerceDB;

use EcommerceDB;
create table Customers(
	CustomerId int NOT NULL UNIQUE,
    CustomerName varchar(40) NOT NULL,
    City varchar(20),
    Email varchar(30) NOT NULL
); 

create table Products(
	ProductId int ,
	ProductName varchar(30) NOT NULL,
	Category varchar(20) NOT NULL,
	Price decimal(8,3)
);

create table Orders(
	OrderId int NOT NULL,
	CustomerId int NOT NULL,
	OrderDate date ,
	TotalAmount decimal(8,3)
);

alter table Orders
modify CustomerId int NULL;

alter table Orders
drop INDEX CustomerId;

ALTER TABLE Orders
DROP INDEX CustomerId;

ALTER TABLE Orders
DROP FOREIGN KEY orders_ibfk_1;

SHOW CREATE TABLE Orders;

insert into Orders values
(301,102,"2026-03-21",69000),
(302,101,"2026-02-3",90000),
(303,102,"2026-01-25",55000),
(304,103,"2026-02-23",78000),
(305,105,"2026-01-26",9000),
(306,103,"2026-01-14",27000);

create table OrderItems(
	OrderItemId int ,
    OrderId int ,
	ProductId int,
	Quantity int 
);

drop table OrderItems;

insert into OrderItems values
(401,301,204,1),
(402,302,201,2),
(403,303,201,1),
(404,304,203,1),
(405,305,202,2),
(406,306,202,1);

alter table Customers
add primary key(CustomerId);

alter table Products
add primary key(ProductId);

alter table Orders
add primary key(OrderId);

ALTER TABLE Orders
ADD FOREIGN KEY (CustomerId)
REFERENCES Customers(CustomerId);

SELECT *
FROM Orders
WHERE CustomerId NOT IN
(
    SELECT CustomerId FROM Customers
);

alter table OrderItems
add primary key(OrderItemId);

alter table OrderItems
add foreign key(OrderId) references Orders(OrderId);

alter table OrderItems
add foreign key(ProductId) references Products(ProductId);

insert into Customers values
(101,"Harish","Bangalore","reddyharish530@gmail.com"),
(102,"Grishitha","Bangalore","grishithaaer2006@gmail.com"),
(103,"Rohit","Chennai","rohtrg1610@gmail.com"),
(104,"Giri","Hosur","giriyadav20@gmail.com"),
(105,"Yogesh","Hyderbad","yogeshsyr1305@gmail.com"),
(106,"Shashank","Bangalore","shashankk0111@gmail.com"),
(107,"Nikhil","Chennai","villuriNikhil23@gmail.com");

insert into Customers values(108,"Akhil","Hyderbad",NULL);

select * from Customers;

alter table Products
modify price decimal(10,3);

insert into Products values
(201,"Iphone 17 Pro","Smartphone",154000),
(202,"Asus Vivobook S16","Laptop",81000),
(203,"Asus Zenbook","Laptop",105000),
(204,"Samsung 4k LED TV","Television",25000),
(205,"Google Pixel 10","Smartphone",69000),
(206,"LG UA series 2025","Television",39000);


select *,Quantity*1000 as EstimatedTotal from OrderItems;
UPDATE Products SET Price = Price - 500 WHERE ProductId=201;

select *,Price+500 as PriceInc from products;
update products set price=price-200;
select *,Price-200 as PriceInc from products;

select *,Quantity*2 as DoubleQuantity from OrderItems;

select *,TotalAmount/2  as HalfAmount from Orders;

select * from orders
where TotalAmount>10000;

select * from products
where Price<5000;

select * from orders
where TotalAmount>=25000;

select * from products
where Price<=8000;

select * from customers 
where city='Chennai';

select * from customers 
where city<>'Delhi';

select * from customers 
where CustomerName like 'h%';

select * from products 
where Category IN('Smartphone','Laptop');

select * from orders
where TotalAmount between 500 AND 70000;

select * from customers 
where city<>'Mumbai';

select * from products 
where Category<>'Laptop';

select * from products
where category IN('Television','Laptop');

select * from Customers
where city NOT IN ("Chennai",'Bangalore');

select * from Orders 
where TotalAmount between 5000 and 60000;

select * from Orders 
where TotalAmount not between 5000 and 60000;

select * from Customers 
where CustomerName like 'A%';

select * from Products
where ProductName like 'M%';

select * from Customers 
where email is NULL;

select * from Customers 
where email is NOT NULL;

select * from Customers
where city='Chennai';

select * from Orders
where orderdate> '2024-02-01';

select * from Products 
where price>10000;

select * from OrderItems
where Quantity=1;

select * from Customers 
where email is NULL;

select * from Orders
order by Totalamount desc;

Select * from Customers
order by customername;

select * from Products
order by PRICE desc;

select * from orders 
order by OrderDate desc;

select CustomerId, COUNT(*) as Total from Orders
group by customerid;

select CustomerId, SUM(TotalAmount) as Amount from Orders
group by customerId;

select CustomerId, avg(TotalAmount) as AvgAmount from Orders
group by customerId;

select p.ProductName, SUM(o.Quantity) as TotalSold
from orderitems o
join Products p ON o.ProductId = p.ProductId
group by p.ProductId;

select Category, COUNT(*) as ProductCount
from Products p
group by category;

select CustomerId, SUM(TotalAmount) as Amount from Orders
group by customerId
having amount>50000;

select CustomerId, COUNT(*) as Total from Orders
group by customerid
having total>=1;

select Category, COUNT(*) as ProductCount
from Products p
group by category
having ProductCount>=1;

select CustomerId, avg(TotalAmount) as AvgAmount from Orders
group by customerId
having avgamount>=20000;