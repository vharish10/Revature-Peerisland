create database BankingDB;
use BankingDB;

create table Customers
(
    CustomerId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(100) NOT NULL,
    Gender VARCHAR(10) NOT NULL,
    DateOfBirth DATE NOT NULL,
    PhoneNumber VARCHAR(15) UNIQUE NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    City VARCHAR(50),
    State VARCHAR(50),
    CustomerStatus VARCHAR(10) NOT NULL
);

create table Branches
(
    BranchId INT PRIMARY KEY AUTO_INCREMENT,
    BranchName VARCHAR(100) NOT NULL,
    BranchCode VARCHAR(20) UNIQUE NOT NULL,
    City VARCHAR(50),
    State VARCHAR(50),
    IFSCCode VARCHAR(20) UNIQUE NOT NULL
);

create table Accounts
(
    AccountId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerId INT NOT NULL,
    BranchId INT NOT NULL,
    AccountNumber VARCHAR(20) UNIQUE NOT NULL,
    AccountType VARCHAR(20) NOT NULL,
    OpenDate DATE NOT NULL,
    Balance DECIMAL(15,2) DEFAULT 0,
    AccountStatus VARCHAR(10) NOT NULL,
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
    FOREIGN KEY (BranchId) REFERENCES Branches(BranchId)
);

create table Transactions
(
    TransactionId INT PRIMARY KEY AUTO_INCREMENT,
    AccountId INT NOT NULL,
    TransactionDate DATETIME NOT NULL,
    TransactionType VARCHAR(20) NOT NULL,
    Amount DECIMAL(15,2) NOT NULL,
    Description VARCHAR(255),
    FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)
);

create table Loans
(
    LoanId INT PRIMARY KEY AUTO_INCREMENT,
    CustomerId INT NOT NULL,
    BranchId INT NOT NULL,
    LoanType VARCHAR(30) NOT NULL,
    LoanAmount DECIMAL(15,2) NOT NULL,
    InterestRate DECIMAL(5,2) NOT NULL,
    LoanStartDate DATE NOT NULL,
    LoanStatus VARCHAR(10) NOT NULL,
    FOREIGN KEY (CustomerId) REFERENCES Customers(CustomerId),
    FOREIGN KEY (BranchId) REFERENCES Branches(BranchId)
);

create table AccountAudit
(
    AuditId INT PRIMARY KEY AUTO_INCREMENT,
    AccountId INT NOT NULL,
    ActionType VARCHAR(50) NOT NULL,
    OldBalance DECIMAL(15,2),
    NewBalance DECIMAL(15,2),
    ActionDate DATETIME NOT NULL,
    Remarks VARCHAR(255),
    FOREIGN KEY (AccountId) REFERENCES Accounts(AccountId)
);

insert into Customers(CustomerName, Gender, DateOfBirth, PhoneNumber, Email, City, State, CustomerStatus)
values
('Harish', 'Male', '2004-10-10', '9047214841', 'reddyharish@gmail.com', 'Hosur', 'Tamil Nadu', 'Active'),
('Grsh', 'Female', '2006-03-26', '8774395032', 'grishithaaer2006@gmail.com', 'Bangalore', 'Karnataka', 'Active'),
('Rohit', 'Male', '2004-10-16', '9784237414', 'rohitrg10@gmail.com', 'Chennai', 'Tamil Nadu', 'Inactive'),
('Nikhil', 'Male', '2002-05-21', '8573854924', 'nikhilvilluri23@gmail.com', 'Vizag', 'Andhra Pradesh', 'Inactive'),
('Shashank', 'Male', '2003-11-01', '8546853453', 'shashankk1101@gmail.com', 'Mysore', 'Karnataka', 'Active');

select * from Customers;

insert into Branches(BranchName, BranchCode, City, State, IFSCCode)
value
('Bangalore Branch', 'BLR001', 'Bangalore', 'Karnataka', 'SBIN0001002'),
('Chennai Branch', 'CHN001', 'Chennai', 'Tamil Nadu', 'SBIN0001001'),
('Hyderabad Branch', 'HYD001', 'Hyderabad', 'Telangana', 'SBIN0001003');

select * from Branches;

insert into Accounts(CustomerId, BranchId, AccountNumber, AccountType, OpenDate, Balance, AccountStatus)
values
(1, 2, 'Acc101', 'Current', '2024-03-10', 25000, 'Active'),
(2, 1, 'Acc102', 'Current', '2025-02-15', 20000, 'Active'),
(3, 2, 'Acc103', 'Savings', '2023-03-20', 40000, 'Frozen'),
(4, 3, 'Acc105', 'Savings', '2021-03-20', 75000, 'Active'),
(5, 1, 'Acc104', 'Current', '2022-03-20', 10000, 'Frozen');

select * from Accounts;

insert into Transactions(AccountId, TransactionDate, TransactionType, Amount, Description)
values
(17, '2025-10-15', 'Deposit', 10000, 'Cash Deposit'),
(16, '2026-03-16', 'Withdrawal', 5000, 'ATM Withdrawal'),
(19, '2026-01-05', 'Withdrawal', 20000, 'ATM Withdrawal'),
(17, '2026-03-16', 'Withdrawal', 5000, 'ATM Withdrawal'),
(18, '2025-10-15', 'Deposit', 15000, 'Cash Deposit'),
(20, '2026-03-16', 'Deposit', 8000, 'Cash Deposit');

select * from Transactions;

insert into Loans(CustomerId, BranchId, LoanType, LoanAmount, InterestRate, LoanStartDate, LoanStatus)
values
(1, 2, 'Home Loan', 2500000, 7.5, '2024-02-01', 'Approved'),
(2, 1, 'Car Loan', 800000, 8.2, '2024-03-01', 'Pending'),
(3, 2, 'Personal Loan', 300000, 10.5, '2025-03-03', 'Closed'),
(4, 3, 'Car Loan', 800000, 8.2, '2023-06-01', 'Pending'),
(5, 1, 'Personal Loan', 300000, 10.5, '2024-03-01', 'Closed'),
(4, 3, 'Car Loan', 800000, 8.2, '2024-02-01', 'Pending'),
(5, 1, 'Personal Loan', 300000, 10.5, '2024-03-01', 'Closed');

insert into AccountAudit(AccountId, ActionType, OldBalance, NewBalance, ActionDate, Remarks)
values
(17, 'Deposit', 40000, 50000, '2025-10-15', 'Cash Deposit'),
(16, 'Withdrawal', 30000, 25000, '2026-03-16', 'ATM Withdrawal'),
(19, 'Withdrawal', 60000, 40000, '2026-01-05', 'ATM Withdrawal'),
(17, 'Withdrawal', 50000, 45000, '2026-03-16', 'ATM Withdrawal'),
(18, 'Deposit', 20000, 35000, '2025-10-15', 'Cash Deposit'),
(20, 'Deposit', 10000, 18000, '2026-03-16', 'Cash Deposit');

select CustomerId from Accounts
where Balance>(select avg(Balance) from Accounts);

select CustomerId from Loans
where LoanAmount>(select MAX(LoanAmount) from Loans where LoanType='Personal Loan');

select * from customers
where customerId IN (
select a.customerId
from Accounts a 
join Branches b 
ON a.branchId=b.branchId
where b.city='Chennai'
);

select * from Customers
where CustomerId NOT IN(select CustomerId from Loans);


select a.customerId from
Accounts a 
JOIN Transactions t
ON a.AccountId=t.AccountId
group by a.customerid
having sum(t.amount)>
(
	select SUM(t.Amount)
	from Accounts a2 
	join transactions t2 
	on a2.accountid=t2.accountid 
	where a2.customerid=1
);


select * from Accounts where Balance=(select max(Balance)
    from Accounts where Balance < (
        select max(Balance)
        from Accounts
    )
);

select * from Customers
where CustomerId IN (
    select CustomerId
    from Accounts
    where OpenDate = (
        select MIN(OpenDate)
        from Accounts
    )
);

select * from Loans
where CustomerId IN(
    select CustomerId
    from Accounts
    where AccountType = 'Savings'
);

select *
from Customers
where CustomerId in
(
    select CustomerId
    from Accounts
    group by CustomerId
    having COUNT(*) > 1
);

/*
VIEWS
*/

create view vw_CustomerAccountDetails as
select c.CustomerId, c.CustomerName, a.AccountNumber, a.AccountType, a.Balance, a.AccountStatus
from Customers c
join Accounts a
on c.CustomerId = a.CustomerId;

create view vw_BranchAccountSummary as
select b.BranchName, count(a.AccountId) as TotalAccounts, sum(a.Balance) as TotalBalance
from Branches b
left join Accounts a
on b.BranchId = a.BranchId
group by b.BranchName;

create view vw_LoanCustomerDetails as
select c.CustomerName, l.LoanType, l.LoanAmount, l.InterestRate, l.LoanStatus, b.BranchName
from Loans l
join Customers c 
on l.CustomerId = c.CustomerId
join Branches b
on l.BranchId = b.BranchId;

create view vw_HighValueAccounts as
select * from Accounts
where Balance>100000;

create view vw_DailyTransactions as
select a.AccountNumber, t.TransactionDate, t.TransactionType, t.Amount, t.description
from Transactions t
join Accounts a
on t.AccountId = a.AccountId;

create view vw_ActiveCustomers as
select * from Customers
where CustomerStatus = 'Active';

create view vw_ApprovedLoans as
select * from Loans
where LoanStatus = 'Approved';

create view vw_CustomerAccountBranch as
select c.CustomerName, a.AccountNumber, a.AccountType,a.Balance,b.BranchName,b.City
from Customers c
join Accounts a
on c.CustomerId = a.CustomerId
join Branches b
on a.BranchId = b.BranchId;

/* Stored Procedure  */

DELIMITER //
create procedure GetAllEmployees()
BEGIN
SELECT * FROM Employees;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE GetAccountsByCustomer(IN p_CustomerId INT)
BEGIN
SELECT * FROM Accounts
where CustomerId=p_CustomerId;
END //
DELIMITER ;

DELIMITER //
create procedure GetBranchTotalBalance(IN p_BranchId INT)
BEGIN
select b.BranchName, SUM(a.Balance) from 
branches b 
JOIN accounts a 
ON b.branchId=a.branchId
group by a.balance;
END //
DElIMITER ;

DELIMITER //
create procedure GetApprovedLoanCount(OUT p_TotalCount INT)
BEGIN 
select COUNT(*) INTO p_TotalCount
from loans
where LoanStatus='Approved';
END //
DELIMITER ;

DELIMITER //
create procedure AddTransaction(IN p_AccountId int,IN p_TransactionType varchar(20),IN p_Amount decimal(10,2),IN p_Description varchar(255))
BEGIN
    insert into Transactions(AccountId,TransactionDate,TransactionType,Amount,Description)
    values(p_AccountId,NOW(),p_TransactionType,p_Amount,p_Description);
END //
DELIMITER ;

DELIMITER //
create procedure GetCustomerLoans(IN p_CustomerId int)
BEGIN
	select * from Loans
    where CustomerId = p_CustomerId;
END //
DELIMITER ;

DELIMITER //
create procedure ChangeAccountStatus(IN p_AccountId int,IN p_NewStatus varchar(20))
BEGIN
    update Accounts
    set AccountStatus = p_NewStatus
    where AccountId = p_AccountId;
END //
DELIMITER ;