create table showdetails (
showId varchar(5) primary key,
showName varchar(30) unique,
location varchar(20),
showdate date,
avSeats number(3),
priceticket number(5,2)
);


insert into showdetails values('S102','Quantico','Big Cinmas','23-Aug-2016',25,250);
insert into showdetails values('S103','Lod of Rings','PVR','23-Jul-2016',0,350);
insert into showdetails values('S104','Magic Show','Victory Hall','23-Nov-2016',38,375);
insert into showdetails values('S105','Vampire Series','Chestnut Drive','13-Nov-2016',50,475);

