create database project;	

create table project.department(
	DepartmentId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(DepartmentId),
    DepartmentCode varchar(20) not null,
    DepartmentName varchar(255) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.ranks(
	RankId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(RankId),
    RankCode varchar(20) not null,
    RankName varchar(255) not null,
    Describle varchar(300) ,
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.account(
	AccountId char(36) character set ascii collate ascii_general_ci not null,
    primary key(AccountId),
    UserName varchar(255),
    PassWord varchar(255),
    GroupRole varchar(20),
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.address(
	AddressId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(AddressId),
    AccountId char(36) collate ascii_general_ci,
    constraint FK_AddressAccount foreign key (AccountId) references account(AccountId) ON DELETE SET NULL,
    Particular varchar(255) not null,
    Wards varchar(100) not null,
    District varchar(100) not null,
    Province varchar(100) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.conditions(
	ConditionId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(ConditionId),
    ConditionCode varchar(20) not null,
    ConditionName varchar(255) not null,
    Describle varchar(255),
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.delivery(
	DeliveryId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(DeliveryId),
    DeliveryCode varchar(20) not null,
    DeliveryName varchar(255) not null,
    Describle varchar(255),
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.payment(
	PaymentId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(PaymentId),
    PaymentCode varchar(20) not null,
    PaymentName varchar(255) not null,
    Describle varchar(255),
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.category(
	CategoryId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(CategoryId),
    CategoryCode varchar(20) not null,
    CategoryName varchar(255) not null,
    Describle varchar(300) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.product(
	ProductId char(36) character set ascii collate ascii_general_ci not null,
	primary key(ProductId),
    ProductCode varchar(20) not null,
	ProductName varchar(100) not null comment"Ten day du",
    Trademake varchar(100) not null comment"Tên thuong hieu",
    CategoryId char(36) collate ascii_general_ci,
    constraint FK_ProductCategory foreign key (CategoryId) references category(CategoryId) ON DELETE SET NULL,
    Describle varchar(300) not null,
	Image BLOB not null,
    Color varchar(50),
    Specifications varchar(300) not null comment"thông số kĩ thuật",
    Origin varchar(300) comment "địa chỉ cơ sở sản xuất",
	Version varchar(20) comment "phiên bản",
    ConditionOfProduct varchar(20) comment "tình trạng hiện tại của sản phẩm",
    Size varchar(20),
    Guarantee varchar(20) comment "thời hạn bảo hành",
    Price decimal(18,4),
    PriceSale decimal(18,4),
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.positions(
	PositionID char(36) character set ascii collate ascii_general_ci not null comment"khoa chinh voi gia tri la chuoi ki tu dai 36",
    primary key(PositionID),	
    PositionCode varchar(20) not null,
    PositionName varchar(255) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.employee(
	EmployeeID char(36) character set ascii collate ascii_general_ci not null,
    primary key(EmployeeID) comment"khoa chinh",
    EmployeeCode varchar(20) not null comment"Ma nhan vien",
    FullName varchar(100) not null comment"Ten day du",
    DateOfBirth date ,
    Gender int,
    PhoneNumber varchar(20) not null,
    IdentifyNumber varchar(25) not null ,
    IdentifyDate date,
    IdentifyPlace varchar(255),  
    Address varchar (255),
    Email varchar(100) not null,
    TaxCode varchar(255),
    Salary decimal(18,4),
    JoinDate date,
    WorkStatus int(11),
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266),
    image BLOB,
    AccountID char(36) collate ascii_general_ci,
    constraint FK_EmployeeAccount foreign key (AccountID) references account(AccountID) ON DELETE SET NULL,
    DepartmentID char(36) collate ascii_general_ci,
    constraint FK_EmployeeDepartment foreign key (DepartmentID) references department(DepartmentID) ON DELETE SET NULL,
    PositionID char(36) collate ascii_general_ci,
    constraint FK_EmployeePosition foreign key (PositionID) references positions(PositionID) ON DELETE SET NULL
);
create table project.customer(
	CustomerId char(36) character set ascii collate ascii_general_ci not null,
	primary key(CustomerId),
    CustomerCode varchar(20) not null,
	FullName varchar(100) not null comment"Ten day du",
    DateOfBirth date ,
    Gender int,
    PhoneNumber varchar(20) not null,
    IdentifyNumber varchar(25) not null ,
    RankId char(36) collate ascii_general_ci,
    constraint FK_CustomerRank foreign key (RankId) references ranks(RankId) ON DELETE SET NULL,
    AccountId char(36) collate ascii_general_ci,
    constraint FK_CustomerAccount foreign key (AccountId) references account(AccountId) ON DELETE SET NULL,
    Image BLOB,    
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
create table project.orders(
	OrderId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(OrderId),
    OrderCode varchar(20) not null,
    OrderDate date not null,
    ConditionId char(36) collate ascii_general_ci,
    constraint FK_OrderCondition foreign key (ConditionId) references conditions(ConditionId), 
    PaymentId char(36) collate ascii_general_ci,
	constraint FK_OrderPayment foreign key (PayId) references payment(PaymentId) ,
    AddressId char(36) collate ascii_general_ci,
    constraint FK_OrderAddress foreign key (AddressId) references address(AddressId) ,
    DeliveryId char(36) collate ascii_general_ci,
    constraint FK_OrderDelivery foreign key (DeliveryId) references delivery(deliveryId) ,
    TotalOfOrder decimal(18,4),
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
alter table project.line
drop foreign key FK_LineCustomer;
alter table project.line
add constraint FK_LineAccount foreign key (AccountId) references line(AccountId) ;

create table project.line(
	LineId char(36) character set ascii collate ascii_general_ci not null ,
    primary key(LineId),
    LineCode varchar(20) not null,
    CustomerId char(36) collate ascii_general_ci,
	constraint FK_LineCustomer foreign key (CustomerId) references customer(CustomerId) ON DELETE set null,
    ProductId char(36) collate ascii_general_ci,
    constraint FK_LineProduct foreign key (ProductId) references product(ProductId) ON DELETE SET NULL,
    OrderId char(36) collate ascii_general_ci,
    constraint FK_LineOrder foreign key (OrderId) references orders(OrderId) ON DELETE SET NULL,
	Quantity int not null,
	TotalPrice decimal(18,4),
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);


create table project.rate(
	RateId char(36) character set ascii collate ascii_general_ci not null ,
    primary key (RateId),
    RateCode varchar(20) not null,
    Scores int ,
    Image BLOB ,
    Describle varchar(1000),
    LineId char(36) collate ascii_general_ci ,
    constraint FK_RateLine foreign key (LineId) references line(LineId) ON DELETE SET NULL,
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);

create table project.role(
	RoleId char(36) character set ascii collate ascii_general_ci not null ,
    primary key (RoleId),
    RoleCode varchar(20) not null,
    RoleName varchar(255),
    Describle varchar(1000),
	CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
alter table project.line
add constraint FK_LineCustomer foreign key (CustomerId) references customer(CustomerId) ;
alter table project.users_role add constraint FK1kmfay84p19txj02exumwuq6 foreign key (AccountId) references account(AccountId);
create table project.users_role(
	AccountId char(36) collate ascii_general_ci ,
    constraint FK_Account foreign key (AccountId) references account(AccountId),
    RoleId char(36) collate ascii_general_ci ,
    constraint FK_Role foreign key (RoleId) references role(RoleId)
)
