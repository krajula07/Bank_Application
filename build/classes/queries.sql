create table userstore(
  	username varchar(20) primary key,
  	password varchar(20) not null,
  	name varchar(30) not null,
  	lastlogin varchar(25) not null,
  	role varchar(10) not null);

insert into userstore values('vamsi877','Avkr877@','Vamsi Krishna','2018-04-16','executive');
insert into userstore values('kavya','kavya','KavyaSree','2018-04-16','executive');
insert into userstore values('kavya@97','kavya@97','KavyaSree','2018-04-16','cashier');
select * from userstore;

create table customer(
	ssnid number(9) unique,
	customerid number(9) primary key,
	Name varchar(25) not null,
	Address varchar(30) not null,
	Age number(3));




create table account_status(
	
	customerid number(9) references customer(customerid),
	Accountid number(9) ,
	Accounttype varchar(10),
	
	status varchar(25) not null,
	message varchar(25) not null,
	lastupdated timestamp not null);

ALTER TABLE account_status
MODIFY lastupdated timestamp;

create sequence customerid_seq start with 1001 increment by 1;
create sequence customer_seq start with 100000000 increment by 1;
create sequence bankaccount_seq start with 200000000 increment by 1;


create table bankaccount(   
	customerid number(9) references customer(customerid),
	Accountid number(9) not null,
	Accounttype varchar(10) not null,
	Balance number(10,2),
	CRdata  timestamp,
	CRlastdate timestamp,
	Duration number(20),
	constraint pk primary key (customerid,accounttype) );

alter table bankaccount add constraint pk primary key (accountid,accounttype) ;
drop table account_status;
drop table bankaccount;

create table banktransactions(
	transactionid number(9) primary key,
	custoid number(9) references customer(customerid),
	Accountype varchar(10),
	amount number(8,2),
	transactiondate timestamp,
	sourcetype varchar(10),
	targettype varchar(10),
	description varchar(9),
	transferedamount number(8,2)
	); 
alter table banktransactions add targetid number(9); 
alter table banktransactions drop column sourcetype

select * from account_status where Accountid=200000001 and accounttype='current' and status='active'
select * from customer;
select * from account_status;
select * from bankaccount;
select * from banktransactions;
select * from bankaccount where accountid=200000001;
create sequence tranid_seq start with 5001 increment by 1;
create sequence transaction_seq start with 300000000 increment by 1;
delete from banktransactions;
SELECT CAST(transactiondate AS DATE) FROM banktransactions;
SELECT transactionid,CAST(transactiondate AS DATE),description,transferedamount FROM banktransactions WHERE custoid=100000000 and accountype='current'