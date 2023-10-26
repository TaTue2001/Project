Create database Project;

-- tạo bảng phòng ban
create table Project.department(
	DepartmentId char(36) character set ascii collate ascii_general_ci not null comment"khoa chinh voi gia tri la chuoi ki tu dai 36",
    primary key(DepartmentId),
    DepartmentCode varchar(20) not null,
    DepartmentName varchar(255) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
-- tạo bảng vị trí
create table Project.position(
	PositionID char(36) character set ascii collate ascii_general_ci not null comment"khoa chinh voi gia tri la chuoi ki tu dai 36",
    primary key(PositionID),	
    PositionCode varchar(20) not null,
    PositionName varchar(255) not null,
    CreateDate date,
    CreateBy varchar(255),
    ModifiedDate date ,
    ModifiedBy varchar(266)
);
-- tạo bảng nhân viên
create table Project.employee(
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
    DepartmentID char(36) collate ascii_general_ci,
    PositionID char(36) collate ascii_general_ci,
    Constraint FK_Department foreign key (DepartmentID) references department(DepartmentID) on delete set null,
	Constraint FK_Position  foreign key (PositionID) references positions(PositionID) on delete set null
);