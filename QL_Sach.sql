CREATE DATABASE QUAN_LY_SACH_NHOM8

CREATE TABLE SACH(
MaSach varchar(10) not null PRIMARY KEY,
TenSach nvarchar(50) not null,
TenTacGia nvarchar(50) not null,
LoaiSach nvarchar(30) not null,
SoLuong int not null,
NamXuatBan int not null,
GiaSach float not null
);

create table ACCOUNT(
	usename varchar(50) primary key not null,
	pass varchar(50) not null,
	confirm varchar(50) not null,
)